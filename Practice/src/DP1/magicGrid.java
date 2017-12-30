package DP1;

import java.util.Scanner;

public class magicGrid {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int t = scn.nextInt();
		while (t-- > 0) {
			int m = scn.nextInt();
			int n = scn.nextInt();
			int[][] hm = new int[m][n];
			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
					hm[i][j] = scn.nextInt();
				}
			}
			System.out.println(magicgrid(hm, m - 1, n - 1));
		}

	}

	public static int magicgrid(int[][] hm, int m, int n) {
		int[][] dp = new int[m+1][n+1];
		dp[m][n] = 1;
		dp[m - 1][n] = 1;
		dp[m][n - 1] = 1;
		for (int i = n - 2; i >= 0; i--) {
			dp[m][i] = dp[m][i + 1] - hm[m][i + 1];
		}
		for (int i = m - 2; i >= 0; i--) {
			dp[i][n] = dp[i + 1][n] - hm[i + 1][n];
		}
		for (int i = m - 1; i >= 0; i--) {
			for (int j = n - 1; j >= 0; j--) {
				dp[i][j]=Math.min(dp[i+1][j]-hm[i+1][j], dp[i][j+1]-hm[i][j+1]);
				if(dp[i][j]<=0){
					dp[i][j]=1;
				}
			}
		}
		int result=dp[0][0];
		dp=null;
		return result;
	}

}
