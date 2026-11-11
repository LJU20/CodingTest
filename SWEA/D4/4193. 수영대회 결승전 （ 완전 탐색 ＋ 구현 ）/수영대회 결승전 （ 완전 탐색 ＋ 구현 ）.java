import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1};
	static int[][] sea;
	static int n;
	static Queue<int[]> q;
	static int[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			n = Integer.parseInt(br.readLine());
			sea = new int[n][n];
			visited = new int[n][n];
			q = new ArrayDeque<>();

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					sea[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			st = new StringTokenizer(br.readLine());
			int sr = Integer.parseInt(st.nextToken());
			int sc = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine());
			int er = Integer.parseInt(st.nextToken());
			int ec = Integer.parseInt(st.nextToken());

			visited[sr][sc] = 1;

			int answer = bfs(sr, sc, er, ec);
			System.out.printf("#%d %d%n", tc, answer);
		}
	}

	static int bfs(int sr, int sc, int er, int ec) {
		q.offer(new int[] { sr, sc, 0 });

		while (!q.isEmpty()) {
			int[] cur = q.poll();

			int cr = cur[0];
			int cc = cur[1];
			int time = cur[2];
			if (cr == er && cc == ec) return time;

			for (int d = 0; d < 4; d++) {
				int nr = cr + dr[d];
				int nc = cc + dc[d];

				if (nr < 0 || nr >= n || nc < 0 || nc >= n) continue;
				if (sea[nr][nc] == 1) continue;
				if (visited[nr][nc] == 1) continue;
				
				if (sea[nr][nc] == 2 && time % 3 != 2) {
					q.offer(new int[] { cr, cc, time + 1 });
					
				} else {
					q.offer(new int[] { nr, nc, time + 1 });
					visited[nr][nc] = 1;
				}
			}
		}
		return -1;
	}
}
