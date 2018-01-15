package problem1;

import java.util.HashMap;
import java.util.Scanner;

public class check {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);

		int n = scn.nextInt();

		int a[] = new int[n];

		for (int i = 0; i < n; i++)

			a[i] = scn.nextInt();

		int q = scn.nextInt();

		for (int t = 0; t < q; t++) {

			int x = scn.nextInt();

			int y = scn.nextInt();

			int counter = 0;

			for (int i = 0; i < n; i++) 

				if ((i & x) == i && a[i] > 0)

					a[i] -= y;

			

			for (int i = 0; i < n; i++) {

				if (a[i] > 0)

					counter++;
			}
			System.out.println(counter);

		}

	}



}

