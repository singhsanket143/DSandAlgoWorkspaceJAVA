package Dynamic;

import java.util.Arrays;
import java.util.Scanner;

public class lcs {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		 int n=scn.nextInt();
		 int m=scn.nextInt();
		String s1 = "";
		String s2 = "";
		 for (int i = 0; i < n; i++) {
		 int a=scn.nextInt();
		 s1+=a;
		 }
		 for (int i = 0; i < m; i++) {
		 int a=scn.nextInt();
		 s2+=a;
		 }
		int[][] storage = new int[s1.length() + 1][s2.length() + 1];
		int len = (lcsBtr(s1, s2, storage));
		char[] arr = new char[len + 1];
		arr[len] = '\0';
		int i = s1.length(), j = s2.length();
		while (i > 0 && j > 0) {
			if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
				arr[len - 1] = s1.charAt(i - 1);
				i--;
				j--;
				len--;
			} else if (storage[i - 1][j] > storage[i][j - 1]) {
				i--;
			} else {
				j--;
			}

		}
		for (int k = 0; k < arr.length; k++) {
			System.out.print(arr[k]+" ");
		}
	}

	public static int lcsBtr(String s1, String s2, int[][] storage) {

		for (int i = 0; i <= s1.length(); i++) {
			for (int j = 0; j <= s2.length(); j++) {
				if (i == 0 || j == 0) {
					storage[i][j] = 0;
					continue;
				}

				if (s1.charAt(i-1) == s2.charAt(j-1)) {
					storage[i][j] = storage[i - 1][j - 1] + 1;
				} else {
					storage[i][j] = Math.max(storage[i - 1][j], storage[i][j - 1]);
				}
			}
		}

		return storage[s1.length()][s2.length()];
	}

}
