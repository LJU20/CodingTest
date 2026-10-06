import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int[] gArr, iArr;
	static boolean[] arr;
	static int totalWin;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			gArr = new int[9];
			iArr = new int[9];
			arr = new boolean[19];
			totalWin = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());

			for (int i = 0; i < 9; i++) {
				gArr[i] = Integer.parseInt(st.nextToken());
				arr[gArr[i]] = true;
			}
			
			int idx = 0;
			for (int i = 1; i < 19; i++) {
				if(arr[i] == true) continue;
				iArr[idx++] = i;
			}
			dfs(0, 0, 0, 0);
			System.out.printf("#%d %d %d%n", tc, totalWin, 362880-totalWin);
		}
	}
	static void dfs(int cnt, int flag, int gScore, int iScore) {
		if(cnt == 9) {
			if(gScore > iScore) totalWin++;
			return;
		}
		
		for (int i = 0; i < 9; i++) {
			if((flag & 1<<i) != 0) continue;
			if(gArr[cnt] > iArr[i]) {
				dfs(cnt+1, flag | 1 << i, gScore+gArr[cnt]+iArr[i], iScore);
			}
			else{
				dfs(cnt+1, flag | 1 << i, gScore, iScore+gArr[cnt]+iArr[i]);
			}
		}
	}
}