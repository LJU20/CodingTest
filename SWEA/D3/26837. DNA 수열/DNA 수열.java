import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int l;
	static String dna;
	static char[] ch;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			l = Integer.parseInt(st.nextToken());
			dna = st.nextToken();
			ch = dna.toCharArray();

			int answer = 0;

			for (int i = 0; i < l; i++) {
				int a = 0;
				int g = 0;
				int c = 0;
				int t = 0;

				for (int j = i; j < l; j++) {
					if (ch[j] == 'A')
						a++;
					if (ch[j] == 'G')
						g++;
					if (ch[j] == 'C')
						c++;
					if (ch[j] == 'T')
						t++;

					if (a == t && g == c) {
						answer++;
					}
				}
			}
			System.out.println(answer);
		}
	}
}
