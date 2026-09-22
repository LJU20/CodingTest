import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());

			if (x == y && x == z) {
				System.out.printf("%d %d %d", x, x, x);
				System.out.println();
				continue;
			}

			if (x > y) {
				if (z != x) {
					System.out.println("-1 -1 -1");
				} else {
					System.out.printf("%d %d %d", x, y, y);
					System.out.println();
				}
			} else if (y > x) {
				if (z != y) {
					System.out.println("-1 -1 -1");
				} else {
					System.out.printf("%d %d %d", x, x, y);
					System.out.println();
				}
			} else {
				if (z > x) {
					System.out.println("-1 -1 -1");

				} else {
					System.out.printf("%d %d %d", z, x, z);
					System.out.println();
				}
			}
		}
	}
}