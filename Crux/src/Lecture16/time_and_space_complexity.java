package Lecture16;

import java.math.BigInteger;

public class time_and_space_complexity {

	public static void main(String[] args) {

		// int[] arr = { 1, 5, 9, 3, 12, 15 };
		//
		// quicksort(arr, 0, arr.length - 1);
		// display(arr);

		System.out.println(powerinTimeSpace(2, 11));
	}

	public static void quicksort(int arr[], int lo, int hi) {
		if (lo >= hi) {
			return;
		}
		int mid = (lo + hi) / 2;
		int pivot = arr[mid];
		int left = lo;
		int right = hi;
		while (left <= right) {
			while (arr[left] < pivot)
				left++;

			while (arr[right] > pivot) {
				right--;

			}
			if (left <= right) {
				int temp = arr[left];
				arr[left] = arr[right];
				arr[right] = temp;
				left++;
				right--;
			}
			quicksort(arr, lo, right);
			quicksort(arr, left, hi);
		}
	}

	public static void display(int[] arr) {
		for (int val : arr) {
			System.out.print(val + ", ");
		}
		System.out.println("end");
	}

	public static int powerinTimeSpace(int x, int n) {
		if (n == 0) {
			return 1;
		}
		int xpn;
		int xpnm = powerinTimeSpace(x, n / 2);
		if (n % 2 == 0) {
			xpn = xpnm * xpnm;
		} else
			xpn = xpnm * xpnm * x;
		return xpn;
	}
}