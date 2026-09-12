class Solution {
	static String str;

	public String solution(int num) {
		if (num % 2 == 0) {
			str = "Even";
		} else {
			str = "Odd";
		}
		return str;
	}
}