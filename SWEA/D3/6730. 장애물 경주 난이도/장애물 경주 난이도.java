import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	public static void main(String args[]) throws Exception {

		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {

			int N = Integer.parseInt(br.readLine());
			int[] arr = new int[N];
			st = new StringTokenizer(br.readLine());

			for (int i = 0; i < N; i++) {

				arr[i] = Integer.parseInt(st.nextToken());
			}
			int k = 0;
			int up = 0;
			int down = 0;

			while (k < N - 1) {
				int high = arr[k] - arr[k + 1];
				if (high > 0 && high > down) {
					down = high;
				} else if (high < 0) {
					if (Math.abs(high) > up) {
						up = Math.abs(high);
					}
				}
				k++;
			}
			System.out.printf("#%d %d %d\n", test_case, up, down);
		}
	}
}