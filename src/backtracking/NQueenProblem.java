package backtracking;

public class NQueenProblem {
	
	int[][] board;
	
	int n;
	
	public NQueenProblem(int n) {
		board = new int[n][n];
		this.n = n;
	}

	boolean solveNQ(int col) {
		if(col == n) {
			return true;
		}
		
		for(int i=0; i<n;i++) {
			if(isSafeMove(i, col)) {
				board[i][col] = 1;
				boolean isSolved = solveNQ(col + 1);
				if(isSolved) {
					return isSolved;
				}
				//System.out.println("Backtracking...");
				//printBoard();
				board[i][col] = 0; //backtrack
			}
		}
		return false;
	}
	
	boolean isSafeMove(int row, int col) {
		//Check for row on left hand side
		for(int i=0; i<col; i++) {
			if(board[row][i] == 1) {
				return false;
			}
		}
		
		//Check for upper let diagonal
		for(int i=row - 1,j= col - 1; i>=0 && j>=0; i--,j--) {
			if(board[i][j] == 1) {
				return false;
			}
		}
		
		//Check for lower left diagonal
		for(int i=row + 1, j= col - 1; i <n && j >=0; i++,j--) {
			if(board[i][j] == 1) {
				return false;
			}
		}
		return true;
	}
	
	void printBoard() {
		for(int i=0; i< board.length; i++) {
			for(int j=0; j<board[0].length; j++) {
				System.out.print(String.format("%2d ",board[i][j]));
			}
			System.out.println("\n");
		}
	}


	public static void main(String[] args) {
		NQueenProblem nq = new NQueenProblem(8);
		boolean result = nq.solveNQ(0);
		System.out.println("Solved: " + result);
		nq.printBoard();

	}

}
