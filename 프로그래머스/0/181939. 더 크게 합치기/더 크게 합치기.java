class Solution {
    public int solution(int a, int b) {
        if(Integer.parseInt(String.valueOf(a)+String.valueOf(b)) > Integer.parseInt(String.valueOf(b)+String.valueOf(a))) return Integer.parseInt(String.valueOf(a)+String.valueOf(b));
        
    else{
        return Integer.parseInt(String.valueOf(b)+String.valueOf(a));
        }
    }
}