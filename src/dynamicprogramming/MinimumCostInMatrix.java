package dynamicprogramming;

public class MinimumCostInMatrix {
	
	static int minCost(int[][] costMatrix, int m, int n) {
		if(m <=0|| n < 0) {
			return Integer.MAX_VALUE;
		}
		if(m==0 && n==0) {
			return costMatrix[m][n];
		}
		
		 return costMatrix[m][n] + Math.min(minCost(costMatrix, m-1, n-1), Math.min(minCost(costMatrix, m-1, n), minCost(costMatrix, m, n-1)));
	}

	public static void main(String[] args) {
		int[][] cost = { {1,2,3},
				{4, 8, 2},
				{1,5,3}				
		};
		
		System.out.println(minCost(cost, 2, 2));

	}

}
