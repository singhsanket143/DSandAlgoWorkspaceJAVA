package DP;

public class matrixChainMultiply {

	public static void main(String[] args) {

		int[] matrix = {1,2,3,4};
		System.out.println(matrixMultiply(matrix));
	}

	public static int matrixMultiply(int[] arr) {
		int[][] dp = new int[arr.length][arr.length];
		for(int l=2;l<arr.length;l++) {
			for(int i=0;i<arr.length-l;i++) {
				int j = i+l;
				dp[i][j]=Integer.MAX_VALUE;
				for(int k=i+1;k<j;k++) {
					dp[i][j]=Math.min(dp[i][j],dp[i][k]+dp[k][j]+arr[i]*arr[k]*arr[j]);
				}
			}
		}
		return dp[0][arr.length-1];
		
	}

}
