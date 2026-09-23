import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			int n = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] arr = new int[n];

			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			int total = 0;

			for (int i = 0; i < n - 1; i++) {
				total += Math.abs(arr[i] - arr[i + 1]);
			}
			int answer = Integer.MAX_VALUE;

			for (int i = 1; i < n - 1; i++) {
				int dis = total;
				dis -= Math.abs(arr[i - 1] - arr[i]);
				dis -= Math.abs(arr[i] - arr[i + 1]);
				dis += Math.abs(arr[i - 1] - arr[i + 1]);
				answer = Math.min(answer, dis);
			}
			System.out.println(answer);
		}
	}
}