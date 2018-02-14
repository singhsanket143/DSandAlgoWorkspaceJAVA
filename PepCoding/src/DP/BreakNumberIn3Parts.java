package DP;

public class BreakNumberIn3Parts {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] dp = new int[1000];
		System.out.println(breakNumber(12, dp));

	}
	
	public static int breakNumber(int n, int[] dp) {
		if(n==1 || n==0)
			return n;
		if(dp[n]!=0)
			return dp[n];
		
		int result = Math.max(n, breakNumber(n/2, dp)+breakNumber(n/3, dp)+breakNumber(n/4, dp));
		dp[n]=result;
		return result;
	}

}
