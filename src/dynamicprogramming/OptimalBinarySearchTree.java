package dynamicprogramming;

/**
 * http://www.geeksforgeeks.org/dynamic-programming-set-24-optimal-binary-search-tree/
 * @author munishk
 *
 */
public class OptimalBinarySearchTree {
	
	static int optimalCost(int[] freq, int start, int end) {
		if(end < start) {
			return 0;
		}
		
		if(start == end) {
			return freq[start];
		}
		
		int sum = sum(freq, start, end);
		int min = Integer.MAX_VALUE;
		for(int r=start; r<=end;r++) {
			int cost = optimalCost(freq, start, r-1) + optimalCost(freq, r+1, end);
			if(cost < min) {
				min = cost;
			}
		}
		return min + sum;
	}
	
	static int optimalCostTabular(int[] freq, int n) {
		int[][] temp = new int[n][n];
		
		for(int i=0; i<n;i++) {
			temp[i][i] = freq[i];
		}
		
		
		for(int L=2; L<=n;L++) {
			for(int i=0; i+L <= n; i++) {
				int j = i + L -1;
				
				int sum = sum(freq, i, j);
				temp[i][j] = Integer.MAX_VALUE;
				for(int r=i; r<=j;r++)  {
					int leftCost = r-1 < i?0 :temp[i][r-1];
					int rightCost = r+1 > j?0: temp[r+1][j];
					int cost = leftCost + rightCost + sum;
					if(cost  < temp[i][j]) {
						temp[i][j] = cost;
					}
				}
			}
		}
		return temp[0][n-1];
	}
	
	static int sum(int[] freq, int low, int high) {
		int sum = 0;
		for(int i = low; i<=high; i++) {
			sum+=freq[i];
		}
		return sum;
	}
	

	public static void main(String[] args) {
		int[] keys = {10,12,20};
		int[] freq = {34,8,50};

		System.out.println(optimalCost(freq, 0, freq.length-1));
		System.out.println(optimalCostTabular(freq, freq.length));
	}

}
