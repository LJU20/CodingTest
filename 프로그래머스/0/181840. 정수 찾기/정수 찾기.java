class Solution {
    public int solution(int[] num_list, int n) {
        for(int a : num_list) {
            if(a == n) return 1;
        }
        return 0;
    }
}