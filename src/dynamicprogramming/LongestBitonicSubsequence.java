package dynamicprogramming;

import util.StringUtils;

/**
 * http://www.geeksforgeeks.org/dynamic-programming-set-15-longest-bitonic-subsequence/
 * @author munishk
 *
 */
public class LongestBitonicSubsequence {
	
	/*
	 * Calculate 
	 *     - lis [] - longest increasing subsequence starting from left.
	 *     - lds [] - longest increasing subsequence starting from right.
	 *     - lbs = max(lis[i] + lds[i] -1)
	 *        
	 */
	static int longestBitonicSequence(int[] arr, int n) {
		//Init LIS & LDS to be 1 for all indices
		int[] lis = new int[n+1];
		int[] lds = new int[n+1];
		for(int i=0;i<=n;i++) {
			lis[i] =1;
			lds[i] =1;
		}
		
		//Compute LIS
		for(int i=1; i<=n;i++) {
			for(int j=0; j<i;j++) {
				if(arr[i] > arr[j] && lis[i] < lis[j] +1) {
					lis[i] = lis[j] +1;
				}
			}
		}
		
		//Compute LDS
		for(int i=n-1; i>=0;i--) {
			for(int j=n;j>i;j--) {
				if(arr[i] > arr[j] && lds[i] < lds[j] +1) {
					lds[i] = lds[j] +1;
				}
			}
		}
		
		System.out.println("LIS: " + StringUtils.toString(lis));
		System.out.println("LDS: " + StringUtils.toString(lds));
		
		//Compute LBS
		int max = lis[0] + lds[0] -1;
		for(int i=1; i<=n;i++) {
			if(max < (lis[i] + lds[i]-1)) {
				max = lis[i] + lds[i] -1;
			}
		}
		
		return max;
	}
	

	public static void main(String[] args) {
		int[] arr = {1,11,2,10,4,5,2,1};
		System.out.println(longestBitonicSequence(arr, arr.length-1));

	}

}
