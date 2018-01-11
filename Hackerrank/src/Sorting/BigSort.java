package Sorting;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

public class BigSort {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		String[] arr = new String[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.next();
		}
		Arrays.sort(arr);
		quickSort(arr, 0, arr.length - 1);
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}

	}

	public static int compare(String a, String b) {
		// return 0 if 2 strings numeric values are equal
		// return 1 if a is larger
		// retrun -1 if b is larger

		int aLen = a.length();
		int bLen = b.length();
		if (aLen > bLen)
			return 1;
		if (aLen < bLen)
			return -1;

		int result = a.compareTo(b);
		if (result == 0)
			return 0;
		if (result > 0) // a is bigger
			return 1;

		return -1; // b is bigger
	}

	public static void quickSort(String[] arr, int low, int high) {
		if (arr == null || arr.length == 0)
			return;

		if (low >= high)
			return;

		int middle = low + (high - low) / 2;
		String pivot = arr[middle];

		int i = low;
		int j = high;

		while (i <= j) {
			while (compare(arr[i], pivot) < 0)
				i++;

			while (compare(arr[j], pivot) > 0)
				j--;

			if (i <= j) {
				String temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				i++;
				j--;
			}
		}
		if (low < j)
			quickSort(arr, low, j);
		if (high > i)
			quickSort(arr, i, high);
	}
}
