package Searching;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class MinimumLoss {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		long[] arr = new long[n];
		HashMap<Long, Integer> map = new HashMap<>();
		int temp = 0;
		for (int i = 0; i < n; i++) {
			arr[i] = scn.nextLong();
			map.put(arr[i], ++temp);
		}
		long min = Integer.MAX_VALUE;
		Arrays.sort(arr);
		for(int i=0;i<arr.length-1;i++){
			if(min>Math.abs(arr[i]-arr[i+1])){
				if(map.get(arr[i])>map.get(arr[i+1])){
					min=Math.abs(arr[i]-arr[i+1]);
				}
			}
		}
		System.out.println(min);
	}

}
