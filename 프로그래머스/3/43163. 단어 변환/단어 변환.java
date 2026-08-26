import java.util.ArrayDeque;
import java.util.Queue;

class Solution {
	static class State {
		String word;
		int count;

		State(String word, int count) {
			this.word = word;
			this.count = count;
		}
	}

	static boolean check(String begin, String word) {
		int check = 0;
		for (int i = 0; i < begin.length(); i++) {
			if (begin.charAt(i) == word.charAt(i))
				check++;
		}
		if (check == begin.length() - 1)
			return true;
		else
			return false;
	}

	static int solution(String begin, String target, String[] words) {
    
		Queue<State> queue = new ArrayDeque<>();
		queue.offer(new State(begin, 0));
		boolean visited[] = new boolean[words.length];

		while (!queue.isEmpty()) {
			State current = queue.poll();
			String word = current.word;
			int count = current.count;

			if (word.equals(target)) {
				return count;
			}

			for (int i = 0; i < words.length; i++) {
				if (visited[i])
					continue;

				if (check(word, words[i])) {
					visited[i] = true;

					queue.offer(new State(words[i], count + 1));
				}
			}
		}
		return 0;
	}
}