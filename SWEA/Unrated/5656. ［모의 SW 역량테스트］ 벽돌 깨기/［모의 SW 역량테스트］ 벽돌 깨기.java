import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static int n, w, h, bCnt; // 구슬, 가로, 세로, 남은 블럭
	static int[][] map;

	static Queue<int[]> queue;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());

			map = new int[h][w];
			for (int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < w; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			bCnt = Integer.MAX_VALUE;

			dfs(0);
			System.out.printf("#%d %d%n", tc, bCnt);
		}
	}

	static void dfs(int cnt) { // 중복 순열로 구슬을 떨어뜨릴 모든 위치 탐색
		if (cnt == n || blackCheck(map) == 0) { // n번 실행했거나 벽돌이 없을경우 종료
			bCnt = Math.min(bCnt, blackCheck(map)); // 남은 벽돌의 최소 개수 계산
			return;
		}

		for (int c = 0; c < w; c++) { // 모든 열을 돌면서
			int r = 0;

			while (r < h && map[r][c] == 0) { // 맨 위가 0이면 한 칸 아래로 내려간다.
				r++;
			}
			if (r == h)
				continue; // 현재 열이 비었으면 다음 열로 넘어간다.

			int[][] newMap = copyMap(map); // 원복을 위한 맵 복사

			bfs(r, c);

			dfs(cnt + 1);

			map = newMap; // 맵 원복

		}
	}

	static void bfs(int r, int c) {
		queue = new ArrayDeque<>();
		queue.offer(new int[] { r, c, map[r][c] }); // 행, 열, 벽돌의 숫자
		map[r][c] = 0; // 시작 위치를 0으로 처리

		while (!queue.isEmpty()) {

			int[] cur = queue.poll();

			int cr = cur[0];
			int cc = cur[1];
			int size = cur[2];

			for (int d = 0; d < 4; d++) {
				for (int i = 1; i < size; i++) { // 현재 벽돌을 기준으로 size - 1칸까지 탐색
					int nr = cr + dr[d] * i;
					int nc = cc + dc[d] * i;

					if (nr < 0 || nr >= h || nc < 0 || nc >= w)
						break;

					if (map[nr][nc] > 0) { // 연쇄적으로 제거할 벽돌을 다시 큐에 넣음
						queue.offer(new int[] { nr, nc, map[nr][nc] });
					}
					map[nr][nc] = 0; // 제거된 벽돌을 0으로 처리
				}
			}
		}
		fallBlack(map); // 빈 공간의 벽돌을 떨어뜨림

	}

	static void fallBlack(int[][] map) { // 아래에서부터 채우기
		for (int col = 0; col < w; col++) { // 열
			int bottom = h - 1; // 바닥 공간

			for (int row = h - 1; row >= 0; row--) { // 행
				if (map[row][col] != 0) { // 현재 공간이 0이 아니면
					if (bottom != row) { // 벽돌의 배치가 완료되지 않았으면
						int temp = map[row][col]; // 한칸 아래로 내리고 원래 위치를 0으로 만든다.
						map[row][col] = 0;
						map[bottom][col] = temp;
					}
					bottom--; // 바닥 공간을 하나 올린다.
				}
			}
		}
	}

	static int blackCheck(int[][] map) { // 남은 벽돌의 개수를 계산하는 함수
		int count = 0;
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				if (map[i][j] > 0)
					count++;
			}
		}
		return count;
	}

	static int[][] copyMap(int[][] map) { // 원본 배열을 복사하는 함수
		int[][] cMap = new int[h][w];
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				cMap[i][j] = map[i][j];
			}
		}
		return cMap;
	}
}
