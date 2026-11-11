import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int n;
	static int[][] map, dist;
	static final int INF = Integer.MAX_VALUE;

	static class Vertex implements Comparable<Vertex> {
		int r;
		int c;
		int cost;

		public Vertex(int r, int c, int cost) {
			super();
			this.r = r;
			this.c = c;
			this.cost = cost;
		}

		@Override
		public int compareTo(Vertex o) {
			// TODO Auto-generated method stub
			return Integer.compare(this.cost, o.cost);
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			n = Integer.parseInt(br.readLine());
			map = new int[n][n];
			
			for (int i = 0; i < n; i++) {
//				StringTokenizer st = new StringTokenizer(br.readLine());
				String str = br.readLine();
				for (int j = 0; j < n; j++) {
					map[i][j] = str.charAt(j) - '0';
				}
			}
			int sc = map[0][0];
			int answer = dijk(sc);
			System.out.printf("#%d %d%n", tc, answer);
		}

	}

	static int dijk(int startCost) {
		PriorityQueue<Vertex> pq = new PriorityQueue<>();

		dist = new int[n][n];

		for (int i = 0; i < n; i++) {
			Arrays.fill(dist[i], INF);
		}

		dist[0][0] = startCost;
		pq.offer(new Vertex(0, 0, startCost));

		while (!pq.isEmpty()) {
			Vertex cur = pq.poll();

			int cr = cur.r;
			int cc = cur.c;
			int cost = cur.cost;

			if (cost > dist[cr][cc]) continue;

			for (int d = 0; d < 4; d++) {
				int nr = cr + dr[d];
				int nc = cc + dc[d];

				if (nr < 0 || nr >= n || nc < 0 || nc >= n) continue;
				int nextCost = cost + map[nr][nc];

				if (nextCost < dist[nr][nc]) {
					dist[nr][nc] = nextCost;
					pq.offer(new Vertex(nr, nc, nextCost));
				}
			}
		}
		return dist[n - 1][n - 1];
	}
}