package Greedy;

import java.util.Scanner;

public class exploringRuins {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		char[] arr = new char[str.length()];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = str.charAt(i);
		}

		if (arr[0] == '?' && arr.length > 1 && arr[1] != 'a') {
			arr[0] = 'a';
		} else if (arr[0] == '?' && arr.length > 1) {
			arr[0] = 'b';
		}
		if (arr[0] == '?' && arr.length == 1) {
			arr[0] = 'a';
		}
		for (int i = 1; i < arr.length - 1; i++) {
			if (arr[i] != '?') {
				continue;
			}
			arr[i] = (arr[i - 1] != 'a' && arr[i + 1] != 'a') ? 'a' : 'b';
		}
		if (arr.length > 1) {
			if (arr[arr.length - 1] == '?' && arr[arr.length - 2] != 'a') {
				arr[arr.length - 1] = 'a';
			} else if (arr[arr.length - 1] == '?') {
				arr[arr.length - 1] = 'b';
			}
			
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]);
		}
	}

}
