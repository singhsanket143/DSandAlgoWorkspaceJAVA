package Dynamic;

import java.util.Scanner;

public class maxsubarray {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		int t = scn.nextInt();
		while (t > 0) {
			int n = scn.nextInt();
			int[] arr = new int[n];
			int min=Integer.MIN_VALUE;
			for (int i = 0; i < n; i++) {
				arr[i] = scn.nextInt();
				if(arr[i]>min){
					min=arr[i];
				}
			}
			System.out.println(maxSubarrayContiguous(arr,min) + " " + maxSubarraynonContiguous(arr,min));
			t--;
		}
	}

	public static int maxSubarrayContiguous(int[] arr,int min) {
		int max = 0, ending = 0;
		for (int i = 0; i < arr.length; i++) {
			ending += arr[i];
			if (ending < 0) {
				ending = 0;
			} else if (max < ending) {
				max = ending;
			}
		}
		if(max!=0)
			return max;
		else
			return min;
	}

	public static int maxSubarraynonContiguous(int[] arr,int min) {
		int max = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > 0) {
				max += arr[i];
			}
		}
		if(max!=0)
			return max;
		else
			return min;
	}

}
