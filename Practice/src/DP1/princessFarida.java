package DP1;

import java.util.Scanner;

public class princessFarida {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		int t = scn.nextInt();
		for (int k = 1; k <= t; k++) {
			int n = scn.nextInt();
			int[] arr = new int[n];
			for (int i = 0; i < arr.length; i++) {
				arr[i] = scn.nextInt();
			}
			System.out.println("Case " + k + ": " + LIS(arr));
		}
	}

	public static long LIS(int[] arr) {
		long[] output = new long[arr.length];
		if (arr.length == 1) {
			return arr[0];
		} else {
			output[0] = arr[0];
			output[1] = arr[1];

			long ans = Long.MIN_VALUE;
			for (int i = 2; i < arr.length; i++) {
				long pa = output[i - 2] + arr[i];
				for (int j = i - 2; j >= 0; j--) {
					if (arr[i] + output[j] > pa) {
						pa = arr[i] + output[j];
					}
				}
				output[i] = pa;
			}
			for (int i = 0; i < output.length; i++) {
				if (output[i] > ans) {
					ans = output[i];
				}
			}
			return ans;
		}
	}

}
