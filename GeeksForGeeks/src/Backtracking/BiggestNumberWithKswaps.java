package Backtracking;

import java.util.Arrays;
import java.util.Scanner;

public class BiggestNumberWithKswaps {
	public static long start=0;
	public static long end=0;
	public static void init(){
		start=System.currentTimeMillis();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		
		
		String str = scn.next();
		int k =10;
		long[] a = { 0 };
		char[] checker = str.toCharArray();
		Arrays.sort(checker);
		int lo = 0, hi = checker.length - 1;
		while (lo <= hi) {
			char temp = checker[lo];
			checker[lo] = checker[hi];
			checker[hi] = temp;
			lo++;
			hi--;
		}
		// System.out.println(Integer.MAX_VALUE);
		// System.out.println(Integer.MIN_VALUE);
		a[0] = Long.MIN_VALUE;
		init();
		kswaps(str.toCharArray(), k, str.toCharArray(), a, String.valueOf(checker));
		System.out.println(a[0]);
		System.out.println("duration took is");
		System.out.println(duration());

	}
	public static long duration(){
		end=System.currentTimeMillis();
		return end-start;
	}

	public static void kswaps(char[] arr, int k, char[] max, long[] a, String m) {
		if (String.valueOf(max).compareTo(String.valueOf(m)) == 0) {
			a[0] = Long.parseLong(String.valueOf(max));
			System.out.println(a[0]);
			System.out.println("duration took is");
			System.out.println(duration());
			System.exit(0);
			return;
		}
		if (k == 0) {
			if (a[0] < Long.parseLong(String.valueOf(max)))
				a[0] = Long.parseLong(String.valueOf(max));
			return;
		}
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] < arr[j]) {
					swap(arr, i, j);
					String s1 = String.valueOf(arr);
					String s2 = String.valueOf(max);
					if (s1.compareTo(s2) > 0) {
						max = arr;
					}
					kswaps(arr, k - 1, max, a, m);

					swap(arr, i, j);
					// return;
				}

			}
		}
	}

	public static void swap(char[] arr, int i, int j) {
		char temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

}
