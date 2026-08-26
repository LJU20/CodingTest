class Solution {
	public int solution(int[][] sizes) {
		
		for(int i = 0; i < sizes.length; i++) {
			if(sizes[i][0] < sizes[i][1]) {
				int temp = sizes[i][0];
				sizes[i][0] = sizes[i][1];
				sizes[i][1] = temp;
			}
		}
		
		int maxRow = 0;
		int maxCol = 0;
		for (int i = 0; i < sizes.length; i++) {
			if (sizes[i][0] > maxRow)
				maxRow = sizes[i][0];
			if (sizes[i][1] > maxCol)
				maxCol = sizes[i][1];
		}

		return maxRow * maxCol;
	}
}