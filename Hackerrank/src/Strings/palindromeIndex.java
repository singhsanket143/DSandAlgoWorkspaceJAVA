package Strings;

import java.util.Scanner;

public class palindromeIndex {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		int t = scn.nextInt();
		for (int j = 0; j < t; j++) {
			String str = scn.next();
			if (isPalindrome(str)) {
				System.out.println("-1");
			} else {
				int lo = 0;
				int hi = str.length() - 1;
				while (lo <= hi) {
					if (str.charAt(lo) == str.charAt(hi)) {
						lo++;
						hi--;
						continue;
					} else {
						if (str.charAt(lo + 1) == str.charAt(hi) && str.charAt(lo+2)==str.charAt(hi-1)) {
							System.out.println(lo);
							break;
						} else if (str.charAt(lo) == str.charAt(hi - 1) && str.charAt(lo+1)==str.charAt(hi-2)) {
							System.out.println(hi);
							break;
						} else {
							lo++;
							hi--;
						}
					}
				}
			}
		}
	}

	public static boolean isPalindrome(String str) {
		int length = str.length(), mid = length / 2;
		boolean val = true;
		for (int j = 0; j < mid; j++) {

			if (str.charAt(j) != str.charAt(str.length() - 1 - j)) {
				val = false;
				return val;

			}

		}
		return val;
	}

}
