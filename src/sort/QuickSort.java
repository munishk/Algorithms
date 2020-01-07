package sort;

import util.StringUtils;

import java.util.Stack;

public class QuickSort {

	static class Pair {
		int low, high;

		public Pair(int low, int high) {
			super();
			this.low = low;
			this.high = high;
		}

	}

	/*
	 * Iterative quick sort
	 * 
	 */
	static void quickSortIterative(int[] arr, int low, int high) {
		Stack<Pair> stack = new Stack<>();
		stack.push(new Pair(low, high));

		while (!stack.isEmpty()) {
			Pair pair = stack.pop();
			int left = pair.low;
			int right = pair.high;
			if (left < right) {
				int mid = (left + right) / 2;
				int pivot = arr[mid];
				int pivotIndex = partitionUsingMiddleElement(arr, left, right, mid);
				System.out
						.println("Pivot: " + pivot + ",Pivot Index: " + pivotIndex + ": " + StringUtils.toString(arr));
				stack.push(new Pair(pivotIndex + 1, right));
				stack.push(new Pair(left, pivotIndex));
				
			}

		}

	}

	/*
	 * Quick sort using last element as pivot
	 */
	static void quickSortLastPivot(int[] arr, int low, int high) {
		if (low < high) {
			int pivotIndex = partitionUsingLastElement(arr, low, high);
			System.out
					.println("Pivot: " + arr[high] + ",Pivot Index: " + pivotIndex + ": " + StringUtils.toString(arr));
			quickSortLastPivot(arr, low, pivotIndex);
			quickSortLastPivot(arr, pivotIndex + 1, high);
		}
	}

	static int partitionUsingLastElement(int[] arr, int low, int high) {
		int pivot = arr[high];
		int j = -1;
		for (int i = 0; i < high; i++) {
			if (arr[i] <= pivot) {
				j++;
				swap(arr, i, j);
			}
		}
		swap(arr, j + 1, high);
		return j;
	}

	/*
	 * Quick sort using middle element as pivot.
	 */
	static void quickSortMiddlePivot(int[] arr, int low, int high) {
		if (low < high) {
			int mid = (low + high) / 2;
			int pivot = arr[mid];
			int pivotIndex = partitionUsingMiddleElement(arr, low, high, mid);
			System.out.println("Pivot: " + pivot + ",Pivot Index: " + pivotIndex + ": " + StringUtils.toString(arr));
			quickSortMiddlePivot(arr, low, pivotIndex);
			quickSortMiddlePivot(arr, pivotIndex + 1, high);
		}
	}

	static int partitionUsingMiddleElement(int[] arr, int low, int high, int mid) {
		int pivot = arr[mid];
		while (low <= high) {
			if (arr[low] > pivot) {
				swap(arr, low, high);
				high--;
			} else if (arr[high] <= pivot) {
				swap(arr, low, high);
				low++;
			} else {
				low++;
				high--;
			}
		}
		return low - 1;
	}

	private static void swap(int[] a, int left, int right) {
		int temp = a[left];
		a[left] = a[right];
		a[right] = temp;
	}

	public static void main(String[] args) {
		int[] arr = { 100, 89, 5, 20, 30, 4, 2, 7 };
		System.out.println("Initial array:" + StringUtils.toString(arr));
		System.out.println("Quick sort with middle element as pivot");
		quickSortMiddlePivot(arr, 0, arr.length - 1);

		int[] arr1 = { 100, 89, 5, 20, 30, 4, 2, 7 };
		System.out.println("Iterative Quick sort");
		quickSortIterative(arr1, 0, arr1.length - 1);
		// System.out.println("Quick sort with last element as pivot");
		// quickSortLastPivot(a, 0, a.length-1);

	}

}
