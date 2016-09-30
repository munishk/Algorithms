package dynamicprogramming;

public class LongestIncreasingSubsequence {
	
	static int lic(int[] arr) {
		int[] licArray = new int[arr.length];
		
		//populate longest increasing subsequence array to be at least 1
		for(int i=0; i < arr.length; i++) {
			licArray[i] =1;
		}
		
		for(int i =1; i < arr.length;i++) {
			int j = 0;
			while(j < i) {
				if(arr[j] < arr[i]) {
					licArray[i] = Math.max(licArray[i], licArray[j]+1);
				}
				j++;
			}
		}
		System.out.println("LIC Array:");
		print(licArray);
		int max =1;
		for(int i =0; i<arr.length;i++) {
			if(max < licArray[i]) {
				max = licArray[i];
			}
		}
		return max;
	}
	
	static void print(int[] arr) {
		StringBuilder strBuilder = new StringBuilder();
		for(int i=0; i<arr.length;i++) {
			strBuilder.append(arr[i] + " ");
		}
		System.out.println(strBuilder);
	}

	public static void main(String[] args) {
		int[] input = {3,4,-1,0,6,2,3};
		lic(input);

	}

}
