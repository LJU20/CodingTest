import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			String str = br.readLine();
			char[] ch = new char[str.length()];
			for (int i = 0; i < ch.length; i++) {
				ch[i] = str.charAt(i);
			}
			int count = 0;
			int result = 0;

			for (int i = 0; i < ch.length; i++) {
				if (ch[i] == '(') {
					count++;
				} else {
					if (ch[i - 1] == '(') {
						count--;
						result += count;
					} else {
						count--;
						result++;
					}
				}
			}
			System.out.printf("#%d %d%n", tc, result);
		}
	}
}