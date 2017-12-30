package WeekOfCode31;

import java.util.Scanner;

public class CollidongCircles {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int k = scn.nextInt();
		int[] arr = new int[n];
		int sum = 0;
		int max = 0;
		double sq = 0.0;
		;
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
			sum += arr[i];
			if (arr[i] > max) {
				max = arr[i];
			}
		}
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == max)
				continue;
			else {
				sq += Math.pow(arr[i], 2);
			}
		}
		if (k == n - 1) {
			System.out.println(Math.PI * sum * sum);
		} else {
			double avg = Math.pow(max, 2) / n;
			sq += avg;
			System.out.println((Math.PI * sq * sq) / n);
		}
	}

}
