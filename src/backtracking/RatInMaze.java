package backtracking;

public class RatInMaze {
	
	static class Position {
		int x, y;

		public Position(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + x;
			result = prime * result + y;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Position other = (Position) obj;
			if (x != other.x)
				return false;
			if (y != other.y)
				return false;
			return true;
		}
		
		
		
	}
	
	static boolean canMove(int[][] maze, int x, int y) {
		return x>=0 && x < maze.length && y >=0 && y < maze[0].length && maze[x][y] == 1;
	}
	
	static boolean solveMaze(int[][] maze, Position start, Position dest) {
		if(start.equals(dest)) {
			return true;
		}
		
		Position newPosition = new Position(start.x + 1, start.y);
		if(canMove(maze, newPosition.x, newPosition.y)) {
			maze[newPosition.x][newPosition.y] = 2;
		   boolean done = solveMaze(maze, newPosition, dest);
		   if(done) {
			   return done;
		   }
		   maze[newPosition.x][newPosition.y] = 1;
		}
		
		newPosition = new Position(start.x, start.y + 1);
		if(canMove(maze, newPosition.x, newPosition.y)) {
			maze[newPosition.x][newPosition.y] = 2;
		   boolean done = solveMaze(maze, newPosition, dest);
		   if(done) {
			   return done;
		   }
		   maze[newPosition.x][newPosition.y] = 1;
		}
		return false;	
	}

	public static void main(String[] args) {
		int[][] maze = { {1, 0, 0, 0},
		                 {1, 1, 0, 1},
		                 {0, 1, 0, 0},
		                 {1, 1, 1, 1}};
		System.out.println("Initial Maze:");
		printMaze(maze);
		Position start = new Position(0, 0);
		Position end = new Position(3,3);
		maze[0][0] = 2;

		boolean isSolved = solveMaze(maze, start, end);
		System.out.println("Solution found: " + isSolved);
		printMaze(maze);
	}
	
	static void printMaze(int[][] maze) {
		for(int i=0; i< maze.length; i++) {
			for(int j=0; j<maze[0].length; j++) {
				System.out.print(String.format("%2d ",maze[i][j]));
			}
			System.out.println();
		}
	}

}
