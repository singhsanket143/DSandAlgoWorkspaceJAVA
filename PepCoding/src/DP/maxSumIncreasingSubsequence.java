package DP;

public class maxSumIncreasingSubsequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {1, 101, 2, 3, 100, 4, 5};
		System.out.println(maxSumLIS(arr));

	}
	
	public static int maxSumLIS(int[] arr) {
		int[] dp=new int[arr.length];
		int max = Integer.MIN_VALUE;
		for(int i=0;i<arr.length;i++) {
			dp[i]=arr[i];
		}
		for(int i=1;i<arr.length;i++) {
			for(int j=0;j<i;j++) {
				if(dp[i]<arr[i]+dp[j] && arr[i]>arr[j]) {
					dp[i]=arr[i]+dp[j];
				}
			}
		}
		for(int i=0;i<arr.length;i++) {
			max=(dp[i]>max)?dp[i]:max;
		}
		return max;
	}

}
