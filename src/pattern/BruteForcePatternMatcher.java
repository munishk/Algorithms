package pattern;

public class BruteForcePatternMatcher {

	private static void match(String str, String pattern) {
		int n = str.length();
		int m = pattern.length();

		for(int i=0; i< n-m; i++) {
			if(str.charAt(i) == pattern.charAt(0)) {
				int j = 1;
				while(j < m && pattern.charAt(j) == str.charAt(i+j)){
					j++;
				}
				if(j == m) {
					System.out.println("Found pattern at index: " + i);
				}
			}
		}
	}

	public static void main(String[] args) {
		String str = "THIS IS A TEST TEXT";
		String pattern = "TEST";

		str = "AABAACAADAABAAABAA";
		pattern = "AABA";

		match(str, pattern);
	}

}
