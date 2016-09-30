package dynamicprogramming;

public class LongestCommonSubsequence {

	static int lcsRecursive(char[] X, char[] Y, int m, int n) {
		if (m == 0 || n == 0) {
			return 0;
		}

		if (X[m - 1] == Y[n - 1]) {
			return 1 + lcsRecursive(X, Y, m - 1, n - 1);
		}

		return Math.max(lcsRecursive(X, Y, m, n - 1), lcsRecursive(X, Y, m - 1, n));
	}

	static int lcsTabular(char[] X, char[] Y, int m, int n) {
		int[][] temp = new int[m + 1][n + 1];
		for (int i = 0; i <= n; i++) {
			temp[0][i] = 0;
		}

		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (X[i-1] == Y[j-1]) {
					temp[i][j] = 1 + temp[i - 1][j - 1];
				} else {
					temp[i][j] = Math.max(temp[i][j - 1], temp[i - 1][j]);
				}
			}
		}

		return temp[m][n];
	}

	public static void main(String[] args) {
		String first = "ABCDGH";
		String second = "AEDFHR";

		System.out.println(lcsRecursive(first.toCharArray(), second.toCharArray(), first.length(), second.length()));
		System.out.println(lcsTabular(first.toCharArray(), second.toCharArray(), first.length(), second.length()));
	}

}
