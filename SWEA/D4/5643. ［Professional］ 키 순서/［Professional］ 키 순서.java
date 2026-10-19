import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Solution {
	static int n, m;
	static boolean[][] graph;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			n = Integer.parseInt(br.readLine());
			m = Integer.parseInt(br.readLine());
			graph = new boolean[n + 1][n + 1];
			for (int i = 0; i < m; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());

				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());

				graph[a][b] = true;
			}

			for (int k = 0; k <= n; k++) {
				for (int i = 0; i <= n; i++) {
					for (int j = 0; j <= n; j++) {

						if (graph[i][k] && graph[k][j]) {
							graph[i][j] = true;
						}
					}
				}
			}
			int answer = 0;

			for (int i = 1; i <= n; i++) {
				int count = 0;
				for (int j = 1; j <= n; j++) {

					if (i == j)
						continue;

					if (graph[i][j] || graph[j][i]) {
						count++;
					}
				}
				if (count == n - 1) {
					answer++;
				}
			}
			System.out.printf("#%d %d%n", tc, answer);
		}
	}
}
