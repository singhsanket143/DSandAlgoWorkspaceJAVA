package SubString;

import java.util.Scanner;

public class printallsubstrings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		String str = scn.nextLine();
		printsubstrings(str);
	}

	public static void printsubstrings(String str) {
		System.out.println(str.substring(0, 0));
		for (int j = 0; j < str.length(); j++) {
			for (int i = j + 1; i <= str.length(); i++) {

				System.out.println(str.substring(j, i));

			}
		}
	}

	public static boolean ifstringpalindrome(String str) {
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

	public static int noofpalindromesubstring(String str) {
		int count = 0;

		for (int j = 0; j < str.length(); j++) {
			for (int i = j + 1; i <= str.length(); i++) {

				String a = str.substring(j, i);
				boolean c = ifstringpalindrome(a);
				if (c) {
					count = count + 1;
				}
			}
		}
		return count;
	}

}
