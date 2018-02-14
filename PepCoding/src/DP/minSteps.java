package DP;

public class minSteps {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] dp = new int[1000];
		System.out.println(minSteps(6, dp));
	}

	public static int minSteps(int n, int[] dp) {
		if (n == 1 || n == 0)
			return 0;
		if (dp[n] != 0)
			return dp[n];
		int r1 = minSteps(n - 1, dp);
		if (n % 3 == 0)
			r1 = Math.min(r1, minSteps(n / 3, dp));
		if (n % 2 == 0)
			r1 = Math.min(r1, minSteps(n / 2, dp));
		dp[n] = 1 + r1;
		return dp[n];
	}

}
