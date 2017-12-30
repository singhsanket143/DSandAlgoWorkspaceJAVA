package Strings;

import java.util.Scanner;

public class twoCharacters {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		String str = scn.next();
		if (alternate(str)) {
			System.out.println(str.length());
			System.exit(0);
		}
		int[] arr = new int[26];
		for (int i = 0; i < str.length(); i++) {
			arr[str.charAt(i) - 'a']++;
		}
		for (int i = 0; i < str.length() - 1; i++) {
			if (str.charAt(i) == str.charAt(i + 1)) {
				arr[str.charAt(i) - 'a'] = -1;
			}
		}

		int c = 0;
		for (int i = 0; i < str.length(); i++) {
			if (arr[str.charAt(i) - 'a'] != -1 && arr[str.charAt(i) - 'a'] > c) {
				c = arr[str.charAt(i) - 'a'];
			}
		}
		while (c != 2) {
			String a = "";
			for (int i = 0; i < str.length(); i++) {
				if (arr[str.charAt(i) - 'a'] != -1
						&& (arr[str.charAt(i) - 'a'] == c || arr[str.charAt(i) - 'a'] == c - 1)) {
					a += str.charAt(i);
				}
			}
			if (alternate(a)) {
				System.out.println(a.length());
				System.exit(0);
			}
			c--;
		}
		System.out.println("0");

	}

	public static boolean alternate(String str) {

		for (int i = 0; i < str.length() - 1; i++) {
			if (str.charAt(i) == str.charAt(i + 1)) {
				return false;
			}
		}
		return true;
	}

}
