package sort;

import java.util.Arrays;
import java.util.Random;

/**
 * @author Abhay Rijhwani
 *         Performs a parallel merge sort using Batcher's Odd Even Algorithm
 *         The corresponding functions representing Peril L were implemented
 *         1. Localize - Creates a thread local copy of the global data structure to be sorted.
 *         2. Barrier - The calling thread wait till the spawned threads join.
 *         3. Merge Sort - The Merge Sort routine was implemented which works on sorting the left and right parts on different threads and then a merge is performed
 *         Machine Specs
 *         4. The algorithm is as follows:
 *              a. Generate Random numbers for sorting.
 *              b. Pass in the random numbers and thread count for initialization
 *              c. The random array is split into halves, with each half being handled by different threads/processors.
 *              d. Once the processors have sorted their allocation of arrays, the calling processor waits on a barrier for the threads to complete and performs a merge.
 *              e. It is important to note that while Peril-L emphasizes collaboration via E/F variables, such a concept is not used in Java. In Java, threads are spawned recursively
 *                 and they wait via a barrier for the spawned threads to complete. This is more like a top down approach, wherein the parent thread spawns child threads while allocating
 *                 them work and synchronizing via the Barrier.
 *         5. The machine specs are as follows:
 *                  4 cores, 2 GHz, Intel CPU, 2 L1 caches of 32KB, L2 cache of 3 MB, 6 GB of DRAM
 *         6. Sample output with 8 threads and 24 numbers:
 *                  Unsorted Array:199,198,604,720,532,624,595,265,471,175,695,668,260,508,941,715,921,643,875,145,109,882,24,133
                    Sorted Array:24,109,133,145,175,198,199,260,265,471,508,532,595,604,624,643,668,695,715,720,875,882,921,941
                    Time take in Milliseconds:8
           7.   Sample output with 16 threads and 24 numbers:
 *                  Unsorted Array:945,648,639,838,824,404,931,274,114,113,670,442,124,839,561,661,141,96,384,585,15,843,129,627
                    Sorted Array:15,96,113,114,124,129,141,274,384,404,442,561,585,627,639,648,661,670,824,838,839,843,931,945
                    Time take in Milliseconds:14
           8.   Sample output with 10^6 numbers and 1 thread
                    Time take in Milliseconds:270
                Sample output with 10^6 numbers and 4 threads
                    Time take in Milliseconds:189
                Sample output with 10^6 numbers and 12 threads
                    Time take in Milliseconds:312
           9. Sample output with 24 numbers and 1 thread
                    Time take in Milliseconds:1
           10. Observation -
                a) As evident from #8, When the thread size is scaled beyond 4, since there are only 4 cores and threads are always busy, scaling beyond 4 threads does not yield performance gains.
                b) As evident from #7, with increased threads, the context switch(thread communication) penalty is more than the performance gain.
                c) As evident from #9, when the input size is small, single threaded solution is the most efficient due to reasons mentioned in b)

 *
 */
public class ParallelMergeSort {

    public static void main(String[] args) {
        //Generate a Random Array
        int[] arrayToBeSorted = generateRandomArray(24);
        System.out.print("Unsorted Array:");
        print(arrayToBeSorted);
        long startTime = System.currentTimeMillis();
        //Sort the Random Array
        new SortThreadInstance().parallelMerge(arrayToBeSorted, 1);
        long endTime = System.currentTimeMillis();
        System.out.print("Sorted Array:");
        //Print the SortedArray
        print(arrayToBeSorted);
        System.out.println("Time take in Milliseconds:"+String.valueOf(endTime-startTime));

    }

    /**
     * generate a random array
     *
     * @param length
     * @return
     */
    private static int[] generateRandomArray(int length) {
        int[] a = new int[length];
        //Generate a random seed and use a deterministic random number generator
        Random rand = new Random(System.currentTimeMillis());
        for (int i = 0; i < length; i++) {
            //Generate a random number between 0 and 999
            a[i] = rand.nextInt(999);
        }
        return a;
    }

    /**
     * print an array
     * @param a
     */
    public static void print(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.printf(String.valueOf(a[i]));
            if ((i + 1) != a.length) {
                System.out.printf(",");
            }

        }
        System.out.printf("\n");
    }
}

