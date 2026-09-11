import java.io.BufferedReader;
import java.io.InputStreamReader;

class Solution {
	static int[][] farm;
	static int r, c, m, result;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			farm = new int[N][N];
			for (int i = 0; i < N; i++) {
				String str = br.readLine();
				for (int j = 0; j < N; j++) {
					farm[i][j] = str.charAt(j) - '0';
				}
			}
			r = c = N / 2;
			m = N / 2;
			result = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (Math.abs(r - i) + Math.abs(c - j) <= m) {
						result += farm[i][j];
					}
				}
			}
			System.out.printf("#%d %d%n", tc, result);
		}
	}
}