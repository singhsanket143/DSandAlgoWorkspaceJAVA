package DP;

public class catalanNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(catalan(7));

	}

	public static int catalan(int n) {
		int[] dp = new int[n + 1];
		dp[0] = 1;
		dp[1] = 1;
		for (int i = 2; i <= n; i++) {
			for (int j = 0; j < i; j++) {
				dp[i]+=dp[j]*dp[i-j-1];
			}
		}
		return dp[n];
	}

}
