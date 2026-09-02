import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			final int N = Integer.parseInt(st.nextToken());
			final int M = Integer.parseInt(st.nextToken());

			int[] arr = new int[N];

			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(arr);
			ArrayList<Integer> list = new ArrayList<>();
			int l = 0, r = N - 1, ans = -1;
			while (l < r) {
				int sum = arr[l] + arr[r];
				if (sum == M) {
					ans = M;
					break; 

				} else if (sum < M) {
					list.add(sum);
					++l;
				} else {
					--r;
				}
			}
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i) > ans) {
					ans = list.get(i);
				}
			}
			System.out.printf("#%d %d%n", tc, ans);
		}
	}
}
