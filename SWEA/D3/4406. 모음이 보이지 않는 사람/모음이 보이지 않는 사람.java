import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

class Solution {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	public static void main(String args[]) throws Exception {

		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {

			String str = br.readLine();
			ArrayList<Character> arr = new ArrayList<>();
			for (int i = 0; i < str.length(); i++) {
				arr.add(str.charAt(i));
			}
			ArrayList<Character> alpa = new ArrayList<>();
			for (int c = 0; c < arr.size(); c++) {
				if (!(arr.get(c) == 'a' || arr.get(c) == 'e' || arr.get(c) == 'i' || arr.get(c) == 'o'
						|| arr.get(c) == 'u')) {
					alpa.add(arr.get(c));
				}
			}

			System.out.print("#" + test_case + " ");
			for (Character c : alpa) {
				System.out.print(c);
			}
			System.out.println();
		}
	}
}