class Solution {
    public int solution(int a, int b) {
        if(((a + b) & 1) == 1 ) return (a + b) << 1;
        else if((a*b & 1) == 1) return a*a + b*b;
        else return Math.abs(a - b);
    }
}