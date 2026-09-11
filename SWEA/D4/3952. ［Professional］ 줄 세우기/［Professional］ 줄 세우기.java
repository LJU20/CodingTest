import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.StringTokenizer;

class Solution {
	static int n, m;
	static int[] indegree;
	static ArrayList<Integer>[] graph;
	static Deque<Integer> queue;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());

			graph = new ArrayList[n + 1];
			indegree = new int[n + 1];

			for (int i = 1; i <= n; i++) {
				graph[i] = new ArrayList<>();
			}
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				graph[from].add(to);
				indegree[to]++;
			}
			queue = new ArrayDeque<>();
			System.out.printf("#%d ", tc);

			for (int i = 1; i <= n; i++) {
				if (indegree[i] == 0) {
					queue.offer(i);
				}
			}

			while (!queue.isEmpty()) {
				int now = queue.poll();
				System.out.print(now + " ");

				for (int n : graph[now]) {
					indegree[n]--;
					if (indegree[n] == 0) {
						queue.offer(n);
					}
				}
			}
			System.out.println();
		}
	}
}