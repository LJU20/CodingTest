import java.util.ArrayList;

class Solution {
    public ArrayList<Integer> solution(int[] arr, int[] delete_list) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int n : arr) {
            boolean pass = false;

			for (int d : delete_list) {
				if(n == d) {
					pass = true;
				}
			}
			if(!pass) list.add(n);

		}
        return list;
    }
}