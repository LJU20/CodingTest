import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

class Solution {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			int result = 0;
			for (int i = 0; i <= N; i++) {
				for (int j = 0; j <= N; j++) {
					int rad = i * i + j * j;
					if (rad <= N * N) {
						if ((i == 0 && j != 0) || (i != 0 && j == 0)) {
							result += 2;
						} else if (i == 0 && j == 0)
							result++;
						else {
							result += 4;
						}
					}
				}
			}
			System.out.printf("#%d %d\n", t, result);
		}
	}
}
