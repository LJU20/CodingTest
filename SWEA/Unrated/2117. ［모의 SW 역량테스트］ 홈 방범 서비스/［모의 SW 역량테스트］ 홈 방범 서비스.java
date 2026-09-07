import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			int[][] map = new int[N][N];
			int count = 0;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					for (int K = 1; K <= N + 1; K++) {
						if ((manhattan(map, i, j, K) * M - (K * K + ((K - 1) * (K - 1))) >= 0)) {
							if (manhattan(map, i, j, K) > count) {
								count = manhattan(map, i, j, K);
							}
						}
					}
				}
			}
			System.out.printf("#%d %d%n", tc, count);
		}
	}

	static int manhattan(int[][] map, int r, int c, int K) {
		int home = 0;
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				if (Math.abs(r - i) + Math.abs(c - j) < K && map[i][j] == 1) {
					home++;
				}
			}
		}
		return home;
	}
}
