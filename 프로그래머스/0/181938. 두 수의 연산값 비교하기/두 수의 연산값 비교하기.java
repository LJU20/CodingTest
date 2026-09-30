class Solution {
    public int solution(int a, int b) {
        String str = ""+a + b;
        int num = Integer.parseInt(str);
        return Math.max(num, 2*a*b);
    }
}