package dynamicprogramming;

/**
 * http://www.geeksforgeeks.org/dynamic-programming-set-12-longest-palindromic-subsequence/
 * 
 * @author munishk
 *
 */
public class LongestPalindromicSubSequence {
	
	static class Result {
		String left = "";
		String right  = "";
		char mid;
		int count;
		public Result(String left, String right, char mid, int count) {
			super();
			this.left = left;
			this.right = right;
			this.mid = mid;
			this.count = count;
		}
		
		public Result(String left, String right, int count) {
			super();
			this.left = left;
			this.right = right;
			this.count = count;
		}
		
		String getSubSequence() {
			return left + mid + right;
		}
	}

	static int lps(String str, int low, int high) {
		if (low == high) {
			return 1;
		}

		if (low > high) {
			return 0;
		}

		if (str.charAt(low) == str.charAt(high)) {
			return 2 + lps(str, low + 1, high - 1);
		}

		return Math.max(lps(str, low + 1, high), lps(str, low, high - 1));
	}
	
	static Result lpsWithData(String str, int low, int high) {
		if (low == high) {
			return new Result("", "", str.charAt(low), 1);
		}

		if (low > high) {
			return new Result("", "", 0);
		}

		if (str.charAt(low) == str.charAt(high)) {
			Result res = lpsWithData(str, low + 1, high - 1);
			return new Result(str.charAt(low) + res.left , res.right + str.charAt(high) , res.mid, res.count + 2);
		}
		
		Result res1 = lpsWithData(str, low + 1, high);
		Result res2 = lpsWithData(str, low, high - 1);

		return res1.count >= res2.count ? res1: res2;
	}

	public static void main(String[] args) {
		String str = "BBABCBCAB";
		System.out.println(lps(str, 0, str.length()-1));
		str = "GEEKSFORGEEKS";
		System.out.println(lps(str, 0, str.length()-1));

		str = "BBABCBCAB";
		Result res = lpsWithData(str, 0, str.length() -1);
		System.out.println(res.getSubSequence());

	}

}
