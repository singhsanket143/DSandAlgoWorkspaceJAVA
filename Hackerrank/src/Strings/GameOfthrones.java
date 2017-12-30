package Strings;

import java.util.Scanner;

public class GameOfthrones {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		int[] arr = new int[26];
		for (int i = 0; i < str.length(); i++) {
			arr[str.charAt(i) - 'a']++;
		}
		int c = 0;
		for (int i = 0; i < 26; i++) {
			if (arr[i] % 2 != 0)
				c++;
		}

		boolean bool = true;
		if (str.length() % 2 == 0) {
			for (int i = 0; i < 26; i++) {
				if (arr[i] % 2 != 0) {
					bool = false;
					System.out.println("NO");
					break;
				} else {
					bool = true;
					continue;
				}
			}
			if (bool == true) {
				System.out.println("YES");
			}
		} else {
			if (c > 1) {
				System.out.println("No");

			} else {
				for (int i = 0; i < 26; i++) {
					if (arr[i] % 2 != 0 && c > 1) {
						bool = false;
						if (c != 1) {
							System.out.println("NO");
							break;
						} else {
							c++;
						}

					} else {
						bool = true;

						continue;
					}
				}
				if (bool == true) {
					System.out.println("YES");
				}
			}
		}
	}

}
