package Strings;

import java.util.Scanner;

public class RichieRich {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		int l = scn.nextInt();
		int k = scn.nextInt();
		String str = scn.next();
		int lo = 0, hi = l - 1;
		int[] arr = new int[l];
		for (int i = 0; i < l; i++) {
			arr[i] = str.charAt(i) - '0';
		}
		if (arr.length != 1) {
			while (lo <= l && hi >= 0 && k != 0) {
				 if (arr[lo] != 9) {
					arr[lo] = 9;
					lo++;
					hi--;
					k--;
				} else {
					lo++;
					hi--;
				}
			}
		} else{
			arr[0]=9;
		}
		if (isPalindrome(arr)) {
			for (int i = 0; i < l; i++) {
				System.out.print(arr[i]);
			}
		} else {
			System.out.println("-1");
		}
	}

	public static boolean isPalindrome(int[] arr) {
		int lo = 0;
		int hi = arr.length - 1;
		boolean bool = true;
		while (lo <= hi) {
			if (arr[lo] == arr[hi]) {
				bool = true;
				hi--;
				lo++;
			} else {
				bool = false;
				break;
			}
		}
		return bool;
	}

}
