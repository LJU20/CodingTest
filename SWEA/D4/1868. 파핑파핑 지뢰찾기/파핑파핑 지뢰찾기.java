import java.io.BufferedReader;
import java.io.InputStreamReader;

class Solution {

	static int[] dr = { -1, -1, 0, 1, 1, 1, 0, -1 };
	static int[] dc = { 0, 1, 1, 1, 0, -1, -1, -1 };
	static boolean[][] visited;

	static void init(char[][] board) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				// i j 의 주변 8칸에 지뢰가 있으면 지뢰만큼 숫자배정
				// 지뢰가 없으면 0 배정
				// 지뢰가 있는 칸이면 그대로
				if (board[i][j] == '*') {
					visited[i][j] = true;
					continue;
				}

				int count = 0;

				for (int k = 0; k < 8; k++) {
					int nr = i + dr[k];
					int nc = j + dc[k];
					if (nr < 0 || nr >= board.length || nc < 0 || nc >= board.length)
						continue;
					if (board[nr][nc] == '*') {
						count++;
					}
					board[i][j] = (char) ('0' + count);
				}
			}
		}
	}

	static void zeroCheck(char[][] board, int row, int col) {

		visited[row][col] = true;

		if (board[row][col] != '0') {
			return;
		}

		for (int i = 0; i < 8; i++) {
			int nr = row + dr[i];
			int nc = col + dc[i];
			if (nr < 0 || nr >= board.length | nc < 0 || nc >= board.length)
				continue;

			if (board[nr][nc] == '*')
				continue;

			if (visited[nr][nc])
				continue;

			visited[nr][nc] = true;

			if (board[nr][nc] == '0') {
				zeroCheck(board, nr, nc);
			}
		}
	}

	// 보드에 숫자를 전부 집어 넣는다. (지뢰가 있는곳은 방문한 것으로 처리한다.)
	// zeroCheck를 하면서 0과 인접한 부분을 전부 방문 처리한다.
	// visited 배열이 false 인 곳의 개수를 센다.

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			char[][] board = new char[N][N];
			for (int i = 0; i < N; i++) {
				String str = br.readLine();
				for (int j = 0; j < N; j++) {
					board[i][j] = str.charAt(j);
				}
			}
			visited = new boolean[board.length][board.length];

			init(board);
			int count = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (!visited[i][j] && board[i][j] == '0') {
						count++;
						zeroCheck(board, i, j);
					}
				}
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (!visited[i][j])
						count++;
				}
			}
			System.out.printf("#%d %d\n", tc, count);
		}
	}
}