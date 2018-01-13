package DP;

public class minCoinChange {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] coins= {1,2,5,10,20,50,100,200,500,2000};
		System.out.println(minCoin(coins, 5430));
	}
	
	public static int minCoin(int[] coins, int value) {
		int[][] dp = new int[coins.length+1][value+1];
		for(int i=0;i<=value;i++) {
			dp[0][i]=Integer.MAX_VALUE;
		}
		for(int i=1;i<=coins.length;i++) {
			for(int j=1;j<=value;j++) {
				if(coins[i-1]>j) {
					dp[i][j]=dp[i-1][j];
				} else {
					dp[i][j]=Math.min(dp[i-1][j], 1+dp[i][j-coins[i-1]]);
				}
			}
		}
		return dp[coins.length][value];
	}

}
