package DP;

public class eggDrop {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(eggDropping(2, 36));
	}

	public static int eggDropping(int eggs, int floor) {
		int[][] dp = new int[eggs + 1][floor + 1];
		for (int i = 0; i <= floor; i++) {
			dp[1][i] = i;
		}
		// for (int i = 0; i <= eggs; i++) {
		// dp[i][0] = 1;
		// }
//		for (int i = 1; i <= eggs; i++) {
//			for (int j = 1; j <= floor; j++) {
//				dp[i][j] = Integer.MAX_VALUE;
//			}
//		}
		int c = 0;
		for (int i = 2; i <= eggs; i++) {
			for (int j = 1; j <= floor; j++) {
				if (i > j) {
					dp[i][j] = dp[i - 1][j];
				} else {
					dp[i][j] = Integer.MAX_VALUE;
					for (int k = 1; k <= j; k++) {
						c = 1 + Math.max(dp[i - 1][k - 1], dp[i][j - k]);
						if (c < dp[i][j]) {
							dp[i][j] = c;
						}
					}
				}
			}
		}
		return dp[eggs][floor];
	}

}
