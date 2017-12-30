package ArrayWorkshop;

import java.util.Scanner;

public class rainWaterTrapping {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
		}
		System.out.println(rainWatertrap(arr));
	}

	public static int rainWatertrap(int[] arr) {
		int result = 0;

		int[] auxarr1 = new int[arr.length];
		int[] auxarr2 = new int[arr.length];
		// auxarr1[0] = 0;
		// auxarr1[arr.length - 1] = 0;
		int maxL = 0, maxR = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > maxL) {
				maxL = arr[i];
			}
			auxarr1[i] = maxL;
		}
		for (int i = arr.length - 1; i >= 0; i--) {
			if (arr[i] > maxR) {
				maxR = arr[i];
			}
			auxarr2[i] = maxR;
		}
		for (int i = 1; i < arr.length - 1; i++) {
			result += Math.min(auxarr1[i], auxarr2[i]) - arr[i];
		}

		return result;
	}
}
