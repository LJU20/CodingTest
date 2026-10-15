import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int d, w, k, totalCnt;
	static int[][] film;
	static boolean chk;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			d = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			film = new int[d][w];
			totalCnt = 0;

			for (int i = 0; i < d; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < w; j++) {
					film[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			for (int i = 0; i < d; i++) {
				chk = false;

				dosing(0, 0, i);

				if (chk) {
					totalCnt = i;
					break;
				}
			}
			System.out.printf("#%d %d%n", tc, totalCnt);
		}
	}

	static boolean check() {
		if (k == 1)
			return true;
		for (int c = 0; c < w; c++) {
			int cnt = 1;

			for (int r = 1; r < d; r++) {
				if (film[r][c] == film[r - 1][c])
					cnt++;
				else
					cnt = 1;

				if (cnt >= k)
					break;
			}
			if (cnt < k)
				return false;
		}
		return true;
	}

	static void dosing(int cnt, int start, int r) {
		if (chk) return;

		if (cnt == r) {
			if (check())
				chk = true;
			return;
		}

		for (int i = start; i < d; i++) {
			int[] temp = film[i].clone();

			for (int j = 0; j < w; j++) {
				film[i][j] = 0;
			}
			dosing(cnt + 1, i + 1, r);

			for (int j = 0; j < w; j++) {
				film[i][j] = 1;
			}
			dosing(cnt + 1, i + 1, r);
			
			film[i] = temp;
			
			if (chk) break;
		}
	}
}
