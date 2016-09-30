package backtracking;

import java.util.ArrayList;
import java.util.List;

public class SubsetSum {

	void solve(int[] input, int[] temp, int sourceIndex, int tempIndex, int expectedSum, int currentSum,
			List<int[]> result) {
		if (currentSum == expectedSum) {
			addResult(result, temp, tempIndex);
			return;
		}
		for (int i = sourceIndex; i < input.length; i++) {
			if (expectedSum >= currentSum + input[i]) {
				temp[tempIndex] = input[i];
				solve(input, temp, i + 1, tempIndex + 1, expectedSum, currentSum + input[i], result);
				//System.out.println("Backtracking...");
				//System.out.println(toString(temp));
				temp[tempIndex] = 0; // remove this element from list for
										// backtracking
			}
		}
	}

	public String toString(int[] arr) {
		StringBuilder sb = new StringBuilder();
		for (int value : arr) {
			if (value > 0) {
				sb.append(value + " ");
			}
		}
		return sb.toString();
	}

	void addResult(List<int[]> rs, int[] vector, int index) {
		int[] temp = new int[index + 1];
		System.arraycopy(vector, 0, temp, 0, index + 1);
		rs.add(temp);
	}

	public static void main(String[] args) {
		int[] input = { 10, 7, 5, 18, 12, 20, 15 };
		int[] output = new int[input.length];
		List<int[]> result = new ArrayList<>();
		SubsetSum ss = new SubsetSum();
		ss.solve(input, output, 0, 0, 35, 0, result);
		System.out.println("Input: " + ss.toString(input));
		System.out.println("Result: ");
		for(int[] subArray: result) {
		System.out.println(ss.toString(subArray));
		}

	}

}
