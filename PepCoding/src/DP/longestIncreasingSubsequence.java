package DP;

public class longestIncreasingSubsequence {

	public static void main(String[] args) {

		int[] arr= {10, 22, 9, 33, 21, 50, 41, 60, 80};
		System.out.println(lis(arr));
	}

	public static int lis(int[] arr) {
		int[] dp = new int[arr.length];
		for(int i=0;i<dp.length;i++) {
			dp[i]=1;
		}
		for (int i = 1; i < arr.length; i++) {
			for (int j = 0; j < i; j++) {
				if(arr[i]>arr[j]) {
					dp[i]=Math.max(dp[i], dp[j]+1);
				}
			}
		}
		int result=Integer.MIN_VALUE;
		for(int i=0;i<dp.length;i++) {
			result = (dp[i]>result)?dp[i]:(result);
		}
		return result;
	}
}
