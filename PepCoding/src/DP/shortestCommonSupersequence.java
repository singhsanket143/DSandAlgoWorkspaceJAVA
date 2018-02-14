package DP;

public class shortestCommonSupersequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(shortestCommonSS("AGGTAB", "GXTXAYB"));
	}
	
	public static int shortestCommonSS(String s1, String s2) {
		int l = LCS(s1, s2);
		return (s1.length()+s2.length()-l);
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
