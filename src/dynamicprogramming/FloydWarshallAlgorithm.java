package dynamicprogramming;

/**
 * http://www.geeksforgeeks.org/dynamic-programming-set-16-floyd-warshall-algorithm/
 * @author munishk
 *
 */
public class FloydWarshallAlgorithm {
	
	static int INF = 99999;
	
	static int[][] shortestPath(int[][] graph) {
		int n = graph.length;
		int[][] solution = new int[n][n];
	   //Initially copy existing graph to solution matrix
		for(int i=0; i<n;i++) {
			for(int j=0; j<n;j++) {
				solution[i][j] = graph[i][j];
			}
		}
		//k - vertex k as intermediate vertex from i -> j,
		//check if dist(i,j) > dist(i,k) + dist(k,j), then update dist[i,j)
		for(int k=0; k<n; k++) {
			for(int i=0; i<n;i++) {
				for(int j=0; j<n;j++) {
					if(solution[i][j] > solution[i][k] + solution[k][j]) {
						solution[i][j] = solution[i][k] + solution[k][j];
					}
				}
			}
		}
		return solution;
	}

	public static void main(String[] args) {
		int[][] graph = {
				{0,   5,  INF, 10},
                {INF, 0,   3, INF},
                {INF, INF, 0,   1},
                {INF, INF, INF, 0}
                };
		System.out.println("Input graph:");
		print(graph);
		
		int[][] solution = shortestPath(graph);
		System.out.println("Solution:");
		print(solution);
		
	}
	
	static void print(int[][] matrix) {
		for(int i=0; i<matrix.length; i++) {
			for(int j=0;j<matrix.length;j++) {
				System.out.print(matrix[i][j] == INF? "INF ": String.format("%3d",matrix[i][j]) + " ");
			}
			System.out.println();
		}
	}

}
