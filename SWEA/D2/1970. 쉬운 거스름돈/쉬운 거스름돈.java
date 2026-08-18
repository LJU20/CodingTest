import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			int f____ = 0;
			int o____ = 0;
			int f___ = 0;
			int o___ = 0;
			int f__ = 0;
			int o__ = 0;
			int f_ = 0;
			int o_ = 0;

			while (N >= 10) {
				if (N >= 50000) {
					f____ += N / 50000;
					N %= 50000;
				} else if (N >= 10000) {
					o____ += N / 10000;
					N %= 10000;
				} else if (N >= 5000) {
					f___ += N / 5000;
					N %= 5000;
				} else if (N >= 1000) {
					o___ += N / 1000;
					N %= 1000;
				} else if (N >= 500) {
					f__ += N / 500;
					N %= 500;
				} else if (N >= 100) {
					o__ += N / 100;
					N %= 100;
				} else if (N >= 50) {
					f_ += N / 50;
					N %= 50;
				} else if (N >= 10) {
					o_ += N / 10;
					N %= 10;
				}
			}
			System.out.printf("#%d\n%d %d %d %d %d %d %d %d\n", t, f____, o____, f___, o___, f__, o__, f_, o_);
		}
	}

}
