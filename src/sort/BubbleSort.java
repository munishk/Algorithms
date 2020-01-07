package sort;
/**
 * Initial array: 20 30 5 89 100 4 2 7 
 * After Phase 0: 20 5 30 89 4 2 7 100 
 * After Phase 1: 5 20 30 4 2 7 89 100 
 * After Phase 2: 5 20 4 2 7 30 89 100 
 * After Phase 3: 5 4 2 7 20 30 89 100 
 * After Phase 4: 4 2 5 7 20 30 89 100 
 * After Phase 5: 2 4 5 7 20 30 89 100 
 * After Phase 6: 2 4 5 7 20 30 89 100 
 * After Phase 7: 2 4 5 7 20 30 89 100 
 * 
 * @author munishk
 *
 * @param <T>
 */
public class BubbleSort<T extends Comparable<T>> extends BaseSort<T> {
	
	public T[] sort(T[] array) {
		System.out.println("Initial array: " + toString(array));
		for(int i =0; i < array.length; i++) {
			for(int j=0; j< array.length -1; j++) {
				if(array[j].compareTo(array[j+1]) > 0) {
					swap(array, j, j+1);
				}
			}
			System.out.println("After Phase " + i + ": " + toString(array));
		}
		return array;
	}
	
	
	public static void main(String[] args) {
		BubbleSort<Integer> bubbleSort = new BubbleSort<>();
		bubbleSort.sort(new Integer[]{20, 30, 5, 89, 100, 4, 2, 7});
	}
	
}
