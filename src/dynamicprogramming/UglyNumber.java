package dynamicprogramming;

/**
 * http://www.geeksforgeeks.org/ugly-numbers/
 * @author munishk
 *
 */
public class UglyNumber {
	
	static int getUgly(int n) {
		if(n ==1) {
			return 1;
		}
		
		int res = getUgly(n-1);
		res = res+1;
		while(!isUgly(res)) {
			res++;
		}
		return res;
	}
	
	static boolean isUgly(int n) {
		return n%2==0 || n%3==0 ||n%5==0;
	}

	public static void main(String[] args) {
		int n=10;
		for(int i=1;i<=150;i++) {
		System.out.println(getUgly(i));
		}
	}

}
