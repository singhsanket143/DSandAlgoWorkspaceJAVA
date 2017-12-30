package Strings;

import java.util.Scanner;

public class Pangram {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		String str =scn.nextLine();
		boolean[] arr = new boolean[26];
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) >= 97 && str.charAt(i) <= 122) {
				if (str.charAt(i) != ' ' && arr[str.charAt(i) - 'a'] == false) {
					arr[str.charAt(i) - 'a'] = true;
				}
			} else {
				if (str.charAt(i) != ' ' && arr[str.charAt(i) - 'A'] == false) {
					arr[str.charAt(i) - 'A'] = true;
				}
			}
		}
		boolean check = true;
		for (int i = 0; i < 26; i++) {
			if (arr[i] == false) {
				check = false;
				break;
			}
		}
		if (check) {
			System.out.println("pangram");
		} else {
			System.out.println("not pangram");
		}
	}

}
