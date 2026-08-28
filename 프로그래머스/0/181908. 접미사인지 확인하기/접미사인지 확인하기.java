class Solution {
	static int solution(String my_string, String is_suffix) {

		if (is_suffix.length() > my_string.length())
			return 0;
		String str = my_string.substring(my_string.length() - is_suffix.length());
		if (str.equals(is_suffix))
			return 1;
		else
			return 0;
	}
}