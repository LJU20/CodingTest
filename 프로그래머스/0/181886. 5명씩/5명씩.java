import java.util.ArrayList;

class Solution {
    public ArrayList<String> solution(String[] names) {
        ArrayList<String> answer = new ArrayList<>();
        
        for(int i = 0; i < names.length; i++) {
            if((i+1) % 5 == 1) answer.add(names[i]);   
        }
        return answer;
    }
}