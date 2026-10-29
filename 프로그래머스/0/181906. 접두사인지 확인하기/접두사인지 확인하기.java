class Solution {
    public int solution(String my_string, String is_prefix) {
        int size = is_prefix.length();
        if(size > my_string.length()) return 0;
        String answer ="";
        for(int i = 0; i < size; i++) {
            answer += my_string.charAt(i);
        }
        if(answer.equals(is_prefix)) return 1;
        else return 0;
    }
}