import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	static int[] dp;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		dp = new int[1001];
		dp[0] = 1;
		dp[1] = 1;

		for (int i = 2; i <= 1000; i++) {
			int num = 1;
			while (true) {
				boolean p = true;

				for (int j = 0; j <= i / 2; j++) {
				 int ban = dp[i - j] * 2 - dp[i - 2 * j];
				 
				 if(num == ban) {
					 p = false;
					 break;
				 }
				}
				if(p) {
					dp[i] = num;
					break;
				}
				num++;
			}
		}
		for (int tc = 1; tc <= T; tc++) {
			int n = Integer.parseInt(br.readLine());
			System.out.println(dp[n]);
		}
	}
}
