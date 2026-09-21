import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int[] dp;
	static int day, month, month3, year;
	static int[] price;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			day = Integer.parseInt(st.nextToken());
			month = Integer.parseInt(st.nextToken());
			month3 = Integer.parseInt(st.nextToken());
			year = Integer.parseInt(st.nextToken());

			dp = new int[13];
			price = new int[13];
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i < 13; i++) {
				price[i] = Integer.parseInt(st.nextToken());
			}
			for (int i = 1; i < 13; i++) {
				dp[i] = dp[i - 1] + Math.min(price[i] * day, month);
				if (i >= 3) {
					dp[i] = Math.min(dp[i], dp[i - 3] + month3);
				}
			}
			int total = Math.min(dp[12], year);
			System.out.printf("#%d %d%n", tc, total);
		}
	}
}
