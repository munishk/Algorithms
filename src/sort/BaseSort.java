package sort;

public abstract class BaseSort<T extends Comparable<T>> {
	protected String toString(T[] array) {
		StringBuilder strBuilder = new StringBuilder();
		for(T item: array) {
			strBuilder.append(item + " ");
		}
		return strBuilder.toString();
	}

	protected void swap(T[] array, int i, int j) {
		T temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	
}
