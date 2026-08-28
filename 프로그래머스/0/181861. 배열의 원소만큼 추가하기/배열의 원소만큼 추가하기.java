import java.util.ArrayList;

class Solution {
    public ArrayList<Integer> solution(int[] arr) {
        ArrayList<Integer> list = new ArrayList<>();
    	for(int num : arr) {
    		for(int i = 0; i < num; i++) {
    			list.add(num);
    		}
    	}
        
        return list;
    }
}