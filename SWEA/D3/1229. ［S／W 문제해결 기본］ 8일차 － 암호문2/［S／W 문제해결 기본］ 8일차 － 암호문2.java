import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

class Solution {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int tc = 1; tc <= 10; tc++) {
			int N = Integer.parseInt(br.readLine());
			LinkedList<Integer> list = new LinkedList<>();
			StringTokenizer st = new StringTokenizer(br.readLine());

			for (int i = 0; i < N; i++) {
				list.add(Integer.parseInt(st.nextToken()));
			}
			int comNum = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());

			for (int i = 0; i < comNum; i++) {

				char ch = st.nextToken().charAt(0);
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());

				if (ch == 'I') {
					int[] arr = new int[y];
					for (int j = 0; j < y; j++) {
						arr[j] = Integer.parseInt(st.nextToken());
					}
					for (int j = 0; j < y; j++) {
						list.add(x + j, arr[j]);
					}
				} else {
					for (int j = 0; j < y; j++) {
						list.remove(x);
					}
				}
			}
			System.out.printf("#%d ", tc);
			for (int i = 0; i < 10; i++) {
				System.out.print(list.get(i) + " ");
			}
			System.out.println();
		}
	}
}