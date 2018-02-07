package DP1;

import java.util.Scanner;

public class adjacentBitCount {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		long[][][] dp = new long[1001][1001][2];
		int mod = 1000000007;
		dp[1][0][0] = 1;
		dp[1][0][1] = 1;
		for (int i = 2; i <= 1000; i++) {
			dp[i][i - 1][0] = 0;
			dp[i][i - 1][1] = 1;
			dp[i][0][1] = dp[i - 1][0][0];
			dp[i][0][0] = dp[i - 1][0][0] + dp[i - 1][0][1];
			if (dp[i][0][0] >= mod) {
				dp[i][0][0] %= mod;
			}
		}
		for (int i = 2; i <= 1000; i++) {
			for (int j = 1; j < i; j++) {
				dp[i][j][0] = dp[i - 1][j][0] + dp[i - 1][j][1];
				dp[i][j][1] = dp[i-1][j][0]+dp[i-1][j-1][1];
				if (dp[i][j][0] >= mod) {
					dp[i][j][0] %= mod;
				}
				if (dp[i][j][0] >= mod) {
					dp[i][j][0] %= mod;
				}
			}
		}
		
		int t = scn.nextInt();
		while(t-- > 0) {
			int i = scn.nextInt();
			int n = scn.nextInt();
			int k = scn.nextInt();
			if(n==0 && k==0) {
				System.out.print(i+" "+"1");
			} else {
				long ans = dp[n][k][1]+dp[n][k][0];
				if(ans>=mod) {
					ans%=mod;
				}
				System.out.print(i+" "+ans);
			}
			System.out.println();
		}

	}

}
