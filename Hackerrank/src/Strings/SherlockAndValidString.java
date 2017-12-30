package Strings;

import java.util.Scanner;

public class SherlockAndValidString {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		int[] arr = new int[26];
		int min = Integer.MIN_VALUE;
		for (int i = 0; i < str.length(); i++) {
			arr[str.charAt(i) - 'a']++;
			if (arr[str.charAt(i) - 'a'] > min) {
				min = arr[str.charAt(i) - 'a'];
			}
		}
		int c = 0, d = 0, e = 0;
		// for(int i=0;i<26;i++){
		// if(arr[i]==min-1){
		// d++;
		// }
		// }
		for (int i = 0; i < 26; i++) {
			if (arr[i] == min)
				d++;
			if (arr[i] == min - 1) {
				c++;
			}
			if (arr[i] < min - 1 && arr[i] != 0) {
				e++;
			}
		}
		if (e > 0 && e!=1 ) {
			System.out.println("NO");
		} else if (c == 0 && e == 0 && d != 0) {
			System.out.println("YES");
		} else {
			if (c >= 2 && d == 1) {
				System.out.println("YES");
			} else if (d > 1 && c == 1 || d>1 && e==1) {
				System.out.println("YES");
			} else if (c > 1 && d > 1)
				System.out.println("NO");
		}
		// else
		// System.out.println("YES");

	}

}
