package BitManipulation;

import java.util.Scanner;

public class SansaAndXOR {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		int q = scn.nextInt();
		while (q > 0) {
			int n = scn.nextInt();
			int[] arr = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = scn.nextInt();
			}
			if (n % 2 == 0) {
				System.out.println("0");
			} else {
				int rec = 0;
				for (int i = 0; i < n; i += 2) {
					rec = rec ^ arr[i];
				}
				System.out.println(rec);
			}
			q--;
		}
	}

}
