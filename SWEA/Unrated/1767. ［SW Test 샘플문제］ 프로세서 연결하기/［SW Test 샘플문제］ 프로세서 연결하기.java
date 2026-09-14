import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Solution {
	static int N, totalCnt, max, min;
	static int[][] map;
	static ArrayList<int[]> list;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {

			N = Integer.parseInt(br.readLine());
			list = new ArrayList<int[]>();
			map = new int[N][N];
			max = 0;
			min = Integer.MAX_VALUE;
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (i > 0 && i < N - 1 && j > 0 && j < N - 1 && map[i][j] == 1) {
						list.add(new int[] { i, j });
					}
				}
			}
			totalCnt = list.size();
			go(0, 0, 0);
			System.out.printf("#%d %d%n", tc, min);
		}
	}

	static void go(int idx, int cCnt, int uCnt) {
		if (totalCnt - idx + cCnt < max) {
			return;
		}
		if (idx == totalCnt) {
			if (max < cCnt) {
				max = cCnt;
				min = uCnt;
			} else if (max == cCnt) {
				if (min > uCnt) {
					min = uCnt;
				}
			}
			return;
		}
		int[] cur = list.get(idx);
		int r = cur[0];
		int c = cur[1];
		for (int d = 0; d < 4; d++) {
			if (isAvailable(r, c, d)) {
				int len = setStatus(r, c, d, 2);
				go(idx + 1, cCnt + 1, uCnt + len);
				setStatus(r, c, d, 0);
			}
		}
		go(idx + 1, cCnt, uCnt);
	}

	static boolean isAvailable(int r, int c, int d) {
		int nr = r;
		int nc = c;
		while (true) {
			nr += dr[d];
			nc += dc[d];
			if (nr < 0 || nr >= N || nc < 0 || nc >= N) {
				break;
			}
			if (map[nr][nc] >= 1) {
				return false;
			}
		}
		return true;
	}

	static int setStatus(int r, int c, int d, int s) {
		int nr = r;
		int nc = c;
		int cnt = 0;
		while (true) {
			nr += dr[d];
			nc += dc[d];
			if (nr < 0 || nr >= N || nc < 0 || nc >= N) {
				break;
			}
			map[nr][nc] = s;
			cnt++;
		}
		return cnt;
	}
}