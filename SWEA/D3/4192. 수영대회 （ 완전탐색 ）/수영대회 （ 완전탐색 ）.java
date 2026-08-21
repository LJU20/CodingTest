import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Solution {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {

			int N = Integer.parseInt(br.readLine());

			int[][] pool = new int[N][N];
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					pool[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int[] dr = { -1, 1, 0, 0 };
			int[] dc = { 0, 0, -1, 1 };

			StringTokenizer st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine());
			int C = Integer.parseInt(st.nextToken());
			int D = Integer.parseInt(st.nextToken());

			ArrayList<int[]> list = new ArrayList<>();
			boolean[][] visited = new boolean[N][N];

			list.add(new int[] { A, B, 0 });
			visited[A][B] = true;

			int idx = 0;
			int result = -1;

			while (idx < list.size()) {

				int[] now = list.get(idx);
				idx++;

				int r = now[0];
				int c = now[1];
				int dist = now[2];

				if (r == C && c == D) {
					result = dist;
					break;
				}

				for (int dir = 0; dir < 4; dir++) {

					int nr = r + dr[dir];
					int nc = c + dc[dir];

					if (0 <= nr && nr < N && 0 <= nc && nc < N && pool[nr][nc] != 1 && !visited[nr][nc]) {
						visited[nr][nc] = true;
						list.add(new int[] { nr, nc, dist + 1 });
					}
				}
			}
			System.out.printf("#%d %d\n", t, result);
		}
	}
}
