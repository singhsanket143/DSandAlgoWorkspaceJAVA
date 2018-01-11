package Array;

import java.util.Scanner;

public class SearchAnElementInASortedAndRotatedArray {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = scn.nextInt();
		}
		int element = scn.nextInt();
		System.out.println(find(arr, element, 0, arr.length - 1));
	}

	public static int find(int[] arr, int element, int lo, int hi) {
		if (lo > hi) {
			return -1;
		}
		int mid = (lo + hi) / 2;
		if (arr[mid] == element) {
			return mid;
		}
		if (arr[lo] <= arr[mid]) {
			if (element >= arr[lo] && element <= arr[mid])
				return find(arr, element, lo, mid);
			else
				return find(arr, element, mid + 1, hi);
		} else {
			if (element > arr[mid] && element <= arr[hi])
				return find(arr, element, mid + 1, hi);
			else
				return find(arr, element, lo, mid);
		}
	}

}
