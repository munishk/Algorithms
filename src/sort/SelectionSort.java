package sort;

/**
 * Initial array: 20 30 5 89 100 4 2 7 
 * After Phase 0: 2 30 20 89 100 5 4 7 
 * After Phase 1: 2 4 30 89 100 20 5 7 
 * After Phase 2: 2 4 5 89 100 30 20 7 
 * After Phase 3: 2 4 5 7 100 89 30 20 
 * After Phase 4: 2 4 5 7 20 100 89 30 
 * After Phase 5: 2 4 5 7 20 30 100 89 
 * After Phase 6: 2 4 5 7 20 30 89 100 
 * After Phase 7: 2 4 5 7 20 30 89 100 
 * @author munishk
 *
 * @param <T>
 */
public class SelectionSort<T extends Comparable<T>> extends BaseSort<T> {
	
	public T[] sort(T[] array) {
		System.out.println("Initial array: " + toString(array));
		for(int i = 0; i < array.length; i++) {
			for(int j = i +1; j< array.length; j++) {
				if(array[i].compareTo(array[j]) > 0) {
					swap(array, i, j);
				}
			}
			System.out.println("After Phase " + i + ": " + toString(array));
		}
		return array;
	}
	
	public static void main(String[] args) {
		SelectionSort<Integer> selectionSort = new SelectionSort<>();
		selectionSort.sort(new Integer[]{20, 30, 5, 89, 100, 4, 2, 7});
	}

}
