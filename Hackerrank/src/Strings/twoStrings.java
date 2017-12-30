package Strings;

import java.util.HashMap;
import java.util.Scanner;

public class twoStrings {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		int t = scn.nextInt();
		for (int j = 0; j < t; j++) {
			String s1 = scn.next();
			String s2 = scn.next();
			HashMap<Character, Character> map = new HashMap<>();
			if (s1.length() > s2.length()) {
				for (int i = 0; i < s1.length(); i++) {
					map.put(s1.charAt(i), s1.charAt(i));
				}
				boolean bool = false;
				for (int i = 0; i < s2.length(); i++) {
					if (map.containsKey(s2.charAt(i))) {
						bool = true;
						System.out.println("YES");
						break;
					}
				}
				if (bool == false) {
					System.out.println("NO");
				}
			} else {
				for (int i = 0; i < s2.length(); i++) {
					map.put(s2.charAt(i), s2.charAt(i));
				}
				boolean bool = false;
				for (int i = 0; i < s1.length(); i++) {
					if (map.containsKey(s1.charAt(i))) {
						bool = true;
						System.out.println("YES");
						break;
					}
				}
				if (bool == false) {
					System.out.println("NO");
				}
			}

		}
	}

}
