package backtracking;

public class StringPermutation {
	
	static void permutation(char[] input, int index) {
		if(input.length == index) {
			System.out.println(String.copyValueOf(input));
		}
		for(int i=index; i < input.length; i++) {
			swap(input, index, i);
			permutation(input, index+1);
			swap(input, index, i);
		}
	}
	
	static void swap(char[] input, int i, int j) {
		char temp = input[i];
		input[i] = input[j];
		input[j] = temp;
	}

	public static void main(String[] args) {
		char[] input = {'C', 'A', 'T'};
		permutation(input, 0);

	}

}
