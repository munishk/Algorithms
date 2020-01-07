package permutation;

/**
 * http://www.geeksforgeeks.org/print-all-combinations-of-points-that-can-
 * compose-a-given-number/
 * 
 * @author munishk
 *
 */
public class PointCombination {

	static void combination(int n, String prefix) {
		if (n < 0) {
			return;
		}

		if (n == 0) {
			System.out.println(prefix);
			return;
		}

		if (n >= 1) {
			combination(n - 1, prefix + "1");
		}
		if (n >= 2) {
			combination(n - 2, prefix + "2");
		}
		if (n >= 3) {
			combination(n - 3, prefix + "3");
		}
	}

	public static void main(String[] args) {
		combination(3, "");

	}

}
