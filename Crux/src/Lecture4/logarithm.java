package Lecture4;

import java.util.Scanner;

public class logarithm {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		int X = scn.nextInt();
		int N = scn.nextInt();

		System.out.println(log(X, N));
	}

	public static int log(int n, int b) {
		int a = 0;
		while (n > 1) {
			n = n / b;
			a++;
		}
		return a;
	}
}
