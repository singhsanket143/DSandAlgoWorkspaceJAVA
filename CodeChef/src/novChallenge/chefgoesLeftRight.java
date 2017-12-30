package novChallenge;

import java.util.Scanner;

public class chefgoesLeftRight {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		int t = scn.nextInt();
		while (t-- > 0) {
			int n = scn.nextInt();
			int l = scn.nextInt();
			int[] arr = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = scn.nextInt();
			}
			if (right_left(arr, l))
				System.out.println("YES");
			else 
				System.out.println("NO");
		}
	}

	public static boolean right_left(int[] arr, int l) {
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < arr.length; i++) {
			max = (arr[i] > max) ? (arr[i]) : (max);
			min = (arr[i] < min) ? (arr[i]) : (min);
		}
		boolean bool = false;
		int lo = 0, hi = max;
		int temp = max;
		for (int i = 1; i < arr.length; i++) {
			if(arr[i]<lo || arr[i]>hi)
				return false;
			if(arr[i-1]>arr[i]){
				hi=arr[i-1];
			} else if(arr[i-1]<arr[i]){
				lo=arr[i-1];
			}
		}
		return true;
	}

}
