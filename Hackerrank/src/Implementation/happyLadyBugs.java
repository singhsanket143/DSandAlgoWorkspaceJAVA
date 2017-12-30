package Implementation;

import java.util.Scanner;

public class happyLadyBugs {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		int q = scn.nextInt();
		for (int i = 0; i < q; i++) {
			int n = scn.nextInt();
			String str = scn.next();
			int[] arr = new int[27];
			boolean bool = false;
			for (int j = 0; j < str.length(); j++) {
				char c = str.charAt(j);
				if (c != '_') {
					arr[c - 'A']++;
				} else
					arr[26]++;

			}
			boolean check = true, zero = false;
			for (int j = 0; j < arr.length - 1; j++) {
				if (arr[j] == 1) {
					check = false;
					break;
				}

			}
			if (arr[26] == str.length()) {
				bool = true;
			} else if (check == false) {
				bool = false;
			} else {
				for (int j = 1; j < str.length() - 1; j++) {
					if (str.charAt(j) == str.charAt(j - 1) || str.charAt(j) == str.charAt(j + 1)) {
						bool = true;
					} else if (arr[26] >= 1 && check != false) {
						bool = true;
					} else if (check == false || arr[26] == 0) {
						bool = false;
						break;
					}
				}
			}
			if (bool == true) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}

	}
}
