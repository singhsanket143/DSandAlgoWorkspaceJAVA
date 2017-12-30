package Strings;

import java.util.Scanner;

public class Funny_String {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		for (int k = 0; k < n; k++) {
			String str = scn.next();
			String rev = "";
			for (int i = str.length() - 1; i >= 0; i--) {
				rev += str.charAt(i);
			}
			int c = 0;
			for (int i = 0; i < str.length() - 1; i++) {
				if (Math.abs(str.charAt(i) - str.charAt(i + 1)) == Math.abs(rev.charAt(i) - rev.charAt(i + 1))) {
					c=0;
					continue;
				} else {
					c=1;
					break;
				}
			}
			if(c==0){
				System.out.println("Funny");
			} else {
				System.out.println("Not Funny");
			}
		}
	}

}
