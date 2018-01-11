package Array;

import java.util.Scanner;

public class MissingNumberFromoneToN {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		int sum = 0;
		for (int i = 0; i < n; i++) {
			arr[i] = scn.nextInt();
			sum += arr[i];
		}
		System.out.println(missingNumber2(arr));
	}

	public static int missingnumber3(int[] arr, int sum) {
		int n = arr[arr.length - 1];
		int arbitrarySum = (n * (n + 1)) / 2;
		return sum - arbitrarySum;
	}

	public static int missingNumber1(int[] arr) {
		int n = arr[arr.length - 1];
		int sum = (n * (n + 1)) / 2;
		for (int i = 0; i < arr.length; i++) {
			sum -= arr[i];
		}
		return sum;
	}

	public static int missingNumber2(int[] arr) {
		int n = arr[arr.length - 1];
		int result = 0;
		for (int i = 0; i <= n; i++) {
			result = result ^ i;
		}
		for (int i = 0; i < arr.length; i++) {
			result ^= arr[i];
		}
		return result;
	}

}
