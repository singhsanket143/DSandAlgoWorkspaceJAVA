package DynamicProgramming;

import java.util.Scanner;

public class MinCoinChange {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int k = scn.nextInt();
		int n = scn.nextInt();
		int[] arr = new int[n];
		for(int i=0;i<n;i++){
			arr[i]=scn.nextInt();
		}
		int[] strg=new int[k+1];
		System.out.println(coinChangetopdowndp(arr, k, n,strg));
	}

	public static int coinChange(int[] coins, int amount, int types) {
		if (amount == 0)
			return 0;
		int ans = Integer.MAX_VALUE;
		for (int i = 0; i < types; i++) {
			if (amount - coins[i] >= 0) {
				int result = coinChange(coins, amount - coins[i], types);
				if (result != Integer.MAX_VALUE)
					ans = Math.min(ans, result + 1);
			}

		}
		if (ans != Integer.MAX_VALUE)
			return ans;
		else
			return 0;
	}

	public static int coinChangetopdowndp(int[] coins, int amount, int types, int[] strg) {
		if (amount == 0)
			return 0;
		if (strg[amount] != 0) {
			return strg[amount];
		}
		int ans = Integer.MAX_VALUE;
		for (int i = 0; i < types; i++) {
			if (amount - coins[i] >= 0) {
				int result = coinChangetopdowndp(coins, amount - coins[i], types, strg);
				if (result != Integer.MAX_VALUE)
					ans = Math.min(ans, result + 1);
			}

		}
		if (ans != Integer.MAX_VALUE) {
			strg[amount]=ans;
			return ans;
		} else {
			strg[amount]=0;
			return 0;
		}
	}

}
