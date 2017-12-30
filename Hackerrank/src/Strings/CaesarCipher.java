package Strings;

import java.util.Scanner;

public class CaesarCipher {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		String str = scn.next();
		String s = "";
		int f = scn.nextInt();
		int k=f%26;
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if (ch >= 'a' && ch <= 'z') {
				if (ch + k > 'z') {
					int m = ch + k - 'z';
					s += (char) (m - 1 + 'a');
				} else {
					s += (char) (ch + k);
				}
			} else if(ch >= 'A' && ch <= 'Z'){
				if (ch + k > 'Z') {
					int m = ch + k - 'Z';
					s += (char) (m - 1 + 'A');
				} else {
					s += (char) (ch + k);
				}
			} else{
				s+=ch;
			}
		}
		System.out.println(s);

	}

}
