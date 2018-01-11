package DP1;

import java.util.Scanner;

public class LongestIncreasingSubsequence {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
		}
		System.out.println(LIS(arr));
	}

	public static int LIS(int[] arr) {
		int[] output = new int[arr.length];
		output[0] = 1;
		int ans = Integer.MIN_VALUE;
		for (int i = 1; i < output.length; i++) {
			for (int j = i - 1; j >= 0; j--) {
				if (arr[j] > arr[i]) {
					continue;
				} else {
					int possibleAns = output[j] + 1;
					if (possibleAns > output[i]) {
						output[i] = possibleAns;
					}
				}
			}
		}
		for (int i = 0; i < output.length; i++) {
			if (output[i] > ans) {
				ans = output[i];
			}
		}
		return ans;
	}

}
