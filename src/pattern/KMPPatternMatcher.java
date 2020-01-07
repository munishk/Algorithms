package pattern;

public class KMPPatternMatcher {

	private static void match(String str, String pattern) {
		int n = str.length();
		int m= pattern.length();

		int[] lps = new int[m]; //longest prefix which is also suffix.

		computeLPS(lps, pattern);

		printLPS(lps, pattern);
		int j = 0;
		int i = 0;

		while(i < n) {
			if(str.charAt(i) == pattern.charAt(j)) {
				i++;
				j++;
			}

			if(j == m) {
				System.out.println("Pattern found at index: " + (i-j));
				j = lps[j-1];
			}

			if( i < n && str.charAt(i) != pattern.charAt(j)) {
				if(j != 0) {
					j = lps[j-1];
				}else {
					i++;
				}
			}
		}
	}



	private static void computeLPS(int[] lps, String pattern) {
		int len =0;
		lps[0] = 0;
		int i = 1;
		int m = pattern.length();
		while(i < m) {
			if(pattern.charAt(len) == pattern.charAt(i)) {
				len++;
				lps[i] = len;
				i++;
			}else {
				if(len > 0) {
					len = lps[len-1];
				}else {
					lps[i] = len;
					i++;
				}
			}
		}
	}

	private static void printLPS(int[] lps, String pattern) {
		StringBuilder index = new StringBuilder();
		StringBuilder data = new StringBuilder();
		for(int i=0; i < lps.length; i++) {
			index.append(pattern.charAt(i) + " ");
			data.append(lps[i] + " ");
		}

		System.out.println("LPS Array: ");
		System.out.println(index);
		System.out.println(data);
	}

	public static void main(String[] args) {
		String str = "ABABDABACDABABCABAB";
		String pattern = "ABABCABAB";

		match(str, pattern);

	}

}
