class Solution {
	static int answer = 0;

	static void combination(int[] arr, int start, int r, int n, int p, int res) {
		if (r == 0) {
			if (res == p) {
				answer++;
			}
			return;
		}
		for (int i = start; i < n; i++) {
			combination(arr, i + 1, r - 1, n, p, res + arr[i]);
		}
	}

	public int solution(int[] numbers, int target) {

		int s = 0;
		for (int num : numbers) {
			s += num;
		}
		int p;
		p = (s + target) / 2;

		for (int i = 1; i <= numbers.length; i++) {
			combination(numbers, 0, i, numbers.length, p, 0);
		}

		return answer;
	}
}