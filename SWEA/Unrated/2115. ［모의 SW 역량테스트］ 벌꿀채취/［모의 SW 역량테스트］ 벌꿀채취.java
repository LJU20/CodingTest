import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int n, m, c; // 벌통의 크기, 벌통의 개수, 꿀을 채취할 수 있는 최대 양
	static int[][] map; // 벌통
	static int[] arr1, arr2; // 일꾼1, 일꾼2가 선택한 벌통
	static int result;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			map = new int[n][n];
			arr1 = new int[m];
			arr2 = new int[m];

			result = 0;

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			for (int i = 0; i < n; i++) { // 일꾼 1이 연속된 M개를 선택한다.
				for (int j1 = 0; j1 <= n - m; j1++) { // n-m번 반복 n=4이고 m=2이면 01 12 23

					for (int k1 = 0; k1 < m; k1++) { // arr[0]에 map[i][j+k]를 저장 map[0][0]부터 map[0][1] map[0][2]
						arr1[k1] = map[i][j1 + k1];
					}
					int total1 = getMax(arr1); // 일꾼 1의 총합

					// 일꾼 2가 연속된 M개를 선택한다.
					for (int j2 = i; j2 < n; j2++) { // 일꾼 1의 다음 부분부터 반복문을 돌린다.
						int start;

						if (i == j2) {
							start = j1 + m; // 일꾼 1의 시작 지점에서 m을 더한 부분을 일꾼 2의 시작 지점으로 지정
						} else { // 시작 지점이 겹치지 않으면
							start = 0; // 0번 열을 일꾼 2의 시작 지점으로 지정
						}
						for (int j = start; j <= n - m; j++) { // 일꾼 2도 연속된 m개를 n-m번 반복하여 선택한다. 그 행에 더 고를 수 있는 공간이 부족하면
																// 반복문이 실행되지 않는다. ex) for(j = 2; j <2; j++)
							for (int k2 = 0; k2 < m; k2++) {
								arr2[k2] = map[j2][j + k2];
							}
							int total2 = getMax(arr2); // 일꾼 2의 총합
							result = Math.max(result, total1 + total2); // 두 일꾼의 이익 합 중 최대값 저장
						}
					}
				}
			}
			System.out.printf("#%d %d%n", tc, result);
		}
	}

	private static int getMax(int[] arr) {
		int max = 0; // 최대값 0으로 초기화

		// m개의 벌통에서 선택 가능한 모든 부분집합을 비트 마스킹으로 확인한다. m이 2이면 00 01 10 11 2^2개
		for (int mask = 0; mask < (1 << m); mask++) {
			int h = 0; // 선택한 꿀의 양
			int sq = 0; // 제곱한 값

			for (int i = 0; i < m; i++) {
				if ((mask & (1 << i)) != 0) { // mask의 값 0~2^2 사이에서 01 10를 AND 연산하여 해당 비트가 1인지를 확인한다.
					h += arr[i];
					sq += arr[i] * arr[i];
				}
			}
			if (h <= c) { // 꿀의 총량이 c 이하일때만 계산한다.
				max = Math.max(max, sq);
			}
		}
		return max;
	}
}
