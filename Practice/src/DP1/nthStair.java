package DP1;

import java.util.Scanner;

public class nthStair {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		System.out.println(stair(n));
	}

	public static long stair(int n) {
		long[] dp = new long[n + 1];
		dp[0] = 1;
		dp[1] = 1;
		for (int i = 2; i < n + 1; i++) {
			dp[i] = 0;
			for (int j = 1; j <= 3 && j <= i; j++) {
				dp[i]+=dp[i-j];
			}
		}
		return dp[n];
	}

}
