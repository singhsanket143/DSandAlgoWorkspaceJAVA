package Arrays;

import java.util.Scanner;

public class longestBitonicSubArray {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
		}
		System.out.println(bitonic(arr));
	}

	public static int bitonic(int[] arr) {
		int[] inc = new int[arr.length];
		int[] dec = new int[arr.length];
		inc[0] = 1;
		for (int i = 0; i < arr.length; i++) {
			inc[i] = 1;
			dec[i] = 1;
		}
		for (int i = 1; i < inc.length; i++) {
			for (int j = i - 1; j >= 0; j--) {
				if (arr[j] >= arr[i]) {
					continue;
				} else {
					int possibleAns = inc[j] + 1;
					if (possibleAns > inc[i]) {
						inc[i] = possibleAns;
					}
				}
			}

		}
		dec[dec.length - 1] = 1;
		for (int i = dec.length - 2; i >= 0; i--) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] >= arr[i]) {
					continue;
				} else {
					int possibleAns = dec[j] + 1;
					if (possibleAns > dec[i]) {
						dec[i] = possibleAns;
					}
				}
			}

		}
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length; i++) {
			if (inc[i] + dec[i] - 1 > max) {
				max = inc[i] + dec[i] - 1;
			}
		}
		return max;
	}

}
