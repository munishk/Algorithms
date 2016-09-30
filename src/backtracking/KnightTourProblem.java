package backtracking;

public class KnightTourProblem {
	
	static void solveKnightTour(int size) {
		int[][] board = new int[size][size];
	
		//initialize empty board 
		for(int i=0; i<size;i++) {
			for(int j =0; j<size;j++) {
				board[i][j] = -1;
			}
		}
		
		int xmove[] = {2,1,-1,-2, 1, 2,-1,-2};
		int ymove[] = {1,2, 2, 1,-2,-1,-2,-1};
		
		board[0][0] =0;
		boolean isSolved = solveKTUtil(board, xmove, ymove, 0, 0, 1, size);
		
		printBoard(board, isSolved);
	}
	
	static boolean solveKTUtil(int[][] board, int[] xmove, int[] ymove, int x, int y, int moveNum, int size) {
		if(moveNum == size*size) {
			return true;
		}
		for(int i=0; i<8; i++) {
			int newX = x + xmove[i];
			int newY = y + ymove[i];
			if(isSafeMove(newX, newY, board, size)) {
				board[newX][newY] = moveNum;
				boolean isSolved = solveKTUtil(board, xmove, ymove, newX, newY, moveNum + 1, size);
				if(isSolved) {
					return isSolved;
				}
				//revert back to original board
				//System.out.println("Not solvale, Retrying...");
				//printBoard(board);
				board[newX][newY] = -1;
			}
		}
		return false;
	}
	
	static boolean isSafeMove(int x, int y, int[][] board, int size) {
		boolean result = x>=0 && x < size && y>=0 && y<size && board[x][y] == -1;
		//System.out.println(String.format("IsSafeMove=%s,x=%s,y=%s\n", result, x, y));
		//printBoard(board);
		return result;
	}
	
	static void printBoard(int[][] board, boolean isSolved) {
		System.out.println("Is Solved:" + isSolved);
		for(int i=0; i< board.length; i++) {
			for(int j=0; j<board[0].length; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	static void printBoard(int[][] board) {
		for(int i=0; i< board.length; i++) {
			for(int j=0; j<board[0].length; j++) {
				System.out.print(String.format("%02d ",board[i][j]));
			}
			System.out.println();
		}
	}
	
	

	public static void main(String[] args) {
		solveKnightTour(8);

	}

}
