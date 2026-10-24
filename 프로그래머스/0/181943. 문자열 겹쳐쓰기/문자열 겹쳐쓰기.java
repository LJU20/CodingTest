class Solution {
    public String solution(String my_string, String overwrite_string, int s) {
        char[] ms = my_string.toCharArray();
        char[] os = overwrite_string.toCharArray();
        for(int i = 0; i < overwrite_string.length(); i++) {
            ms[i+s] = os[i];
        }
        return String.valueOf(ms);
    }
}