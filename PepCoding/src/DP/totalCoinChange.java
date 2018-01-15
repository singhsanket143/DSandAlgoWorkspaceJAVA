package DP;

public class totalCoinChange {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] coins= {1,2,3};
		System.out.println(totalCoinsChainge(coins, 5));

	}
	
	public static int totalCoinsChainge(int[] coins, int amount) {
		int[][] dp = new int[coins.length+1][amount+1];
		for(int i=0;i<=coins.length;i++) {
			dp[i][0]=1;
		}
//		for(int i=0;i<=amount;i++) {
//			dp[0][i]=1;
//		}
		for(int i=1;i<=coins.length;i++) {
			for(int j=1;j<=amount;j++) {
				if(coins[i-1]>j) {
					dp[i][j]=dp[i-1][j];
				} else {
					dp[i][j]=dp[i-1][j]+dp[i][j-coins[i-1]];
				}
			}
		}
		return dp[coins.length][amount];
	}

}
