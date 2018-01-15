package DP;

public class longestCommonSubsring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(lcSubstring("abcde", "gbdf"));
	}
	
	public static int lcSubstring(String str1, String str2) {
		int[][] dp = new int[str1.length()+1][str2.length()+1];
		for(int i=1;i<=str1.length();i++) {
			for(int j=1;j<=str2.length();j++) {
				if(str1.charAt(i-1)==str2.charAt(j-1)) {
					dp[i][j]=1+dp[i-1][j-1];
				}
			}
		}
		int result=Integer.MIN_VALUE;
		for(int i=1;i<=str1.length();i++) {
			for(int j=1;j<=str2.length();j++) {
				result=(dp[i][j]>result)?dp[i][j]:result;
			}
		}
		return result;
	}

}
