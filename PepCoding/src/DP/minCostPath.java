package DP;

public class minCostPath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] cost = { { 1, 2, 3 }, { 4, 8, 2 }, { 1, 5, 3 } };
		System.out.println(minCost(cost));
	}

	public static int minCost(int[][] arr) {
		int[][] dp = new int[arr.length][arr[0].length];
		dp[0][0]=arr[0][0];
		for (int i = 1; i < arr[0].length; i++) {
			dp[i][0] = dp[i - 1][0] + arr[i][0];
		}
		for (int i = 1; i < arr.length; i++) {
			dp[0][i] = dp[0][i - 1] + arr[0][i];
		}
		for (int i = 1; i < arr.length; i++) {
			for (int j = 1; j < arr[0].length; j++) {
				dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + arr[i][j];
			}
		}
		return dp[arr.length-1][arr[0].length-1];
	}

}
