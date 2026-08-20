import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class Solution {
	static ArrayList<Integer> list = new ArrayList<>();
	static int res = 0;

	static void combination(int[] arr, int start, int r, int n, int B, int res) {
		if (r == 0) {
			if (res >= B) {
				list.add(res);
			}
			return;
		}
		for (int i = start; i < n; i++) {
			combination(arr, i + 1, r - 1, n, B, res + arr[i]);
		}
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine());
			int[] arr = new int[N];
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			for (int i = 1; i <= N; i++) {
				combination(arr, 0, i, N, B, 0);
			}

			Collections.sort(list);

			int answer = list.get(0) - B;

			System.out.printf("#%d %d\n", t, answer);

			list.clear();
		}
	}
}
