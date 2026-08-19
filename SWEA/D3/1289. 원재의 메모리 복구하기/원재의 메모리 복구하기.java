import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for (int x = 1; x <= T; x++) {
			String str = br.readLine();

			char[] ch = new char[str.length()];
			for (int i = 0; i < str.length(); i++) {
				ch[i] = str.charAt(i);
			}
			int i = 0;
			int result = 0;
			char key = '0';
			
			while(i < ch.length) {
				if(ch[i] == key) {
					i++;
				} else {
					if(key == '0') key = '1';
					else key = '0';
					result += 1;
					i++;
				}
			}

			System.out.printf("#%d %d\n", x, result);
		}
	}
}
