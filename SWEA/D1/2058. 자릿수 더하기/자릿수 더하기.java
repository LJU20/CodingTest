import java.util.Scanner;

class Solution {
	public static void main(String args[]) throws Exception {

		Scanner sc = new Scanner(System.in);

		int num = sc.nextInt();
		int result = 0;
		while (num > 0) {
			result += num % 10;
			num /= 10;
		}
		System.out.println(result);

	}
}