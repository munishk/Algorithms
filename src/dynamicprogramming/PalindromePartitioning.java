package dynamicprogramming;

/**
 * http://www.geeksforgeeks.org/dynamic-programming-set-17-palindrome-partitioning/
 * @author munishk
 *
 */
public class PalindromePartitioning {
	
	/*
	 * Minimum partition required so that all cuts are palindrome.
	 */
	static int minPartition(String str, int low, int high) {
		if(isPalindrome(str, low, high)) {
			return 0;
		}
		int min =Integer.MAX_VALUE;
		for(int i=low; i<high;i++) {
			int res = 1 + minPartition(str, low, i) + minPartition(str, i+1, high);
			if(res < min) {
				min = res;
			}
		}
		return min;
	}
	
	static boolean isPalindrome(String str, int low, int high) {
		while(low < high) {
			if(str.charAt(low) != str.charAt(high)) {
				return false;
			}else {
				low++;
				high--;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		String str = "ababbbabbababa";
		System.out.println(minPartition(str, 0, str.length()-1));

	}

}
