import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static int d, m1, m3, y;
	static int[] price, dp;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			d = Integer.parseInt(st.nextToken());
			m1 = Integer.parseInt(st.nextToken());
			m3 = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());

			price = new int[13];
			dp = new int[13];
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= 12; i++) {
				price[i] = Integer.parseInt(st.nextToken());
			}

			for (int i = 1; i < 13; i++) {
				dp[i] = dp[i - 1] + Math.min(price[i] * d, m1);

				if (i >= 3) {
					dp[i] = Math.min(dp[i], dp[i - 3] + m3);
				}
			}
			dp[12] = Math.min(dp[12], y);
			System.out.printf("#%d %d%n", tc, dp[12]);
		}
	}
}
