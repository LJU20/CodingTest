import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Solution {

	static int[] cage;
	static int[][] arr;
	static int N, X, M;
	static int maxSum;
	static ArrayList<int[]> list;

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {

			StringTokenizer st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken());
			X = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			cage = new int[N];
			arr = new int[M][3];
			list = new ArrayList<>();

			maxSum = -1;

			for (int i = 0; i < M; i++) {

				st = new StringTokenizer(br.readLine());

				int l = Integer.parseInt(st.nextToken());
				int r = Integer.parseInt(st.nextToken());
				int s = Integer.parseInt(st.nextToken());

				arr[i][0] = l;
				arr[i][1] = r;
				arr[i][2] = s;
			}

			permutation(0);

			System.out.printf("#%d ", tc);

			if (maxSum == -1) {
				System.out.println(-1);
			} else {
				for (int n : list.get(0)) {
					System.out.printf("%d ", n);
				}
				System.out.println();
			}
		}
	}

	static void permutation(int cnt) {

		if (cnt == N) {

			for (int i = 0; i < M; i++) {

				int l = arr[i][0];
				int r = arr[i][1];
				int s = arr[i][2];

				int recordSum = 0;

				for (int j = l - 1; j <= r - 1; j++) {
					recordSum += cage[j];
				}

				if (recordSum != s) {
					return;
				}
			}

			int sum = 0;
			for (int n : cage) {
				sum += n;
			}

			if (sum > maxSum) {

				maxSum = sum;

				list.clear();
				list.add(cage.clone());

			} else if (sum == maxSum) {

				list.add(cage.clone());
			}

			return;
		}

		for (int i = 0; i <= X; i++) {

			cage[cnt] = i;

			permutation(cnt + 1);
		}
	}
}