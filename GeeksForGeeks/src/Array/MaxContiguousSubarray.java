package Array;

import java.util.Scanner;

public class MaxContiguousSubarray {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		int t=scn.nextInt();
		while(t-->0) {
			int n = scn.nextInt();
			int[] arr = new int[n];
			for(int i=0;i<n;i++) {
				arr[i]=scn.nextInt();
			}
			
//			for (int i = 0; i < n; i++) {
//				arr[i] = scn.nextInt();
//			}
			System.out.println(maxSubarray(arr));
//			printmaxSubarray(arr);
		}
		
	}

	public static int maxSubarray(int[] arr) {
		int max = 0, ending = 0;
		for (int i = 0; i < arr.length; i++) {
			ending += arr[i];
			if (ending < 0) {
				ending = 0;
			} else if (max < ending) {
				max = ending;
			}
		}
		return max;
	}

	public static void printmaxSubarray(int[] arr) {
		int max = 0, ending = 0, si = 0, li = 0;
		for (int i = 0; i < arr.length; i++) {
			ending += arr[i];
			if (ending < 0) {
				ending = 0;
				si = i + 1;
			} else if (max < ending) {
				max = ending;
				li = i;
			}
		}
		for (int i = si; i <= li; i++) {
			System.out.print(arr[i] + " ");
		}
	}

}
