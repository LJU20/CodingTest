
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Solution {

	static boolean def(int[][] arr) {
		Map<Integer, Integer> hashMap = new HashMap<>();
		boolean bool = true;


		for (int i = 0; i < 9; i++) {
			for (int j = 1; j < 10; j++) {
				hashMap.put(j, 0);
			}

			for (int j = 0; j < 9; j++) {
				hashMap.put(arr[i][j], hashMap.get(arr[i][j]) + 1);
			}
			for (int val : hashMap.values()) {
				if (val != 1) {
					bool = false;
					break;
				}
			}

		}

		return bool;
	}

	public static void main(String args[]) throws Exception {

		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();
		int[][] arr = new int[9][9];

		for (int test_case = 1; test_case <= T; test_case++) {

			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					arr[i][j] = sc.nextInt();
				}
			}

			// 전치행렬
			int[][] arrT = new int[9][9];

			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					arrT[i][j] = arr[j][i];
				}
			}

			int[][] arrN = new int[9][9];

			int row = 0;

			for (int r = 0; r < 9; r += 3) {
				for (int c = 0; c < 9; c += 3) {

					int col = 0;

					for (int i = r; i < r + 3; i++) {
						for (int j = c; j < c + 3; j++) {
							arrN[row][col] = arr[i][j];
							col++;
						}
					}

					row++;
				}
			}

			int result = 0;
			if (def(arr) && def(arrT) && def(arrN)) {
				result = 1;
			} else {
				result = 0;
			}
			System.out.printf("#%d %d\n", test_case, result);

		}
	}
}