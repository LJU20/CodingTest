import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static final long mod = 998244353;
	static long a, b, c, answer;
	static long sA, sB, sC;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			a = Long.parseLong(st.nextToken());
			b = Long.parseLong(st.nextToken());
			c = Long.parseLong(st.nextToken());

			answer = 0;
			sA = a * (a + 1) / 2;
			sB = b * (b + 1) / 2;
			sC = c * (c + 1) / 2;
            
			answer = ((((sA % mod) * (sB % mod)) % mod) * (sC % mod)) % mod;
            
			System.out.println(answer);
		}
	}
}