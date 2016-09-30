package dynamicprogramming;

public class MinEditDistance {
	
	static int minEditDistTabular(String str1, String str2, int m, int n) {
		int[][] temp = new int[m +1][n+1];
		
		for(int i=0; i<=m; i++) {
			for(int j=0; j <=n; j++) {
				if(i == 0) {
					temp[i][j] = j;
				}
				if(j == 0) {
					temp[i][j] = i;
				}
				
				if(str1.charAt(m-1) == str2.charAt(n-1)) {
					temp[m][n] = temp[m-1][n-1];
				}else {
					temp[m][n] = 1 + min(temp[m][n-1], temp[m-1][n], temp[m-1][n-1]);
				}
			}
		}
		return temp[m][n];
	}
	
	static int min(int a, int b, int c) {
		return Math.min(Math.min(a, b), b);
	}

	static int minEditDistanceRecur(String str1, String str2, int m, int n) {
		if (m == 0) {
			return n;
		}

		if (n == 0) {
			return m;
		}

		if (str1.charAt(m - 1) == str2.charAt(n - 1)) {
			return minEditDistanceRecur(str1, str2, m - 1, n - 1);
		}

		return 1 + Math.min(
				Math.min(minEditDistanceRecur(str1, str2, m, n - 1), // insert
						minEditDistanceRecur(str1, str2, m - 1, n)), // remove
				minEditDistanceRecur(str1, str2, m - 1, n - 1)); // replace
	}

	public static void main(String[] args) {
		System.out.println(minEditDistanceRecur("sunday", "saturday", 6, 8));

	}

}
