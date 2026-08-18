import java.io.BufferedReader;
import java.io.InputStreamReader;

class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			System.out.print("#");
		}
	}
}