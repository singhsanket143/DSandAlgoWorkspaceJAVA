package DP3;

import java.util.Scanner;

public class mixtures {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		for(int i=0;i<n;i++){
			arr[i]=scn.nextInt();
		}
		int[][] dp=new int[n+1][n+1];
		for(int i=0;i<=n;i++){
			for(int j=0;j<=n;j++){
				dp[i][j]=-1;
			}
		}
		System.out.println(mixture(arr,dp, 1, n));

	}
	
	public static int mixture(int[] arr, int[][] dp, int i, int j){
		if (i == j) {
			return 0;
		}
		if (dp[i][j] != -1) {
			return dp[i][j];
		}
		int minCost = Integer.MAX_VALUE;
		for (int k = i; k+1 <= j; k++) {
			int possibleAns = mixture(arr, dp, i, k) + mixture(arr, dp, k + 1, j)
					+ (sum(arr, i, k)*sum(arr, k+1, j));
			minCost = Math.min(minCost, possibleAns);
		}
		dp[i][j] = minCost;
		return minCost;
	}
	
	public static int sum(int[] arr, int i, int j){
		int result=arr[i];
		for(int m=i;m<j;m++){
			result = (result%100 + arr[m]%100)%100;
		}
		return result;
	}
}
