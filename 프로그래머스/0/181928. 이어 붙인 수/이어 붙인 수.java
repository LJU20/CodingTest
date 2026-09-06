import java.util.ArrayList;

class Solution {
	public int solution(int[] num_list) {
		int answer = 0;
		ArrayList<Integer> odd = new ArrayList<>();
		ArrayList<Integer> even = new ArrayList<>();

		for (int n : num_list) {
			if (n % 2 == 0) {
				even.add(n);
			} else {
				odd.add(n);
			}
		}
		int resOdd = 0;
		int resEven = 0;

		for (int i = 0; i < odd.size(); i++) {
			resOdd = resOdd * 10 + odd.get(i);
		}
		for (int i = 0; i < even.size(); i++) {
			resEven = resEven * 10 + even.get(i);
		}
		answer = resOdd + resEven;
		return answer;
	}
}