import java.util.Scanner;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {

			int A = sc.nextInt();
			int B = sc.nextInt();

			int time = (A + B) % 24;

			System.out.printf("#%d %d\n", test_case, time);
		}
	}
}