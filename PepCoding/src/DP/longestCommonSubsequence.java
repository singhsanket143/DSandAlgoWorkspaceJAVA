package DP;

public class longestCommonSubsequence {

	public static void main(String[] args) {

		// Bottom Up Approach
		System.out.println(LCS("abcdaf", "acbcf"));
		// Complexity O(mn)
	}

	public static int LCS(String str1, String str2) {
		int[][] dp = new int[str1.length() + 1][str2.length() + 1];
		for (int i = 1; i <= str1.length(); i++) {
			for (int j = 1; j <= str2.length(); j++) {
				if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}
		return dp[str1.length()][str2.length()];
	}
}
