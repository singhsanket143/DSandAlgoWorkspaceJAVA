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
		long[][] dp=new long[n+1][n+1];
		for(int i=0;i<=n;i++){
			for(int j=0;j<=n;j++){
				dp[i][j]=-1;
			}
		}
		System.out.println(mixture(arr,dp, 0, n-1));

	}
	
	public static long mixture(int[] arr, long[][] dp, int i, int j){
		if (i >= j) {
			return 0;
		} 
		if (dp[i][j] != -1) {
			return dp[i][j];
		}
		dp[i][j]= Long.MAX_VALUE;
		for (int k = i; k <= j; k++) {
			dp[i][j]= Math.min(dp[i][j],mixture(arr, dp, i, k) + mixture(arr, dp, k + 1, j)+ (sum(arr, i, k)*sum(arr, k+1, j)));
		}
		
		return dp[i][j];
	}
	
	public static long sum(int[] arr, int i, int j){
		long result=0;
		for(int m=i;m<=j;m++){
			result = (result%100 + arr[m]%100)%100;
		}
		return result;
	}
}
