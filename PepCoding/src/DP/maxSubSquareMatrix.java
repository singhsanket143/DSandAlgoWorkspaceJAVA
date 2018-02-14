package DP;

public class maxSubSquareMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int M[][] = { { 0, 1, 1, 0, 1 }, { 1, 1, 0, 1, 0 }, { 0, 1, 1, 1, 0 }, { 1, 1, 1, 1, 0 }, { 1, 1, 1, 1, 1 },
				{ 0, 0, 0, 0, 0 } };
		System.out.println(maxSubSquareMatrixBottomUp(M));
	}

	public static int maxSubSquareMatrixBottomUp(int[][] arr) {
		int[][] dp = new int[arr.length + 1][arr.length + 1];
		for (int i = 1; i <= arr.length; i++) {
			for (int j = 1; j <= arr[0].length; j++) {
				if (arr[i - 1][j - 1] == 0) {
					dp[i][j] = 0;
				} else {
					dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
				}
			}
		}
		int result = 0;
		for (int i = 1; i <= arr.length; i++) {
			for (int j = 1; j <= arr.length; j++) {
				result = (dp[i][j] > result) ? dp[i][j] : result;
			}
		}
		return result;
	}

}
