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
	static boolean finish;

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
			finish = false;

			for (int i = 0; i < r; i++) {
				String str = br.readLine();
				for (int j = 0; j < c; j++) {
					map[i][j] = str.charAt(j);
				}
			}
			totalAlpa = 0;
			for (int i = 0; i < r; i++) {
				for (int j = 0; j < c; j++) {
					Alpa[map[i][j] - 'A']++; // 알파벳이 나온 횟수 만큼 1 증가
				}
			}
			for (int i = 0; i < 26; i++) {
				if (Alpa[i] > 0) { // 알파벳이 나왔으면
					totalAlpa++; // 총 알파벳 종류를 카운트
				}
			}

			visited[map[0][0] - 'A'] = 1; // 처음 (0, 0) 알파벳 처리
			int answer = dfs(0, 0, 1);
			System.out.printf("#%d %d%n", tc, answer);
		}
	}

	static int dfs(int row, int col, int cnt) { // 현재 위치 (row, col), 방문한 알파벳 개수 cnt
		int result = cnt;

		// 전체 알파벳만큼 나오면 가지치기
		if (cnt == totalAlpa) {
			finish = true; // 즉시 반환 시키기 위한 플래그
			return cnt;
		}

		// 4방위 탐색하면서 알파벳의 개수 cnt 추가
		for (int i = 0; i < 4 && !finish; i++) {
			int nr = row + dr[i];
			int nc = col + dc[i];

			if (nr < 0 || nr >= r || nc < 0 || nc >= c) {
				continue;
			}

			int idx = map[nr][nc] - 'A'; // 알파벳을 int로 바꿔서 visited[]에 사용
			if (visited[idx] == 1) { // 이미 방문한 곳이면 continue
				continue;
			}

			visited[idx] = 1; // 방문한 곳이 아니면 방문처리

			result = Math.max(result, dfs(nr, nc, cnt + 1)); // dfs를 돌면서 더 큰 cnt를 찾으면 result값 갱신

			visited[idx] = 0; // 방문처리 원복

		}
		return result;
	}
}
