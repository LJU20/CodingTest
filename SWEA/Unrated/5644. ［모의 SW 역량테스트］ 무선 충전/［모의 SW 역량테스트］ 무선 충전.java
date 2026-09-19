import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {

	static ArrayList<Integer>[][] map;

	static int m, a;

	static int[] dr = { 0, -1, 0, 1, 0 };
	static int[] dc = { 0, 0, 1, 0, -1 };

	static int[] ua, ub;

	static int[][] arr;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {

			StringTokenizer st = new StringTokenizer(br.readLine());

			m = Integer.parseInt(st.nextToken());
			a = Integer.parseInt(st.nextToken());

			ua = new int[m];
			ub = new int[m];

			st = new StringTokenizer(br.readLine());

			for (int i = 0; i < m; i++) {
				ua[i] = Integer.parseInt(st.nextToken());
			}

			st = new StringTokenizer(br.readLine());

			for (int i = 0; i < m; i++) {
				ub[i] = Integer.parseInt(st.nextToken());
			}

			arr = new int[a + 1][4];

			map = new ArrayList[11][11];

			for (int i = 1; i <= 10; i++) {
				for (int j = 1; j <= 10; j++) {
					map[i][j] = new ArrayList<>();
				}
			}

			for (int i = 1; i <= a; i++) {

				st = new StringTokenizer(br.readLine());

				arr[i][0] = Integer.parseInt(st.nextToken());
				arr[i][1] = Integer.parseInt(st.nextToken());
				arr[i][2] = Integer.parseInt(st.nextToken());
				arr[i][3] = Integer.parseInt(st.nextToken());
			}

			for (int bc = 1; bc <= a; bc++) {

				int bx = arr[bc][0];
				int by = arr[bc][1];
				int range = arr[bc][2];

				for (int row = 1; row <= 10; row++) {
					for (int col = 1; col <= 10; col++) {
						int distance = Math.abs(row - by) + Math.abs(col - bx);
						if (distance <= range) {
							map[row][col].add(bc);
						}
					}
				}
			}
			int aRow = 1;
			int aCol = 1;
			int bRow = 10;
			int bCol = 10;

			int result = 0;

			for (int time = 0; time <= m; time++) {

				if (time > 0) {
					aRow += dr[ua[time - 1]];
					aCol += dc[ua[time - 1]];

					bRow += dr[ub[time - 1]];
					bCol += dc[ub[time - 1]];
				}

				ArrayList<Integer> aList = map[aRow][aCol];
				ArrayList<Integer> bList = map[bRow][bCol];

				int max = 0;

				for (int i = -1; i < aList.size(); i++) {
					int aBC = 0;
					if (i != -1) {
						aBC = aList.get(i);
					}

					for (int j = -1; j < bList.size(); j++) {
						int bBC = 0;
						if (j != -1) {
							bBC = bList.get(j);
						}

						int sum;

						if (aBC == bBC) {
							sum = arr[aBC][3];
						} else {
							sum = arr[aBC][3] + arr[bBC][3];
						}
						max = Math.max(max, sum);
					}
				}
				result += max;
			}
			System.out.printf("#%d %d%n", tc, result);
		}
	}
}