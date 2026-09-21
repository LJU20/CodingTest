import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int[] arr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			arr = new int[n + 1];
			int k = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < k; i++) {
				int a = Integer.parseInt(st.nextToken());
				arr[a]++;
			}
			System.out.printf("#%d", tc);
			for (int i = 1; i < arr.length; i++) {
				if (arr[i] == 0) {
					System.out.print(" " + i);
				}
			}
            System.out.println();
		}
	}
}
