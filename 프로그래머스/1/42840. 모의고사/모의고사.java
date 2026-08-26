import java.util.ArrayList;

class Solution {
	public ArrayList<Integer> solution(int[] answers) {

		int[] answer1 = { 1, 2, 3, 4, 5 }; // 5
		int[] answer2 = { 2, 1, 2, 3, 2, 4, 2, 5 }; // 8
		int[] answer3 = { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 }; // 10

		int res1 = 0;
		int res2 = 0;
		int res3 = 0;
		int number = 0;
		while (number < answers.length) {

			if (answers[number] == answer1[number % 5]) {
				res1++;
			}
			if (answers[number] == answer2[number % 8]) {
				res2++;
			}
			if (answers[number] == answer3[number % 10]) {
				res3++;
			}
			number++;
		}
		ArrayList<Integer> arrlist = new ArrayList<>();
		int max = Math.max(res1, Math.max(res2, res3));

		if (res1 == max) {
			arrlist.add(1);
		}
		if (res2 == max) {
			arrlist.add(2);
		}
		if (res3 == max) {
			arrlist.add(3);
		}

		return arrlist;
	}
}