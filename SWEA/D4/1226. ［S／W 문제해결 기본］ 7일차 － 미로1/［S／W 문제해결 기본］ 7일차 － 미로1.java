import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int tc = 0; tc < 10; tc++) {
			int T = Integer.parseInt(br.readLine());
			char[][] maze = new char[16][16];
			for (int i = 0; i < 16; i++) {
				String str = br.readLine();
				for (int j = 0; j < 16; j++) {
					maze[i][j] = str.charAt(j);
				}
			}
			int[][] visited = new int[16][16];
			visited[1][1] = 1;
			int answer = 0;
			Deque<int[]> deque = new ArrayDeque<>();
			deque.offer(new int[] { 1, 1 });

			while (!deque.isEmpty()) {
				int[] current = deque.poll();
				int r = current[0];
				int c = current[1];

				if (maze[r][c] == '3') {
					answer = 1;
                    break;
				}
				for (int i = 0; i < 4; i++) {
					int nr = r + dr[i];
					int nc = c + dc[i];

					if (nr < 0 || nr >= 16 || nc < 0 || nc >= 16) {
						continue;
					}

					if (maze[nr][nc] == '1' || visited[nr][nc] == 1) {
						continue;
					}
					visited[nr][nc] = 1;
					deque.offer(new int[] { nr, nc });
				}
			}
			System.out.printf("#%d %d%n", T, answer);
		}
	}
}
