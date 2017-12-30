package Strings;

import java.io.*;
import java.util.*;

public class StringSimilarity {

	public static void main(String[] args) {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT.
		 * Your class should be named Solution.
		 */
		Scanner scn = new Scanner(System.in);
		int t = scn.nextInt();
		for (int m = 0; m < t; m++) {
			String s1 = scn.next();
			int sum = 0;
			for (int i = 0; i < s1.length(); i++) {
				sum += lcsIterative(s1, s1.substring(i));
				
			}
			
			System.out.println(sum);
		}
	}

	public static int lcprefixbtr(String s1, String s2, int[][] storage) {
		int rv = 0;
		if (s1.length() == 0 || s2.length() == 0)
			return 0;
		if (s1.length() != 0 && s2.length() != 0 && s1.charAt(0) != s2.charAt(0)) {
			return 0;
		}
		if (storage[s1.length()][s2.length()] != 0)
			return storage[s1.length()][s2.length()];
		if (s1.length() != 0 && s2.length() != 0 && s1.charAt(0) == s2.charAt(0)) {
			rv = 1 + lcprefixbtr(s1.substring(1), s2.substring(1), storage);
			// } else {
			// int f1 = lcprefixbtr(s1, s2.substring(1), storage);
			//
			// int f2 = lcprefixbtr(s1.substring(1), s2, storage);
			// rv = Math.max(f1, f2);
			// }
		}
		storage[s1.length()][s2.length()] = rv;
		return rv;
	}

	public static int lcsBtr(String s1, String s2, int[][] storage) {
		if (s1.length() == 0 || s2.length() == 0) {
			return 0;
		}

		if (storage[s1.length()][s2.length()] != 0) {
			return storage[s1.length()][s2.length()];
		}

		int rv = 0;

		if (s1.charAt(0) == s2.charAt(0)) {
			rv = 1 + lcsBtr(s1.substring(1), s2.substring(1), storage);
		} else {
			int f1 = lcsBtr(s1, s2.substring(1), storage);
			int f2 = lcsBtr(s1.substring(1), s2, storage);

			rv = Math.max(f1, f2);
		}

		storage[s1.length()][s2.length()] = rv;
		return rv;
	}

	public static int lcsIterative(String s1, String s2) {
		int[][] arr = new int[s1.length() + 1][s2.length() + 1];

		for (int i = s1.length(); i >= 0; i--) {
			for (int j = s2.length(); j >= 0; j--) {
				if (i == s1.length() || j == s2.length()) {
					arr[i][j] = 0;
					continue;
				}
				if (s1.charAt(i) != s2.charAt(j)){
					arr[i][j]=0;
					continue;
				}
				if (s1.charAt(i) == s2.charAt(j)) {
					arr[i][j] = arr[i + 1][j + 1] + 1;
				}
			}
		}

		return arr[0][0];
	}
}