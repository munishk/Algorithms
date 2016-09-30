package dynamicprogramming;

/**
 * http://www.geeksforgeeks.org/dynamic-programming-set-10-0-1-knapsack-problem/
 * @author munishk
 *
 */
public class Knapsack01Problem {
	
	/*
	 * wts[] - input array containing weights
	 * values[] - values for corresponding weight
	 * n - n'th item
	 * weight - remaining weight
	 */
	static int knapsackRecur(int[] wts, int[] values, int n, int weight) {
		if(n == 0 || weight == 0) {
			return 0;
		}
		
		if(wts[n-1] > weight) {
			return knapsackRecur(wts, values, n-1, weight);
		}
		
		return Math.max(values[n-1] + knapsackRecur(wts, values, n-1, weight - wts[n-1]), knapsackRecur(wts, values, n-1, weight));
	}

	public static void main(String[] args) {
		int[] wts = {10,20,30};
		int[] values = {60,100,120};
		
		System.out.println(knapsackRecur(wts, values, wts.length, 50));
	}

}
