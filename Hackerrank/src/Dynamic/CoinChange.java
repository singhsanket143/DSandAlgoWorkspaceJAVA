package Dynamic;

import java.util.Scanner;

public class CoinChange {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int k = scn.nextInt();
		int n = scn.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = scn.nextInt();
		}
		long[][] strg = new long[arr.length+1][k+1];
		System.out.println(coinChangedp(arr, k, 0,strg));
	}

	public static int coinChange(int[] coins, int amount, int si) {
		if (amount == 0) {
			return 1;
		}
		if (si >= coins.length) {
			return 0;
		}
		int amountwithcoin = 0;
		int ways = 0;
		while (amountwithcoin <= amount) {
			ways += coinChange(coins, amount - amountwithcoin, si + 1);
			amountwithcoin+=coins[si];
		}

		return ways;
	}
	
	public static long coinChangedp(int[] coins, int amount, int si,long[][] strg) {
		if (amount == 0) {
			return 1;
		}
		if (si >= coins.length) {
			return 0;
		}
		if(strg[si][amount]!=0){
			return strg[si][amount];
		}
		int amountwithcoin = 0;
		long ways = 0;
		while (amountwithcoin <= amount) {
			ways += coinChangedp(coins, amount - amountwithcoin, si + 1,strg);
			amountwithcoin+=coins[si];
		}
		strg[si][amount]=ways;
		return ways;
	}

}
