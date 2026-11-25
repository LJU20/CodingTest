import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 0; tc < T; tc++) {
			int n = sc.nextInt();
			long[] dp = new long[n + 9];
			final int mod = 1000000007;

			dp[1] = 0;
			dp[2] = 0;
			dp[3] = 3;
			dp[4] = 0;
			dp[5] = 0;
			dp[6] = 13;
			dp[7] = 0;
			dp[8] = 0;
			dp[9] = 57;

			for (int i = 10; i <= n; i++) {
				if (i % 3 != 0) dp[i] = 0;
				else {
					dp[i] = ((((dp[i - 3] * 5) % mod - (dp[i - 6] * 3) % mod + mod) % mod) % mod + (dp[i - 9] % mod))
							% mod;
				}
			}
			System.out.println(dp[n]);
		}
	}
}
