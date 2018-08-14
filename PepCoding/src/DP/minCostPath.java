package DP;

import java.util.Scanner;

public class minCostPath {
	
	public static int[][] dp;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[][] cost = { { 1, 2, 3 }, { 4, 8, 2 }, { 1, 5, 3 } };
//		System.out.println(minCost(cost));
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int m = scn.nextInt();
		int q=scn.nextInt();
		int[][] arr = new int[n][m];
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				char ch=scn.next().charAt(0);
				arr[i][j] = (ch=='*')?0:1;
			}
		}
		dp = new int[n][m];
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				char ch=scn.next().charAt(0);
				dp[i][j] = (arr[i][j]==1)?1:Integer.MAX_VALUE;
			}
		}
		
		int s1=scn.nextInt();
		int s2=scn.nextInt();
		while(q-- > 0) {
			int d1=scn.nextInt();
			int d2=scn.nextInt();
		}
	}

	public static int minCost(int[][] arr) {
		int[][] dp = new int[arr.length][arr[0].length];
		dp[0][0] = arr[0][0];
		for (int i = 1; i < arr[0].length; i++) {
			dp[i][0] = dp[i - 1][0] + arr[i][0];
		}
		for (int i = 1; i < arr.length; i++) {
			dp[0][i] = dp[0][i - 1] + arr[0][i];
		}
		for (int i = 1; i < arr.length; i++) {
			for (int j = 1; j < arr[0].length; j++) {
				dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + arr[i][j];
			}
		}
		return dp[arr.length - 1][arr[0].length - 1];
	}

	public static int costPath(int[][] arr, int s1, int s2, int d1, int d2) {
		int[][] dp = new int[arr.length][arr[0].length];
		dp[s1][d1] = arr[s1][s2];
		for (int i = s1 + 1; i < arr.length; i++) {
			if(arr[i][s2]==-1) {
				break;
			}
			dp[i][s2] = dp[i - 1][s2] + arr[i][s2];
		}
		for (int i = s1 - 1; i >= 0; i--) {
			if(arr[i][s2]==-1) {
				break;
			}
			dp[i][s2] = dp[i + 1][s2] + arr[i][s2];
		}

		for (int i = s2 + 1; i < arr[0].length; i++) {
			if(arr[s1][i]==-1) {
				break;
			}
			dp[s1][i] = dp[s1][i - 1] + arr[s1][i];
		}
		for (int i = s2 - 1; i >= 0; i--) {
			if(arr[s1][i]==-1) {
				break;
			}
			dp[s1][i] = dp[s1][i + 1] + arr[s1][i];
		}
		for (int i = s1+1; i < arr.length; i++) {
			for (int j = s2+1; j < arr[0].length; j++) {
				if(arr[i][j]==-1) {
					dp[i][j]=-1;
				}
				dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + arr[i][j];
			}
		}
		for (int i = s1-1; i >=0; i--) {
			for (int j = s2-1; j >=0; j--) {
				dp[i][j] = Math.min(dp[i + 1][j], dp[i][j + 1]) + arr[i][j];
			}
		}
		return dp[arr.length - 1][arr[0].length - 1];
	}

}
