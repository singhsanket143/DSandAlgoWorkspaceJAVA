package Strings;

import java.util.Scanner;

public class Gemstones {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[26];
		for (int i = 0; i < n; i++) {
			String str = scn.next();
			boolean[] a = new boolean[26];
			for (int j = 0; j < str.length(); j++) {
				if (a[str.charAt(j) - 'a'] == false) {
					arr[str.charAt(j) - 'a']++;
					a[str.charAt(j) - 'a']=true;
				}
			}
		}
		int c = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] >= n) {
				c++;
			}
		}
		System.out.println(c);
	}

}
