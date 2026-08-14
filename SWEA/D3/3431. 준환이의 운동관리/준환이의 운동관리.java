import java.util.Scanner;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {

			int result = 0;
			int L = sc.nextInt();
			int U = sc.nextInt();
			int X = sc.nextInt();

			if (X > U) {
				result = -1;
			} else {
				if (X >= L && X <= U) {
					result = 0;
				} else
					result = L - X;
			}
			System.out.printf("#%d %d\n", test_case, result);
		}
	}
}