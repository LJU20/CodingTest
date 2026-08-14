import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	public static void main(String args[]) throws Exception {

		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			int N = Integer.parseInt(br.readLine());

			String str1 = br.readLine();
			char[] c1 = new char[N];

			for (int i = 0; i < N; i++) {
				c1[i] = str1.charAt(i);
			}
			String str2 = br.readLine();

			char[] c2 = new char[N];
			for (int i = 0; i < N; i++) {
				c2[i] = str2.charAt(i);
			}

			int result = 0;
			for (int i = 0; i < N; i++) {
				if (c1[i] == c2[i])
					result += 1;
			}

			System.out.printf("#%d %d\n", test_case, result);
		}
	}
}