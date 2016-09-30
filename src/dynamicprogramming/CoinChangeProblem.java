package dynamicprogramming;

/**
 * http://www.geeksforgeeks.org/dynamic-programming-set-7-coin-change/
 * @author munishk 
 *
 */
public class CoinChangeProblem {
	
	/*
	 * Wrong, not complete...
	 */
	static int coinChangeCountRecur(int value, int[] coinSet) {
		if(value < 0){
			return 0;
		}
		if(value == 0) {
			return 1;
		}
		int count = 0;
		for(int coin: coinSet) {
			count += coinChangeCountRecur(value-coin, coinSet);
		}
		return count;
	}

	public static void main(String[] args) {
		int[] coinSet = {1,2,3};
		int value = 4;
		System.out.println(coinChangeCountRecur(value, coinSet));

	}

}
