package Array;

import java.util.Scanner;

public class NumberOccuringOddNoOfTime {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = scn.nextInt();
		}
		System.out.println(numberoddtimes(arr) + "occurs odd number of times whereas all others occur even times");
	}

	public static int numberoddtimes(int[] arr) {
		int result = arr[0];
		for (int i = 1; i < arr.length; i++) {
			result = result ^ arr[i];
		}
		return result;
	}

}
