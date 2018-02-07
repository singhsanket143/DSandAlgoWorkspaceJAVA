package DP1;

import java.util.Scanner;

public class vanyaAndGcd {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scn = new Scanner(System.in);
		int mod = 1000_000_007;
		long[][] dp = new long[501][102];
		int n = scn.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
			dp[i][arr[i]] = 1;
		}

		for (int i = 1; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[j] >= arr[i]) {
					continue;
				}
				for (int k = 1; k <= 100; k++) {
					if (dp[j][k] >= 1) {
						int g = gcd(arr[i], k);
						dp[i][g] = (dp[i][g] + dp[j][k]) % mod;
					}
				}
			}
		}
		long count = 0;
		for (int i = 0; i < n; i++) {
			count = (count + dp[i][1]) % mod;
		}
		System.out.println(count);

	}

	public static int gcd(int a, int b) {
		return (a > 0) ? gcd(b % a, a) : b;
	}

}
