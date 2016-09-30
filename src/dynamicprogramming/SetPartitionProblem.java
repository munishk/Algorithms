package dynamicprogramming;

import util.StringUtils;

/**
 * http://www.geeksforgeeks.org/dynamic-programming-set-18-partition-problem/
 * @author munishk
 *
 */
public class SetPartitionProblem {
	
	static class Result {
		int[] set1, set2;

		public Result(int[] set1, int[] set2) {
			super();
			this.set1 = set1;
			this.set2 = set2;
		}
	}
	
	static Result partitionSet(int[] set) {
		
		//first calculate the sum
		int sum =0;
		for(int i=0;i <set.length;i++) {
			sum+= set[i];
		}
		
		//If sum is not divisible by 2, then solution does not exist.
		if(sum %2 == 1) {
			return null;
		}
		
		int[] set1 = new int[set.length];
		int set1Size = subsetSum(set, set.length, sum/2, set1, 0);
		
		if(set1Size == -1) {
			return null;
		}
		
		return new Result(set1, null);
	}

	static int subsetSum(int[] set, int n, int sum, int[] result, int resultIndex) {
		if(sum == 0) {
			return resultIndex;
		}
		
		if(n == 0) {
			return -1;
		}
		
		if(set[n-1] > sum) {
			return subsetSum(set, n-1, sum, result, resultIndex);
		}
		
		//Include nth element
		result[resultIndex] = set[n-1];
		int res = subsetSum(set, n-1, sum - set[n-1], result, resultIndex+1);
		if(res != -1) {
			return res;
		}
		
		return subsetSum(set, n-1, sum, result, resultIndex);
	}
	
	public static void main(String[] args) {
		int[] set = {3,1,5,9,12};
		
		Result res = partitionSet(set);
		System.out.println(StringUtils.toString(res.set1));

	}

}
