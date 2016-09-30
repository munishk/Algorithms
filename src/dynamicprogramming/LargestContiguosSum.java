package dynamicprogramming;

/**
 * http://www.geeksforgeeks.org/largest-sum-contiguous-subarray/
 * @author munishk
 *
 */
public class LargestContiguosSum {
	
	static int maxSum(int[] arr) {
		int maxSum = arr[0]; int sum =0;
		if(arr[0] > 0) {
			sum = arr[0];
		}
		
		for(int i=1; i<arr.length;i++) {
			if(sum + arr[i] > sum) {  // this means, arr[i] > 0
				sum = arr[i] + sum;
				maxSum = Math.max(sum, maxSum);
			}else {
				// arr[i] < 0
				if(maxSum < arr[i]) {
					maxSum = arr[i];
				}
				sum = 0; //reset sum
			}
		}
		return maxSum;
	}

	public static void main(String[] args) {
		int[] arr = {-2,-3,-1,-4, 1};
		System.out.println(maxSum(arr));

	}

}
