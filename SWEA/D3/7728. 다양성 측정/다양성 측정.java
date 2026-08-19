import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

class Solution {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			String str = br.readLine();

			HashSet<Character> set = new HashSet<>();
			for (int i = 0; i < str.length(); i++) {
				set.add(str.charAt(i));
			}
			System.out.printf("#%d %d\n", t, set.size());
		}
	}
}
