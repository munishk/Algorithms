package dynamicprogramming;

/**
 * http://www.geeksforgeeks.org/dynamic-programming-set-6-min-cost-path/
 * @author munishk
 *
 */
public class MinCostPath {
	
	static int minCostRecursive(int[][] cost, int m, int n) {
		if( m==0 && n ==0) {
			return cost[m][n];
		}
		if(n < 0 | m < 0) {
			return Integer.MAX_VALUE;
		}
		
		return cost[m][n] + min(minCostRecursive(cost, m-1, n), minCostRecursive(cost, m, n-1), minCostRecursive(cost, m-1, n-1)); 
		
	}
	
	
	static int minCostTabular(int[][] cost, int m, int n) {
		int[][] temp = new int[m+1][n+1];
		
		for(int i=0; i<=m; i++) {
			for(int j =0; j<=n; j++) {
				if(i ==0 && j ==0) {
					temp[i][j] = cost[i][j];
				}else {
					int costLeft = Integer.MAX_VALUE;
					if(j-1 >= 0) {
						costLeft = temp[i][j-1];
					}
					
					int costUp = Integer.MAX_VALUE;
					if(i-1 >=0) {
						costUp = temp[i-1][j];
					}
					
					int costDiaonal = Integer.MAX_VALUE;
					if(i-1>=0 && j-1>=0) {
						costDiaonal = temp[i-1][j-1];
					}
					temp[i][j] = cost[i][j] +min(costLeft, costUp, costDiaonal);
				}	
			}
		}
		return temp[m][n];
	}

	static int min(int a, int b, int c) {
		return Math.min(Math.min(a, b), c);
	}
	
	public static void main(String[] args) {
		int[][] cost = {
				{1, 2, 3},
                {4, 8, 2},
                {1, 5, 3}
		};
		
		System.out.println(minCostRecursive(cost, cost.length-1, cost[0].length-1));
		System.out.println(minCostTabular(cost, cost.length-1, cost[0].length-1));

	}

}
