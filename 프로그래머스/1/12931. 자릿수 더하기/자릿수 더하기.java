import java.util.*;

public class Solution {
	public int solution(int n) {
		int answer = 0;
		ArrayList<Integer> list = new ArrayList<>();
		while (n > 0) {
			list.add(n % 10);
			n /= 10;
		}
		for (int i = 0; i < list.size(); i++) {
			answer += list.get(i);
		}
		return answer;
	}
}