import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<Integer> list;
	static ArrayList<Integer>[] graph;
	static int[] indegree;
	static Queue<Integer> q;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		graph = new ArrayList[n + 1];
		for (int i = 1; i <= n; i++) {
			graph[i] = new ArrayList<>();
		}
		list = new ArrayList<>();
		indegree = new int[n + 1];
		q = new ArrayDeque<>();

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int pd = Integer.parseInt(st.nextToken());
			int temp = Integer.parseInt(st.nextToken());
			for (int j = 0; j < pd - 1; j++) {
				int a = Integer.parseInt(st.nextToken());
				graph[temp].add(a);
				indegree[a]++;
				temp = a;
			}
		}

		for (int i = 1; i <= n; i++) {
			if (indegree[i] == 0) q.offer(i);
		}

		while (!q.isEmpty()) {
			int cur = q.poll();
			list.add(cur);
			for (int next : graph[cur]) {
				indegree[next]--;
				if (indegree[next] == 0) {
					q.offer(next);
				}
			}
		}
		if (list.size() != n) System.out.println(0);
		else {
			for (int s : list) {
				System.out.println(s);
			}
		}
	}
}
