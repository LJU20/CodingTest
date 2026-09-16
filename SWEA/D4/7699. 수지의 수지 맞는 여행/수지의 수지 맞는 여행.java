import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int r, c;
	static char[][] map;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int totalAlpa;
	static int[] Alpa, visited;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			r = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			map = new char[r][c];
			Alpa = new int[26];
			visited = new int[26];

			for (int i = 0; i < r; i++) {
				String str = br.readLine();
				for (int j = 0; j < c; j++) {
					map[i][j] = str.charAt(j);
				}
			}
			totalAlpa = 0;
			for (int i = 0; i < r; i++) {
				for (int j = 0; j < c; j++) {
					Alpa[map[i][j] - 'A']++;
				}
			}
			for (int i = 0; i < 26; i++) {
				if (Alpa[i] > 0) {
					totalAlpa++;
				}
			}

			visited[map[0][0] - 'A'] = 1;
			int answer = dfs(0, 0, 1);
			System.out.printf("#%d %d%n", tc, answer);
		}
	}

	static int dfs(int row, int col, int cnt) {
		int result = cnt;

		if (cnt == totalAlpa) {
			return cnt;
		}

		for (int i = 0; i < 4; i++) {
			int nr = row + dr[i];
			int nc = col + dc[i];

			if (nr < 0 || nr >= r || nc < 0 || nc >= c) {
				continue;
			}

			int idx = map[nr][nc] - 'A';
			if (visited[idx] == 1) {
				continue;
			}
            
			visited[idx] = 1;
			result = Math.max(result, dfs(nr, nc, cnt + 1));
			visited[idx] = 0;
		}
		return result;
	}
}