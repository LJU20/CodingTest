class Solution {
    public int[] solution(int[] num_list) {
        int end = num_list.length - 1;
        int[] answer = new int[end+2];
        for(int i = 0; i <= end; i++) {
            answer[i] = num_list[i];
        }
            answer[end+1] = num_list[end] > num_list[end - 1] ? num_list[end]-num_list[end-1] : num_list[end]*2;
        return answer;
    }
}