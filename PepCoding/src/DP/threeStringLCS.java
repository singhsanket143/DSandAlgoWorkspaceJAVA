package DP;

public class threeStringLCS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(lcs("AGGT12", "12TXAYB", "12XBA"));

	}
	
	public static int lcs(String str1, String str2, String str3) {
		int[][][] dp = new int[str1.length()+1][str2.length()+1][str3.length()+1];
		for(int i=1;i<=str1.length();i++) {
			for(int j=1;j<=str2.length();j++) {
				for(int k=1;k<=str3.length();k++) {
					if(i==0 || j==0 || k==0)
						dp[i][j][k]=0;
					else if (str1.charAt(i-1)==str2.charAt(j-1) && str2.charAt(j-1)==str3.charAt(k-1))
						dp[i][j][k]=1+dp[i-1][j-1][k-1];
					else 
						dp[i][j][k]=Math.max(dp[i-1][j][k], Math.max(dp[i][j-1][k], dp[i][j][k-1]));
				}
			}
		}
		return dp[str1.length()][str2.length()][str3.length()];
	}

}
