package Lecture4;

import java.util.Scanner;

public class GCD_of_2_numbers {

	public static void main(String[] args) {
//		Scanner scn = new Scanner(System.in);
//		System.out.println("enter the number");
//		int a = scn.nextInt();
//		Scanner scn1 = new Scanner(System.in);
//		System.out.println("enter the number");
//		int b = scn1.nextInt(), g, t;
//		while (b != 0) {
//			if (b <= a) {
//				g = a % b;
//				a = b;
//				b = g;
//				if (b == 0) {
//					System.out.println(a);
//				}
//			} else {
//				t = a;
//				a = b;
//				b = t;
//			}
//		}
		 System.out.println(gcd(4, 6));
	}

	public static int gcd(int a, int b) {
		int g, t, m = 0;
		// while (b != 0) {
		if (b <= a) {
			while (b != 0) {
				g = a % b;
				a = b;
				b = g;
				if (b == 0) {
					m = a;
				}
			}
		} else {
			while (a != 0) {
				g = b % a;
				b = a;
				a = g;
				if (a == 0) {
					m = b;
				}
			}

		}

		return m;
	}
}
