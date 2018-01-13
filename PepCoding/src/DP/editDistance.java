package DP;

public class editDistance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(editdistance("abcdef", "azced"));

	}
	
	public static int editdistance(String str1, String str2) {
		int[][] dp = new int[str1.length()+1][str2.length()+1];
		for(int i=1;i<=str1.length();i++) {
			dp[i][0]=i;
		}
		for(int i=1;i<=str2.length();i++) {
			dp[0][1]=i;
		}
		for(int i=1;i<=str1.length();i++) {
			for(int j=1;j<=str2.length();j++) {
				if(str1.charAt(i-1)==str2.charAt(j-1)) {
					dp[i][j]=dp[i-1][j-1];
				} else {
					dp[i][j]=Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1]))+1;
				}
			}
		}
		return dp[str1.length()][str2.length()];
	}

}
