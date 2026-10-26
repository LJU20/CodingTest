class Solution {
    public int solution(int n, String control) {
        for(int i = 0; i < control.length(); i++) {
            char ch = control.charAt(i);
            if(ch == 'w') n++;
            else if(ch == 's') n--;
            else if(ch == 'd') n += 10;
            else n -= 10;
        }
        return n;
    }
}