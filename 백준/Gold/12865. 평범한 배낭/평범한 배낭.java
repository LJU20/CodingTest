import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();

		int[] w = new int[n + 1];
		int[] p = new int[n + 1];

		int[][] dp = new int[n + 1][k + 1];

		for (int i = 1; i <= n; i++) {
			w[i] = sc.nextInt();
			p[i] = sc.nextInt();

			for (int j = 1; j <= k; j++) {
				if (w[i] <= j) {
					dp[i][j] = Math.max(dp[i - 1][j], p[i] + dp[i - 1][j - w[i]]);
				} else {
					dp[i][j] = dp[i - 1][j];
				}
			}
		}
		System.out.println(dp[n][k]);
	}
}
