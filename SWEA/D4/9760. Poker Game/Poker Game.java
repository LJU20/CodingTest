import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static char[] suit;
	static int[] rank;
	static int flush, straight, score;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			suit = new char[4];
			rank = new int[14];
			flush = straight = score = 0;

			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 5; i++) {
				String str = st.nextToken();
				if (str.charAt(0) == 'S') suit[0]++;

				if (str.charAt(0) == 'D') suit[1]++;

				if (str.charAt(0) == 'H') suit[2]++;

				if (str.charAt(0) == 'C') suit[3]++;

				char c = str.charAt(1);
				if (c == 'A') rank[1]++;
				
				else if (c == 'T') rank[10]++;

				else if (c == 'J') rank[11]++;

				else if (c == 'Q') rank[12]++;

				else if (c == 'K') rank[13]++;

				else rank[str.charAt(1) - '0']++;
			}

			for (int i = 0; i < 4; i++) {
				if (suit[i] == 5) flush++;
			}
            
			int max = 0;
			int min = 14;
			int dist = 0;
			for (int i = 1; i <= 13; i++) {
				score += rank[i]*rank[i];
				if (rank[i] > 0) {
					max = Math.max(max, i);
					min = Math.min(min, i);
					dist++;
				}
			}
			if (dist == 5 && max - min == 4) straight++;

			if (rank[1] > 0 && rank[10] > 0 && rank[11] > 0 && rank[12] > 0 && rank[13] > 0) straight++;
            
			if (flush > 0 && straight > 0) System.out.printf("#%d Straight Flush%n", tc);
			else if (score == 17) System.out.printf("#%d Four of a Kind%n", tc);
			else if (score == 13) System.out.printf("#%d Full House%n", tc);
			else if (flush > 0) System.out.printf("#%d Flush%n", tc);
			else if (straight > 0) System.out.printf("#%d Straight%n", tc);
			else if (score == 11) System.out.printf("#%d Three of a kind%n", tc);
			else if (score == 9) System.out.printf("#%d Two pair%n", tc);
			else if (score == 7) System.out.printf("#%d One pair%n", tc);
			else System.out.printf("#%d High card%n", tc);
		}
	}
}
