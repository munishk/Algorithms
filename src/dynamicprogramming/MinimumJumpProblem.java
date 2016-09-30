package dynamicprogramming;

public class MinimumJumpProblem {
	
	static int minJump(int[] arr, int start, int end) {
		if(start == end) {
			return 0;
		}
		
		if(arr[start] == 0) {
			return Integer.MAX_VALUE;
		}
		
		int min = Integer.MAX_VALUE;
		for(int i=1; i<=arr[start] && start + i <=end; i++) {
			int res = minJump(arr, start+i, end);
			if(res != Integer.MAX_VALUE && res +1 < min) {
				min = res +1;
			}
		}
		return min;
	}
	
	static int minJumpTabular(int[] arr, int n) {
		int[] jump = new int[n+1];
		jump[0] = 0;
		for(int i=1;i<=n;i++) {
			jump[i] = Integer.MAX_VALUE;
			for(int j=0; j<i;j++) {
				if(arr[j] + j >= i && jump[j] + 1 < jump[i]) {
					jump[i] = jump[j] +1;
				}
			}
		}
		return jump[n];
	}

	public static void main(String[] args) {
		int[] arr = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
         System.out.println(minJump(arr, 0, arr.length-1));
         System.out.println(minJumpTabular(arr, arr.length-1));
	}

}
