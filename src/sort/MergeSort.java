package sort;

public class MergeSort {

	static class CounterHolder {
		static int value;

		static int incrementAndGet() {
			return ++value;
		}
	}

	static void sort(int[] arr, int low, int high, int[] helper) {
		if (low >= high) {
			return;
		}

		int mid = (low + high) / 2;

		sort(arr, low, mid, helper);
		sort(arr, mid + 1, high, helper);
		merge(arr, helper, low, high, mid);

		System.out.println("After (" + CounterHolder.incrementAndGet() + ") iteration: " + toString(arr));
	}

	static void merge(int[] arr, int[] helper, int low, int high, int mid) {
		System.arraycopy(arr, low, helper, low, high - low + 1);

		int left = low;
		int right = mid + 1;
		int targetIndex = low;
		while (left <= mid && right <= high) {
			if (helper[left] <= helper[right]) {
				arr[targetIndex++] = helper[left++];
			} else {
				arr[targetIndex++] = helper[right++];
			}
		}

		while (left <= mid) {
			arr[targetIndex++] = helper[left++];
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
		int[] helper = new int[array.length];
		System.out.println("Initial array: " + toString(array));
		sort(array, 0, array.length - 1, helper);

	}

}
