import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.StringTokenizer;

class Solution {
	static int v, e;
	static int[] indegree;
	static ArrayList<Integer>[] graph;
	static Deque<Integer> queue;
	static ArrayList<Integer> list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int tc = 1; tc <= 10; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			v = Integer.parseInt(st.nextToken());
			e = Integer.parseInt(st.nextToken());
			graph = new ArrayList[v + 1];
			indegree = new int[v + 1];

			list = new ArrayList<>();
			queue = new ArrayDeque<>();

			for (int i = 1; i <= v; i++) {
				graph[i] = new ArrayList<>();
			}

			st = new StringTokenizer(br.readLine());

			for (int i = 0; i < e; i++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());

				graph[from].add(to);
				indegree[to]++;
			}

			for (int i = 1; i <= v; i++) {
				if (indegree[i] == 0) {
					queue.offer(i);
				}
			}
			while (!queue.isEmpty()) {
				int cur = queue.poll();
				list.add(cur);

				for (int n : graph[cur]) { 
					indegree[n]--;
					if (indegree[n] == 0) {
						queue.offer(n);
					}
				}
			}
			System.out.print("#" + tc);
			for (int n : list) {
				System.out.print(" " + n);
			}
			System.out.println();
		}
	}
}