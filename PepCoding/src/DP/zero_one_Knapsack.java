package DP;

public class zero_one_Knapsack {

	public static void main(String[] args) {

		// Bottom Up Approach
		int val[] = { 60, 100, 120 };
		int wts[] = { 10, 20, 30 };
		int tar = 50;
		System.out.println(knapscak(wts, val, tar));
		// Complexity O(nW)
	}

	public static int knapscak(int[] wts, int[] val, int tar) {
		int[][] dp = new int[wts.length + 1][tar + 1];
		for (int i = 1; i <= wts.length; i++) {
			for (int j = 1; j <= tar; j++) {
				if (wts[i - 1] > j) {
					dp[i][j] = dp[i][j - 1];
				} else {
					int selected = val[i - 1] + dp[i - 1][j - wts[i - 1]];
					int notSelected = dp[i - 1][j];
					dp[i][j] = Math.max(selected, notSelected);
				}
			}
		}
		return dp[wts.length][tar];
	}
}
