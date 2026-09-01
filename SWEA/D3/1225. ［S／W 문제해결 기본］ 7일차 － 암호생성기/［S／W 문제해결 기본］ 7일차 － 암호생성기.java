import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int tc = 1; tc <= 10; tc++) {
			int T = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			Deque<Integer> deque = new ArrayDeque<>();

			for (int i = 0; i < 8; i++) {
				deque.offer(Integer.parseInt(st.nextToken()));
			}

			int k = 1;
			while (true) {
				int n = deque.pollFirst();

				n -= k;

				if (n <= 0) {
					deque.offerLast(0);
					break;
				}

				deque.offerLast(n);
				k = k % 5 + 1;
			}
			System.out.printf("#%d ", T);
			for (int i = 0; i < 8; i++) {
				System.out.print(deque.poll() + " ");
			}
			System.out.println();
		}
	}
}
