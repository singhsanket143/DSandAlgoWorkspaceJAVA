package Warmup;

import java.util.Scanner;

public class SixPercision {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			int data = scn.nextInt();
			arr[i] = data;
		}
		int p = 0, ne = 0, z = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 0) {
				z++;
			} else if (arr[i] < 0) {
				ne++;
			} else {
				p++;
			}
		}

		for (int i = 0; i < 3; i++) {
			double num = 0;
			if (i == 0) {
				num = (double) p / n;
			} else if (i == 1) {
				num = (double) ne / n;
			} else {
				num = (double) z / n;
			}
			System.out.println(squareRoot(num * num, 6));
		}

	}

	public static double squareRoot(double N, int P) {
		int iPower = 1;
		double dPower = 1.0;

		double sqrt = 0;
		double increment = 1;

		int counter = 0;
		while (counter <= P) {

			while (sqrt * sqrt <= N) {
				sqrt += increment;
			}

			sqrt = sqrt - increment;

			increment = increment * 0.1;
			iPower = iPower * 10;
			dPower = dPower * 10.0;
			counter++;
		}
		return sqrt;
	}
}
