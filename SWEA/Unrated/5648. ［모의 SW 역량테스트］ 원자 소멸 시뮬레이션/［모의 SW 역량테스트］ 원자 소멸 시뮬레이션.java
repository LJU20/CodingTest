import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Solution {

	static int N = 4001;
	static int[][] map = new int[N][N]; // map[y][x] 형태로 사용
	static int[] dx = { 0, 0, -1, 1 };  // 방향: 0(상, y증가), 1(하, y감소), 2(좌, x감소), 3(우, x증가)
	static int[] dy = { 1, -1, 0, 0 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine().trim());

		for (int tc = 1; tc <= TC; ++tc) {
			int totalEnergy = 0; // 누적
			int count = Integer.parseInt(br.readLine()); // 원자 수
			ArrayDeque<Unit> dq = new ArrayDeque<>(); // 살아있는 원자들 리스트

			for (int i = 0; i < count; ++i) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				// 음수 보정 및 0.5초 단위 충돌 대응을 위한 2배 처리
				// -1000 ~ 1000 -> 0 ~ 2000 -> 0 ~ 4000
				int x = (Integer.parseInt(st.nextToken()) + 1000) << 1;
				int y = (Integer.parseInt(st.nextToken()) + 1000) << 1;
				int dir = Integer.parseInt(st.nextToken());
				int e = Integer.parseInt(st.nextToken());

				map[y][x] = e; // 그 위치에 있는 원자들이 가진 에너지 누적
				dq.addLast(new Unit(x, y, dir, e));
			}

			// 살아있는 원자들을 이동처리
			while (!dq.isEmpty()) {
				Unit cur = dq.pollFirst();

				if(map[cur.y][cur.x]!=cur.e) { // 이 위치에서 충돌
					totalEnergy += map[cur.y][cur.x];
					map[cur.y][cur.x] = 0;
					continue;
				}
				
				// 이동 후 위치에서 원자의 방향으로 다음 위치 계산
				map[cur.y][cur.x] = 0;
				int nx = cur.x + dx[cur.dir];
				int ny = cur.y + dy[cur.dir];

				if (nx < 0 || nx >= N || ny < 0 || ny >= N)
					continue;

				cur.x = nx;
				cur.y = ny;
				map[cur.y][cur.x] += cur.e;

				dq.addLast(cur);
			}

			System.out.println("#" + tc + " " + totalEnergy);
		}
	}

	static class Unit {
		int x, y, dir, e;

		public Unit(int x, int y, int dir, int e) {
			this.x = x;
			this.y = y;
			this.dir = dir;
			this.e = e;
		}
	}
}