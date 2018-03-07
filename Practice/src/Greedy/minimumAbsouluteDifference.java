package Greedy;

import java.util.Arrays;
import java.util.Scanner;

public class minimumAbsouluteDifference {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int n=scn.nextInt();
		int[] arr = new int[n];
		for(int i=0;i<n;i++) {
			arr[i]=scn.nextInt();
		}

		System.out.println(minDiff(arr));
	}
	
	public static int minDiff(int[] arr) {
		Arrays.sort(arr);
		int result = Integer.MAX_VALUE;
		for(int i=1;i<arr.length;i++) {
			int val = Math.abs(arr[i]-arr[i-1]);
			result = (result<val)?result:val;
		}
		return result;
	}

}
