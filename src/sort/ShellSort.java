package sort;

public class ShellSort<T extends Comparable<T>> extends BaseSort<T>  {
	

	public T[] sort(T[] array) {
		System.out.println("Initial array: " + toString(array));
		
		//calculate initial h
		int h =1;
		while(h <= array.length/3) {
			h = 3*h +1;
		}
		
		while(h > 0) {
			for(int outer = h; outer < array.length;  outer = outer +h) {			
				for(int inner = outer; inner -h >= 0; inner = inner -h) {
					if(array[inner-h].compareTo(array[inner]) > 0) {
						swap(array, inner, inner-h);
					}
					
				}
			}
			System.out.println("With h:" + h + " " + toString(array));
			h = (h-1)/3;
		}
		return array;
	}
	
	
	public static void main(String[] args) {
		ShellSort<Integer> shellSort = new ShellSort<>();
		shellSort.sort(new Integer[]{20, 30, 5, 89, 100, 4, 2, 7, 18, 24});
	}

}
