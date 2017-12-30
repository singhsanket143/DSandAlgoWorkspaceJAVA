package Searching;

import java.util.Arrays;
import java.util.Scanner;

public class Pairs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int k=scn.nextInt();
		long[] arr = new long[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
		}
		Arrays.sort(arr);
		int c=0;
		for(int i=0;i<arr.length;i++){
			if(binarysearch(arr, arr[i]+k))
				c++;
		}
		System.out.println(c);

	}
	
	public static boolean binarysearch(long[] arr, long data) {
		int left = 0, right = arr.length - 1;
		while (left <= right) {
			int mid = (left + right) / 2;
			if (data > arr[mid]) {
				left = mid + 1;
			} else if (data < arr[mid]) {
				right = mid - 1;
			} else
				return true;
		}
		return false;

	}

}
