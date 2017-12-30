package Array;

import java.util.Scanner;

public class MajorityElement {
	// if a number occurs more than n/2 times in an arrray it is the majority
	// element
	// MOORE'S VOTING ALGORITHM
	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = scn.nextInt();
		}
		int candidate = candidate(arr);
		if (isMajority(arr, candidate))
			System.out.println(candidate + "is the majority element");
		else
			System.out.println("no majority element");
	}

	public static int candidate(int[] arr) {
		int count = 1, majority = 0;
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] == arr[majority])
				count++;
			else
				count--;
			if (count == 0) {
				count = 1;
				majority = i;
			}
		}
		return arr[majority];
	}

	public static boolean isMajority(int[] arr, int candidate) {
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == candidate) {
				count++;
			}
		}
		if (count > (arr.length / 2))
			return true;
		else
			return false;
	}

}
