import java.util.ArrayList;

class Solution {
	public boolean solution(int x) {
		boolean answer = true;
		int temp = x;
		ArrayList<Integer> list = new ArrayList<>();
		while (true) {
			if (x < 10) {
				list.add(x % 10);
				break;
			} else {
				list.add(x % 10);
				x /= 10;
			}
		}
		int sum = 0;
		for (int n : list) {
			sum += n;
		}
		if (temp % sum != 0) {
			answer = false;
		}
		return answer;
	}
}