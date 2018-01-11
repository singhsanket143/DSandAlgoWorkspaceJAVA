package Array;

import java.util.Scanner;

public class LeaderInAnArray {
//An element is leader if it is greater than all the elements to its right side
	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = scn.nextInt();
		}

		Leader(arr);
	}

	public static void Leader(int[] arr) {
		int lead = arr[arr.length - 1];
		System.out.println(lead);
		for (int i = arr.length - 2; i >= 0; i--) {
			if (arr[i] > lead) {
				lead = arr[i];
				System.out.println(lead);
			}
		}
	}

}
