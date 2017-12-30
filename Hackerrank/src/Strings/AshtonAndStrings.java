package Strings;

import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;

public class AshtonAndStrings {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		while (n > 0) {
			String str = scn.next();
			int k = scn.nextInt();
			SortedSet<String> s = new TreeSet<String>();
			s.add(str.substring(0, 0));
			for (int j = 0; j < str.length(); j++) {
				for (int i = j + 1; i <= str.length(); i++) {
					s.add((str.substring(j, i)));
				}
			}
			StringBuilder sb = new StringBuilder();
			for (String str1 : s) {
				sb.append(str1);
			}
			System.out.println(sb);
			System.out.println(sb.charAt(k - 1));
			n--;
		}
	}
}