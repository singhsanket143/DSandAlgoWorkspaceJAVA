package DP3;

import java.util.Scanner;

public class matrixChainMultiply {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n+1];
		for (int i = 0; i <= n; i++) {
			arr[i] = scn.nextInt();
		}
		
		int[][] dp=new int[n+1][n+1];
		for(int i=0;i<=n;i++){
			for(int j=0;j<=n;j++){
				dp[i][j]=-1;
			}
		}
		System.out.println(matrixMultiply(arr,dp, 1, n));

	}

	public static int matrixMultiply(int[] arr, int[][] dp, int i, int j) {
		if (i == j) {
			return 0;
		}
		if (dp[i][j] != -1) {
			return dp[i][j];
		}
		int minCost = Integer.MAX_VALUE;
		for (int k = i; k < j; k++) {
			int possibleAns = matrixMultiply(arr, dp, i, k) + matrixMultiply(arr, dp, k + 1, j)
					+ arr[i - 1] * arr[k] * arr[j];
			minCost = Math.min(minCost, possibleAns);
		}
		dp[i][j] = minCost;
		return minCost;
	}

}
