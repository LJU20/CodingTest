import java.util.Scanner;

class Solution {

	static int def(char[][] arr, int N) {

		int result = 0;

		for (int i = 0; i < 8; i++) {
			int start = 0;
			int end = 8 - N;
			for (; start <= end; start++) {
				int left = start;
				int right = start + N - 1;
				int cnt = 0;

				while (left < right) {
					if (arr[i][left] == arr[i][right]) {
						left += 1;
						right -= 1;
						cnt += 1;

					} else {
						break;

					}
					if (cnt == N / 2) {
						result += 1;
					}
				}
			}

		}
		return result;
	}

	public static void main(String args[]) throws Exception {

		Scanner sc = new Scanner(System.in);
		int T;
		T = 10;

		char[][] arr = new char[8][8];

		for (int test_case = 1; test_case <= T; test_case++) {
			int N;
			N = sc.nextInt();

			for (int i = 0; i < 8; i++) {
				String str;
				str = sc.next();
				for (int j = 0; j < 8; j++) {
					arr[i][j] = str.charAt(j);
				}
			}

			char[][] arrT = new char[8][8];
			for (int i = 0; i < 8; i++) {
				for (int j = 0; j < 8; j++) {
					arrT[i][j] = arr[j][i];
				}
			}

			int result = 0;
			result = def(arr, N) + def(arrT, N);
			System.out.printf("#%d %d\n", test_case, result);
		}

	}
}