package DP;

public class longestPalindromicSubsequence {

	public static void main(String[] args) {

		System.out.println(lps("geeksforgeeks"));
	}
	
	public static int lps(String str) {
		int[][] dp = new int[str.length()][str.length()];
		for(int i=0;i<str.length();i++) {
			dp[i][i]=1;
		}
		for(int i=0;i<str.length();i++) {
			dp[0][i]=1;
		}
		for(int l=2;l<=str.length();l++) {
			for(int i=0;i<str.length()-l+1;i++) {
				int j=i+l-1;
				if(str.charAt(i)==str.charAt(j)) {
					dp[i][j]=Math.max(dp[i][j-1],dp[i+1][j])+2;
				} else {
					dp[i][j]=Math.max(dp[i][j-1],dp[i+1][j]);
				}
			}
		}
		return dp[0][str.length()-1];
	}

}
