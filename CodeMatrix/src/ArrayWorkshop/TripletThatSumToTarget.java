package ArrayWorkshop;

import java.util.Arrays;
import java.util.Scanner;

public class TripletThatSumToTarget {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = scn.nextInt();
		}
		int tar = scn.nextInt();
		triplettoTarget(arr, tar);
	}

	public static void triplettoTarget(int[] arr, int tar) {
		Arrays.sort(arr);
		int k = arr.length - 1;
		for (int i = 0; i < arr.length - 2; i++) {
			int j = i + 1;
			while (j < k) {
				if (arr[i] + arr[j] + arr[k] == tar) {
					System.out.println(arr[i] + ", " + arr[j] + " and " + arr[k]);
					j++;
				} else if (arr[i] + arr[j] + arr[k] <= tar)
					j++;
				else
					k--;
			}
		}
	}
}
