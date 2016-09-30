package dynamicprogramming;

public class EggDropProblem {
	
	static int solve(int floors, int eggs) {
		if(eggs == 1) {
			return floors;
		}
		
		if(floors <= 1) {
			return floors;
		}
		int min = Integer.MAX_VALUE;
		for(int k=1; k<=floors;k++) {
			int res = Math.max(solve(k-1, eggs-1), // egg broke 
					solve(floors-k, eggs)); //egg not broken
			if(res < min) {
				min = res;
			}
		}
		return 1 + min;
	}

	public static void main(String[] args) {
		System.out.println(solve(10, 2));

	}

}
