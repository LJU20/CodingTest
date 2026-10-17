import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int[] arr;
	static int n, odd, even, day;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			n = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr = new int[n];
			even = odd = day = 0;
			int max = Integer.MIN_VALUE;
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
				max = Math.max(max, arr[i]);
			}
			for (int i = 0; i < n; i++) {
				int temp = max - arr[i];
				even += temp >> 1;
				odd += temp & 1;
			}
			int diff = even - odd;
			if (diff >= 2) {
				int temp = (diff + 1) / 3;
				odd += 2 * temp;
				even -= temp;
			}
			if (odd == 0 && even == 0) {
				day = 0;
			} else if (odd > even) {
				day = odd * 2 - 1;
			} else {
				day = even * 2;
			}
			System.out.printf("#%d %d%n", tc, day);
		}
	}
}
