package DP;

public class largestSnakeSequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int mat[][] = { { 9, 6, 5, 2 }, { 8, 7, 6, 5 }, { 7, 3, 1, 6 }, { 1, 1, 1, 7 }, };
		System.out.println(snake(4, mat));
	}

	public static int snake(int n, int[][] path) {
		int[][] dp = new int[n][n];
		for (int i = 1; i < n; i++) {
			if (path[0][i] == path[0][i - 1] + 1 || path[0][i] == path[0][i - 1] - 1) {
				dp[0][i] += dp[0][i - 1] + 1;
			}
		}
		for (int i = 1; i < n; i++) {
			if (path[i][0] == path[i - 1][0] + 1 || path[i][0] == path[i - 1][0] - 1) {
				dp[i][0] += dp[i - 1][0] + 1;
			}
		}
		for (int i = 1; i < n; i++) {
			for (int j = 1; j < n; j++) {
				if (path[i - 1][j] == path[i][j] + 1 || path[i - 1][j] == path[i][j] - 1) {
					dp[i][j] = Math.max(dp[i][j], dp[i - 1][j] + 1);
				}
				if (path[i][j - 1] == path[i][j] + 1 || path[i][j - 1] == path[i][j] - 1) {
					dp[i][j] = Math.max(dp[i][j], dp[i][j - 1] + 1);
				}
			}
		}
		int result = Integer.MIN_VALUE;
		for (int i = 1; i < n; i++) {
			for (int j = 1; j < n; j++) {
				result = (dp[i][j] > result) ? dp[i][j] : result;
			}
		}
		return result;
	}

}
