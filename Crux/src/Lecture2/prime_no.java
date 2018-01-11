package Lecture2;

import java.util.Scanner;

public class prime_no {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int N = scn.nextInt();
		int i = 2;
		while (i*i < N ) {
			if (N % i == 0) {
				System.out.println("N is not a prime no.");
				return;
			} else
				i += 1;
		}
		System.out.println("N is a prime no.");
	}
}
