package DP;

public class longestRepeatedSubsequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(lrs("aabebcdd"));

	}

	public static int lrs(String str) {
		int[][] dp = new int[str.length()+1][str.length()+1];
		for(int i=1;i<=str.length();i++) {
			for(int j=1;j<=str.length();j++) {
				if(str.charAt(i-1)==str.charAt(j-1) && i!=j) {
					dp[i][j]=1+dp[i-1][j-1];
				} else {
					dp[i][j]=Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
		}
		return dp[str.length()][str.length()];
	}
}
