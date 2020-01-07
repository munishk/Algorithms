package sort;

import util.StringUtils;

public class HeapSort {

	static void sort(int[] arr) {
		int n = arr.length;
		for (int i = 1; i < n; i++) {
			heapify(arr, i);
			System.out.println("After (" + i + ") heapification: " + StringUtils.toString(arr));
		}

		for (int i = 0; i < n; i++) {
			int temp = arr[0];
			arr[0] = arr[n-1-i];
			tricleDown(arr, n - 1 - i);
			arr[n - 1 - i] = temp;
			System.out.println("After (" + i+1 + ") heapification: " + StringUtils.toString(arr));
		}

	}

	static void heapify(int[] arr, int index) {
		int current = index;
		int rootIndex = (index - 1) / 2;
		while (current > 0) {
			if (arr[rootIndex] <= arr[current]) {
				swap(arr, current, rootIndex);
			}
			current = rootIndex;
			rootIndex = (current - 1) / 2;
		}
	}

	static void tricleDown(int[] arr, int n) {
		int current = 0;
		int largest = current;
		int left = 1;
		int right = 2;
		while (left < n || right < n) {
			if (right < n && arr[right] > arr[largest]) {
				largest = right;
			} 
			if (left < n && arr[left] > arr[largest]) {
				largest = left;
			}
			if(largest == current) {
				break;
			}
			swap(arr, current, largest);
			current = largest	;
			left = 2 * current + 1;
			right = 2 * current + 2;
		}
	}

	static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static void main(String[] args) {
		int[] array = { 20, 30, 5, 89, 100, 4, 2, 7 };
		System.out.println("Initial array: " + StringUtils.toString(array));
		sort(array);

	}

}
