import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static int N;
	static int L;
	static int[] score;
	static int[] kcal;

	static int max;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());

			score = new int[N];
			kcal = new int[N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				score[i] = Integer.parseInt(st.nextToken());
				kcal[i] = Integer.parseInt(st.nextToken());
			}
			max = 0;
			generateSubset(0, 0, 0);
			System.out.printf("#%d %d%n", tc, max);
		}
	}

	static void generateSubset(int idx, int totalScore, int totalKcal) {
        
		if (totalKcal > L) {
			return;
		}
        
		if (idx == N) {
			if (totalScore > max) {
				max = totalScore;
			}
			return;
		}
		generateSubset(idx + 1, totalScore + score[idx], totalKcal + kcal[idx]);
		generateSubset(idx + 1, totalScore, totalKcal);
	}
}