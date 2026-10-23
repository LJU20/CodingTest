import java.util.*;
class Solution {
    public int[] solution(int[] num_list) {
        int size = num_list.length-5;
        int[] answer = new int[size];
        Arrays.sort(num_list);
        for(int i = 0; i < size; i++) {
            answer[i] = num_list[5+i];
        }
        return answer;
    }
}