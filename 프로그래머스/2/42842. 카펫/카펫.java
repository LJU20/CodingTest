class Solution {
	public int[] solution(int a, int b) {
		int[] answer = new int[2];
		answer[0] = (int) ((a / 2 - 2 + Math.sqrt((2 - a / 2) * (2 - a / 2) - 4 * b)) / 2) + 2;
		answer[1] = (int) (b / ((a / 2 - 2 + Math.sqrt((2 - a / 2) * (2 - a / 2) - 4 * b)) / 2)) + 2;
		return answer;
	}
}