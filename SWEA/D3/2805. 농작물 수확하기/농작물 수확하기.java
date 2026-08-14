import java.util.Scanner;

class Solution {
	public static void main(String args[]) throws Exception {

		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			int[][] arr = new int[N][N];
			int result = 0;
			
			for (int i = 0; i < N; i++) {
				String str = sc.next();
				
				for (int j = 0; j < N; j++) {
					arr[i][j] = str.charAt(j) - '0';
				}
			}
			int mid = N / 2;
			for (int i = 0; i < N; i++) {
				int dis = i - mid;
				if(dis < 0) {
					dis = -dis;
				}
				for (int j = mid - (mid - dis); j < mid + (mid - dis) + 1; j++) {
					result += arr[i][j];
				}
			}

			System.out.printf("#%d %d", test_case, result);
			System.out.println();

		}
	}
}