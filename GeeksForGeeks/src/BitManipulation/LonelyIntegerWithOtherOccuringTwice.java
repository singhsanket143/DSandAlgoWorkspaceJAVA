package BitManipulation;

import java.util.Scanner;

public class LonelyIntegerWithOtherOccuringTwice {

	public static void main(String[] args) {
		/* This code works for other integers accuring in multiple of 2 */
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = scn.nextInt();
		}
		System.out.println(checkAloneInteger(arr));

	}

	public static int checkAloneInteger(int[] arr) {
		int result = 0;
		for (int i = 0; i < arr.length; i++) {
			result = result ^ arr[i];
		}
		return result;
	}

}
