import java.math.BigInteger;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while (sc.hasNext()) {
			int n = sc.nextInt();
			BigInteger[] dp = new BigInteger[n + 3];
			dp[0] = BigInteger.ONE;
			dp[1] = BigInteger.ONE;
			dp[2] = BigInteger.valueOf(3);
			for (int i = 3; i <= n; i++) {
				dp[i] = dp[i - 1].add(dp[i - 2].multiply(BigInteger.TWO));
			}
			System.out.println(dp[n]);
		}
	}
}
