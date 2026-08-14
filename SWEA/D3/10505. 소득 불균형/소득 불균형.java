import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	public static void main(String args[]) throws Exception {

		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {

			int result = 0;
			int total = 0;

			int N = Integer.parseInt(br.readLine());
			int[] arr = new int[N];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			for (int num : arr) {
				total += num;
			}
			for (int num : arr) {
				if (num <= total / arr.length) {
					result += 1;
				}
			}

			System.out.printf("#%d %d\n", test_case, result);
		}
	}
}