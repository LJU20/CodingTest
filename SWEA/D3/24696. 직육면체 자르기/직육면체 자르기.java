import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int answer = 2;

			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 3; i++) {
				if (Integer.parseInt(st.nextToken()) % 2 == 0) {
					answer = 1;
					break;
				}
			}
			System.out.println(answer);
		}
	}
}