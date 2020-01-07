package sort;

public class InsertionSort {

	static void sort(int[] arr) {
		System.out.println("Initial array: " + toString(arr));
		for (int i = 1; i < arr.length; i++) {
			int j = i - 1;
			int temp = arr[i];
			while (j >= 0 && temp < arr[j]) {
				arr[j + 1] = arr[j];
				j--;
			}

			arr[j + 1] = temp;

			System.out.println("After (" + i + ") iteration: " + toString(arr));
		}
	}

	static String toString(int[] arr) {
		StringBuilder sb = new StringBuilder();
		for (int value : arr) {
			sb.append(value + " ");
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		int[] array = { 20, 30, 5, 89, 100, 4, 2, 7 };
		sort(array);

	}

}
