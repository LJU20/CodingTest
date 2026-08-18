import java.io.BufferedReader;
import java.io.InputStreamReader;

class Solution {

	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		
		char[] alpa = new char[str.length()];
		
		for(int i = 0; i < str.length(); i++) {
			alpa[i] = str.charAt(i);
		}
		for(int ch : alpa) {
			System.out.print(ch - 64 + " ");
		}
	}
}
