package DP;

public class possibleDecodings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(possibleDecoding("123"));
	}

	public static int possibleDecoding(String str) {
		int[] dp = new int[str.length() + 1];
		dp[0] = 1;
		dp[1] = 1;
		for (int i = 2; i <= str.length(); i++) {
			if (str.charAt(i - 1) > '0') {
				dp[i] = dp[i - 1];
			}
			if ((str.charAt(i - 2) == '1' || str.charAt(i - 2) == '2') && str.charAt(i - 1) < '7') {
				dp[i] += dp[i - 2];
			}
		}
		return dp[str.length()];
	}

}
