package Strings;

import java.util.Scanner;

public class SeparateTheNumber {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		int q = scn.nextInt();
		for (int m = 0; m < q; m++) {
			String str = scn.next();
			if (str.length() == 1) {
				System.out.println("NO");
			} else {
				int token = 1;
				boolean bool = false;
				while (token <= str.length() / 2) {
					String newstr = "";
					String sub = str.substring(0, token);
					long atom = Long.parseLong(sub);
					String init = "";
					init += atom;
					while (newstr.length() != str.length()) {
						newstr += atom;
						atom += 1;
						if (newstr.length() > str.length()) {
							System.out.println("NO");
							bool = true;
							break;
						}
						if (newstr.equals(str.substring(0, newstr.length()))) {
							continue;
						} else {
							break;
						}
					}
					if (str.equals(newstr)) {
						bool = true;
						System.out.println("YES " + init);
						break;
					} else {
						token++;
						continue;
					}
				}
				if (bool == false) {
					System.out.println("NO");
				}
			}
		}
	}

}
