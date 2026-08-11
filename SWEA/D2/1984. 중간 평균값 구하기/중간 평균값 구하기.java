import java.util.Arrays;
import java.util.Scanner;


class Solution
{
	public static void main(String args[]) throws Exception
	{

		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int add = 0;
			int[] arr = new int[10];
			for(int i = 0; i < 10; i++) {
				arr[i] = sc.nextInt();
			}
			Arrays.sort(arr);
			for(int i = 1; i < 9; i++) {
				add += arr[i];
			}
			int result = add+4;
			result /= 8;
		
			System.out.printf("#%d %d\n", test_case, result);
		}
	}
}