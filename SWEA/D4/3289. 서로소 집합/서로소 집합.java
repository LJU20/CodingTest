import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int[] parent;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringBuilder sb = new StringBuilder();
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			parent = new int[N + 1];
			for (int i = 1; i <= N; i++) {
				makeSet(i);
			}

			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int input = Integer.parseInt(st.nextToken());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());

				if (input == 0) {
					union(a, b);
				}
				if (input == 1) {
					if (findSet(a) == findSet(b)) {
						sb.append(1);
					} else {
						sb.append(0);
					}
				}
			}
			System.out.printf("#%d %s%n", tc, sb);
		}
	}

	static void makeSet(int x) {
		parent[x] = x;
	}

	static int findSet(int x) {
		if (x == parent[x]) {
			return x;
		}

		return parent[x] = findSet(parent[x]);
	}

	static void union(int a, int b) {
		int rootA = findSet(a);
		int rootB = findSet(b);

		if (rootA != rootB) {
			parent[rootB] = rootA;
		}
	}
}