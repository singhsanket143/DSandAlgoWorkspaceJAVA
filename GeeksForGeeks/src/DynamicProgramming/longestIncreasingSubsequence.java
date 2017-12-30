package DynamicProgramming;

import java.util.Scanner;

public class longestIncreasingSubsequence {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		int[] li = new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
			li[i] = 1;
		}
		int max=li[0];
		for (int i = 1; i < arr.length; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[i] > arr[j] && li[i] < li[j] + 1) {
					li[i] += 1;
				}
			}
			if(li[i]>max)
				max=li[i];
		}
	
		System.out.println(max);
	}

}
