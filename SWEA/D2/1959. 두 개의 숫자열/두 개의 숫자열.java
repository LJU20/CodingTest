import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int result = 0;

			st = new StringTokenizer(br.readLine());
			int[] Ai = new int[N];
			for (int i = 0; i < N; i++)
				Ai[i] = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine());
			int[] Bi = new int[M];
			for (int i = 0; i < M; i++)
				Bi[i] = Integer.parseInt(st.nextToken());

			int max = 0;
			if (N > M) {
				for (int i = 0; i <= N - M; i++) {
					int res = 0;

					for (int j = 0; j < M; j++) {
						res += (Ai[i + j] * Bi[j]);

					}
					if (res > max)
						max = res;
				}
			} else {
				for (int i = 0; i <= M - N; i++) {
					int res = 0;

					for (int j = 0; j < N; j++) {
						res += (Ai[j] * Bi[i + j]);

					}
					if (res > max)
						max = res;
				}
			}
			result = max;
			System.out.printf("#%d %d\n", t, result);
		}
	}
}
