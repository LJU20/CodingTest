import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int row, col, h, w, answer;
	static char[][] grid;
	static char[][] gridT;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			h = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			grid = new char[h][w];
			answer = 0;
			row = h;
			col = w;

			for (int i = 0; i < h; i++) {
				String str = br.readLine();
				for (int j = 0; j < w; j++) {
					grid[i][j] = str.charAt(j);
				}
			}

			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if (grid[i][j] == '.') {
						row--;
						break;
					}
				}
			}

			for (int j = 0; j < w; j++) {
				for (int i = 0; i < h; i++) {
					if (grid[i][j] == '.') {
						col--;
						break;
					}
				}
			}

			if (row == h && col == w) {
				answer = Math.min(h, w);
			} else {
				answer = row + col;
			}
			System.out.println(answer);
		}
	}
}
