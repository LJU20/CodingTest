import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class Solution {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int TC = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= TC; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int X = Integer.parseInt(st.nextToken());
			int Y = Integer.parseInt(st.nextToken());

			int A = (X + Y) / 2;
			int B = (X - Y) / 2;

			System.out.println(A + " " + B);
		}
	}
}