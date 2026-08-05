class Solution {
    public int solution(int[] num_list) {
        int mul = 1;
        int add = 0;
        for(int a : num_list){
            mul *= a;
            add += a;
        }
        if(mul < add * add){
            return 1;
        } else{
            return 0;
        }
    }
}