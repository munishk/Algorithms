package dynamicprogramming;

/**
 * http://www.geeksforgeeks.org/longest-palindrome-substring-set-1/
 * @author munishk
 *
 */
public class LongestPalindromicSubString {
	
	static String longestPalindromicSubstring(String str, int low, int high) {
		if(isPalindrome(str, low, high)) {
			return str.substring(low, high+1);
		}
		
		String res1 = longestPalindromicSubstring(str, low+1, high);
		String res2 = longestPalindromicSubstring(str, low, high-1);
		return res1.length() > res2.length() ? res1: res2;
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
		String str = "forgeeksskeegfor";
		System.out.println(longestPalindromicSubstring(str, 0, str.length()-1));

	}

}
