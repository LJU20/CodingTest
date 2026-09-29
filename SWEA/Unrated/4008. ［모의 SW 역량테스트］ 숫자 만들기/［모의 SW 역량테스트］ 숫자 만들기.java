import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int N, min, max;
	static int[] op, num;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			op = new int[4];
			num = new int[N];
			min = Integer.MAX_VALUE;
			max = Integer.MIN_VALUE;

			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 4; i++) {
				op[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				num[i] = Integer.parseInt(st.nextToken());
			}

			dfs(1, num[0]);
			System.out.printf("#%d %d %n", tc, max - min);
		}
	}

	static void dfs(int idx, int n) {

		if (idx == N) {
			min = Math.min(min, n);
			max = Math.max(max, n);
			return;
		}

		for (int i = 0; i < 4; i++) {
			if (op[i] > 0) {
				op[i]--;
				if (i == 0)
					dfs(idx + 1, n + num[idx]);

				if (i == 1)
					dfs(idx + 1, n - num[idx]);

				if (i == 2)
					dfs(idx + 1, n * num[idx]);

				if (i == 3)
					dfs(idx + 1, n / num[idx]);

				op[i]++;
			}
		}
	}
}
