import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			long N = Long.parseLong(br.readLine());
			long cnt = 0;
			while (N > 2) {
				long rootN = (long) Math.sqrt(N);
				if (rootN * rootN == N) {
					N = rootN;
					cnt++;
				} else {
					cnt += (rootN + 1) * (rootN + 1) - N + 1;
					N = rootN + 1;
				}
			}
			System.out.printf("#%d %d%n", tc, cnt);
		}
	}
}
