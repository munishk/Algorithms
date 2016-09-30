package dynamicprogramming;

/**
 * http://www.geeksforgeeks.org/dynamic-programming-set-13-cutting-a-rod/
 * @author munishk
 *
 */
public class CuttingRodProblem {
	
	static int solve(int[] prices, int n) {
		if(n ==0) {
			return 0;
		}
		
		int max = prices[n-1];
		for(int i=1; i<n;i++) {
			int res = solve(prices, i) + solve(prices, n-i);
			if(res > max) {
				max = res;
			}
		}
		return max;
	}
	
	static int solveIterative(int[] prices, int n) {
		int[] temp = new int[n+1];
		for(int i=0;i<n;i++) {
			temp[i+1] = prices[i];
		}
		
		for(int i=2;i<=n;i++) {
			int max = temp[i];
			for(int j=1; j < i; j++) {
				int res = temp[j] + temp[i-j];
				if(res > max) {
					max = res;
				}
			}
			temp[i] = max;
		}
		return temp[n];
	}

	public static void main(String[] args) {
		int[] prices = {1,5,8,9,10,17,17,20};
		System.out.println(solve(prices, 8));

	}

}
