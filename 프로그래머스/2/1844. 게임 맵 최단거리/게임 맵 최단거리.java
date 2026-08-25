import java.util.ArrayDeque;
import java.util.Queue;

class Solution {

	static int solution(int[][] maps) {
		Queue<int[]> queue = new ArrayDeque<>();
		int[] dr = { -1, 1, 0, 0 };
		int[] dc = { 0, 0, 1, -1 };

		int n = maps.length;
		int m = maps[0].length;
		int[][] distance = new int[n][m];
		boolean[][] visited = new boolean[n][m];

		distance[0][0] = 1;

		visited[0][0] = true;
		queue.offer(new int[] { 0, 0 });

		while (!queue.isEmpty()) {
			int[] curent = queue.poll();
			int r = curent[0];
			int c = curent[1];

			if (r == n-1 && c == m-1) {
				return distance[r][c];
			}

			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];

				if (nr < 0 || nr >= n || nc < 0 || nc >= m)
					continue;

				if (maps[nr][nc] == 1 && !visited[nr][nc]) {
					visited[nr][nc] = true;

					distance[nr][nc] = distance[r][c] + 1;

					queue.offer(new int[] { nr, nc });
				}
			}
		}
		return -1;

	}
}