/**
 * Represents an instance of a sort thread
 */
class SortThreadInstance implements Runnable{

    private int[] numbersToSort;
    private int numberOfThreads;

    /**
     * The equivalent of Peril L localize
     * @param globalArray
     * @param startIndex
     * @param length
     * @return
     */
    private int[] localize(int[] globalArray, int startIndex, int length){
        return Arrays.copyOfRange(globalArray, startIndex, length);
    }


    /**
     * The barrier function wherein we wait for the threads to complete.
     * @param t1
     * @param t2
     */
    private void barrier(Thread t1, Thread t2){
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException ie) {
            System.out.println("Exception Encountered:"+ie);
        }
    }

    public void serialMerge(int[] numbersToSort){
        int lengthOfArray = numbersToSort.length;
        if (numbersToSort.length >= 2) {
            //This is the java alternative of Peril-L localize() function. It creates a local copy of the array and the size is based on the size of data to sort.
            int[] leadingPart = Arrays.copyOfRange(numbersToSort, 0, lengthOfArray / 2);
            int[] trailingPart = Arrays.copyOfRange(numbersToSort, lengthOfArray / 2, lengthOfArray);

            // sort the halves
            serialMerge(leadingPart);
            serialMerge(trailingPart);

            // merge them back together
            merge(leadingPart, trailingPart, numbersToSort);
        }
    }

    public  void parallelMerge(int[] numbersToSort, int threadCount) {
        int lengthOfArray = numbersToSort.length;
        if (threadCount <= 1) {
            serialMerge(numbersToSort);
        } else if (lengthOfArray >= 2) {
            //This is the java alternative of Peril-L localize() function. It creates a local copy of the array and the size is based on the size of data to sort.
            int[] leadingPart = localize(numbersToSort, 0, lengthOfArray / 2);
            int[] trailingPart = localize(numbersToSort, lengthOfArray / 2, numbersToSort.length);
            //Create a Thread for Sorting. The Threads are created recursively until 1 thread is reached, at which point the sorting is serial.
            Thread leadingPartSorterThread = initializeThread(leadingPart,threadCount/2);
            Thread trailingPartSorterThread = initializeThread(trailingPart,threadCount/2);
            //Start the Threads
            startSorterThreads(leadingPartSorterThread,trailingPartSorterThread);
            //Wait for the threads to complete
            barrier(leadingPartSorterThread, trailingPartSorterThread);
            //Merge the halves
            merge(leadingPart, trailingPart, numbersToSort);
        }
    }

    /**
     * Start the Sorter Threads
     * @param t1
     * @param t2
     */
    private void startSorterThreads(Thread t1, Thread t2){
        t1.start();
        t2.start();
    }

    /**
     *
     * @param numbersToSort
     * @param numberOfThreads
     * @return
     */
    private Thread initializeThread(int[] numbersToSort, int numberOfThreads){
        SortThreadInstance s= new SortThreadInstance();
        s.setNumbersToSort(numbersToSort);
        s.setNumberOfThreads(numberOfThreads);
        return new Thread(s);
    }


    /**
     * Merge two sorted sequences
     * @param leadingPart
     * @param trailingPart
     * @param a
     */

    public void merge(int[] leadingPart, int[] trailingPart, int[] a) {
        int i=0,j=0,k=0;
        //Merge side by side
        while(leadingPart.length > i && trailingPart.length > j){
            if(leadingPart[i]<trailingPart[j]){
                a[k++]=leadingPart[i++];
            }
            else{
                a[k++]=trailingPart[j++];
            }
        }
        //Merge remaining
        while (leadingPart.length > i){
            a[k++]=leadingPart[i++];
        }
        while (trailingPart.length > j){
            a[k++]=trailingPart[j++];
        }
    }

    public void setNumberOfThreads(int numberOfThreads) {
        this.numberOfThreads = numberOfThreads;
    }

    public void setNumbersToSort(int[] numbersToSort) {
        this.numbersToSort = numbersToSort;
    }

    public void run(){
        parallelMerge(numbersToSort, numberOfThreads);
    }


}


