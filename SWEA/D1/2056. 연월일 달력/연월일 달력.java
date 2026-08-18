import java.io.BufferedReader;
import java.io.InputStreamReader;

class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			String str = br.readLine();
			String year = str.substring(0, 4);
			String month = str.substring(4, 6);
			String day = str.substring(6);

			if (Integer.parseInt(month) > 12 || Integer.parseInt(month) < 1) {
				System.out.printf("#%d -1\n", t);
			} else {
				switch (Integer.parseInt(month)) {
				case 1:
				case 3:
				case 5:
				case 7:
				case 8:
				case 10:
				case 12:
					if (Integer.parseInt(day) > 31 || Integer.parseInt(day) < 1) {
						System.out.printf("#%d -1\n", t);
					} else
						System.out.printf("#%d %s/%s/%s\n", t, year, month, day);
					break;

				case 2:
					if (Integer.parseInt(day) > 28 || Integer.parseInt(day) < 1) {
						System.out.printf("#%d -1\n", t);

					} else
						System.out.printf("#%d %s/%s/%s\n", t, year, month, day);
					break;

				default:
					if (Integer.parseInt(day) > 30 || Integer.parseInt(day) < 1) {
						System.out.printf("#%d -1\n", t);

					} else
						System.out.printf("#%d %s/%s/%s\n", t, year, month, day);
				}
			}
		}
	}
}
