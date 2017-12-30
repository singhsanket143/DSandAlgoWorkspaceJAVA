package Implementation;

import java.util.Scanner;

public class kaprekarNumber {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int p = scan.nextInt();
		int q = scan.nextInt();
		int kaprekarNumber = 0;

		for (long i = p; i <= q; i++) {
			String square = Long.toString(i * i);
			int length = square.length();
			String left = "0" + square.substring(0, length / 2);
			String right = "0" + square.substring(length / 2);

			if (Integer.parseInt(left) + Integer.parseInt(right) == i) {
				System.out.print(i + " ");
				kaprekarNumber++;
			}
		}

		if (kaprekarNumber == 0)
			System.out.println("INVALID RANGE");

	}

}
