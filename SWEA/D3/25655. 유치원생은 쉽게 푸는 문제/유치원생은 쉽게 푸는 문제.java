import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	public static void main(String args[]) throws Exception {

		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			int N = Integer.parseInt(br.readLine());

			int eight = N / 2;

			if (N == 1) {
				System.out.println("0");
			} else if(N % 2 == 0){
				for(int i = 0; i < eight; i++) {
					System.out.print("8");
				}
				System.out.println();
			} else {
				System.out.print("4");
				for(int i = 0; i < eight; i++) {
					System.out.print("8");
				}
				System.out.println();
			}
		}
	}
}
