package Lecture5;

import java.util.Scanner;

public class letter_case {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		char ch = scn.next().charAt(0);
		if (ch >= 'a' && ch <= 'z') {
			System.out.println("lowercase");
		} else if (ch >= 'A' && ch <= 'Z') {
			System.out.println("UPPERCASE");
		} else {
			System.out.println("Invalid");
		}
	}

}
