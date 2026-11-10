import java.util.ArrayList;
import java.util.StringTokenizer;

class Solution {
    public ArrayList<String> solution(String my_string) {
        ArrayList<String> list = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(my_string);
        while(st.hasMoreTokens()) {
        	list.add(st.nextToken());
        }
        return list;
    }
}