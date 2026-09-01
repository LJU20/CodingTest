import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			ArrayList<String> cardList = new ArrayList<>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				cardList.add(st.nextToken());
			}

			int left;
			int right;
			if (N % 2 == 1) {
				left = N / 2 + 1;
				right = N - left;
			} else {
				left = N / 2;
				right = N - left;
			}

			Deque<String> dequeLeft = new ArrayDeque<>();
			Deque<String> dequeRight = new ArrayDeque<>();
			Deque<String> dequeSuffle = new ArrayDeque<>();

			for (int i = 0; i < left; i++) {
				dequeLeft.offerLast(cardList.get(i));
			}
			for (int i = left; i < cardList.size(); i++) {
				dequeRight.offerLast(cardList.get(i));
			}

			if (left > right) {
				dequeSuffle.offerLast(dequeLeft.pollLast());
				for (int i = 0; i < right; i++) {
					dequeSuffle.offerLast(dequeRight.pollLast());
					dequeSuffle.offerLast(dequeLeft.pollLast());

				}
			} else {
				for (int i = 0; i < right; i++) {
					dequeSuffle.offerLast(dequeRight.pollLast());
					dequeSuffle.offerLast(dequeLeft.pollLast());
				}

			}
			System.out.printf("#%d ", tc);
			while (!dequeSuffle.isEmpty()) {
				System.out.print(dequeSuffle.pollLast() + " ");
			}
			System.out.println();
		}
	}
}