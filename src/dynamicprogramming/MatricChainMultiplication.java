package dynamicprogramming;
/**
 * http://www.geeksforgeeks.org/dynamic-programming-set-8-matrix-chain-multiplication/
 * @author munishk
 *
 */
public class MatricChainMultiplication {
	
	static int matrixChainOrder(int[] matrix, int i, int j) {
		if(i == j) {
			return 0;
		}
		int minCost = Integer.MAX_VALUE;
		for(int k=i; k<j; k++) {
			int cost = matrixChainOrder(matrix, i, k) + matrixChainOrder(matrix, k+1, j) + matrix[i-1] * matrix[k] *matrix[j];
			if(cost < minCost) {
				minCost = cost;
			}
		}
		return minCost;
	}

	public static void main(String[] args) {
		int[] matrix = {1,2,3,4};
        System.out.println(matrixChainOrder(matrix, 1, matrix.length-1));
	}

}
