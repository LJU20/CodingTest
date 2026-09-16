import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Solution {
	static int[][] maze = new int[100][100];
	static Queue<int[]> queue;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int tc = 1; tc <= 10; tc++) {
			int t = Integer.parseInt(br.readLine());

			for (int i = 0; i < 100; i++) {
				String str = br.readLine();
				for (int j = 0; j < 100; j++) {
					maze[i][j] = str.charAt(j) - '0';
				}
			}

			queue = new ArrayDeque<>();
			queue.offer(new int[] { 1, 1 });
			int answer = 0;

			while (!queue.isEmpty()) {
				int cur[] = queue.poll();
				int r = cur[0];
				int c = cur[1];

				for (int i = 0; i < 4; i++) {
					int nr = r + dr[i];
					int nc = c + dc[i];

					if (nr < 0 || nr >= 100 || nc < 0 || nc >= 100) {
						continue;
					}
					if (maze[nr][nc] == 3) {
						answer = 1;
						break;
					}

					if (maze[nr][nc] == 0) {
						queue.offer(new int[] { nr, nc });
						maze[nr][nc] = 1;
					}
				}
			}
			System.out.printf("#%d %d%n", t, answer);
		}
	}
}