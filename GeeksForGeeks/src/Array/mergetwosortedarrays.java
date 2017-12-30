package Array;

import java.util.Scanner;

public class mergetwosortedarrays {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr1 = new int[n];
		for (int i = 0; i < n; i++) {
			arr1[i] = scn.nextInt();
		}
		int m = scn.nextInt();
		int[] arr2 = new int[m];
		for (int i = 0; i < m; i++) {
			arr2[i] = scn.nextInt();
		}

		merge(arr1, arr2);
		for (int i = 0; i < arr1.length; i++) {
			System.out.print(arr1[i] + " ");
		}

	}

	public static int movetowardsendbiggerarray(int[] arr1) {
		int j = arr1.length - 1;
		for (int i = arr1.length - 1; i >= 0; i--) {
			if (arr1[i] != -1) {
				arr1[j] = arr1[i];
				if (i != j)
					arr1[i] = -1;
				j--;
			}
		}
		return j;
	}

	public static void merge(int[] arr1, int[] arr2) {
		movetowardsendbiggerarray(arr1);
		int i = arr2.length;
		int j = 0, k = 0;
		while (k < (arr1.length)) {
			if (j == arr2.length) {
				return;
			}
			if ((i < (arr1.length) && arr2[j] >= arr1[i])) {
				arr1[k] = arr1[i];
				k++;
				i++;
			} else {
				arr1[k] = arr2[j];
				k++;
				j++;
			}
		}
	}

}
