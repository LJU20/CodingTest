class Solution {

	static boolean[] visited;

	static void dfs(int row, int n, int[][] computers) {
		visited[row] = true;

		for (int col = 0; col < n; col++) {
			if (computers[row][col] == 1 && !visited[col]) {
				dfs(col, n, computers);
			}
		}
	}

	static public int solution(int n, int[][] computers) {
		visited = new boolean[n];

		int answer = 0;

		for (int row = 0; row < n; row++) {
			if (!visited[row]) {

				dfs(row, n, computers);
				answer++;
			}
		}

		return answer;
	}
}