package dynamicprogramming;

/**
 * http://www.geeksforgeeks.org/dynamic-programming-set-14-maximum-sum-increasing-subsequence/
 * 
 * @author munishk
 *
 */
public class MaxSumIncreasingSubsequence {
	
	int globalMax = 0;

	 int maxSum(int[] arr, int n) {
		if (n == 0) {
			return arr[n];
		}
		int max = 0;
		for (int i = 0; i < n; i++) {
			int res = maxSum(arr, i);
			if (arr[i] < arr[n]) {
				res = arr[n] + res;
				if (res > max) {
					max = res;
				}
			}
		}
		//update global max...
		if(globalMax < max) {
			globalMax = max;
		}
		
		return max;
	}
	 
	 static int maxSumTabular(int[] arr, int n) {
		 int[] temp = new int[n+1];
		 temp[0] = arr[0];
		 for(int i=1; i<=n;i++) {
			 for(int j=0; j<i;j++) {
				 if(arr[j] < arr[i] && arr[i] < arr[i] + arr[j]) {
					 arr[i] = arr[j] + arr[i];
				 }
			 }
		 }
		 return temp[n];
	 }

	public static void main(String[] args) {
		int[] arr = { 1, 101, 2, 3, 100, 4, 5 };
		MaxSumIncreasingSubsequence o = new MaxSumIncreasingSubsequence();
		o.maxSum(arr, arr.length - 1);
		System.out.println(o.globalMax);
	}
}
