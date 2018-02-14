package DP;

public class binomialCoefficient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long[][] dp = new long[46][13];
		System.out.println(binomialCOefficientTopDown(45, 12, dp));
		System.out.println(binomialCoefficientBottomUp(45, 12));
		System.out.println(binomialCOefficient(45, 12));

	}

	public static long binomialCOefficient(int n, int k) {
		if (k == 0 || k == n) {
			return 1;
		}
		long result1 = binomialCOefficient(n - 1, k - 1);
		long result2 = binomialCOefficient(n - 1, k);
		return result1 + result2;
	}

	public static long binomialCOefficientTopDown(int n, int k, long[][] strg) {
		if (k == 0 || k == n) {
			return 1;
		}
		if (strg[n][k] != 0) {
			return strg[n][k];
		}
		long result1 = binomialCOefficientTopDown(n - 1, k - 1, strg);
		long result2 = binomialCOefficientTopDown(n - 1, k, strg);
		strg[n][k] = result1 + result2;
		return result1 + result2;
	}

	public static long binomialCoefficientBottomUp(int n, int k) {
		long[][] dp = new long[n+1][k+1];
		dp[0][0] = 1;
		for(int i=0;i<=n;i++) {
			for(int j=0;j<=Math.min(i, k);j++) {
				if(j==0 || j==i) {
					dp[i][j]=1;
				} else {
					dp[i][j]=dp[i-1][j-1]+dp[i-1][j];
				}
			}
		}
		return dp[n][k];
	}
}
