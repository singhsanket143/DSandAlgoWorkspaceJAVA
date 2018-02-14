package DP;

public class maxWeightPath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int mat[][] = { { 4, 1, 5, 6, 1 }, { 2, 9, 2, 11, 10 }, { 15, 1, 3, 15, 2 }, { 16, 92, 41, 4, 3 },
				{ 8, 142, 6, 4, 8 } };
		System.out.println(maxWeight(mat));

	}

	public static int maxWeight(int[][] path) {
		int[][] dp = new int[path.length][path[0].length];
		dp[0][0] = path[0][0];
		for (int i = 1; i < dp.length; i++) {
			dp[i][0] += dp[i - 1][0] + path[i][0];
		}
		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp[0].length; j++) {
				dp[i][j] += Math.max(dp[i - 1][j - 1], dp[i-1][j])+path[i][j];
			}
		}
		int result = Integer.MIN_VALUE;
		for (int i = 0; i < dp.length; i++) {
			result = (result < dp[dp.length - 1][i]) ? dp[dp.length - 1][i] : result;
		}
		return result;
	}

}
