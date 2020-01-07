package permutation;

public class NthPermutation {
	
	private static String nthPerm(String input, String prefix, int n) {
		if(input.length() <=1) {
			return prefix + input;
		}
		
		int prevComb = fact(input.length() -1);
		int index = (n-1)/prevComb;
		
		return nthPerm(input.substring(0, index) + input.substring(index+1), prefix + input.charAt(index), n-prevComb*index);
	}
	
	static int fact(int n) {
		int result = 1;
		for(int i=n; i>0; i--) {
			result = result *i;
		}
		return result;
	}

	public static void main(String[] args) {
		String input = "0123";
		for(int i=1; i<24; i++) {
		String output = nthPerm(input, "", i);
        System.out.println(output);
		}
	}

}
