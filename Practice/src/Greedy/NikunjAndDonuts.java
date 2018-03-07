package Greedy;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class NikunjAndDonuts {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = scn.nextInt();
		}

		System.out.println(donuts(arr));

	}

	public static long donuts(int[] arr) {
		Arrays.sort(arr);
		int left = 0, right = arr.length - 1;
		while (left <= right) {
			int temp = arr[left];
			arr[left] = arr[right];
			arr[right] = temp;
			left++;
			right--;

		}

		long ans = 0;
		for (int i = 0; i < arr.length; i++) {
			ans += (long) ((long) Math.pow(2, i)) * arr[i];
		}
		return ans;

	}

}
