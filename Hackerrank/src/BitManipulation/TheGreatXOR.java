package BitManipulation;

import java.util.Scanner;

public class TheGreatXOR {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		int q = scn.nextInt();
		for (int i = 0; i < q; i++) {
			long l = scn.nextLong();
			long r = scn.nextLong();
			System.out.println(0 ^ check(r) ^ check(l - 1));
		}

	}

	public static long check(long x) {
		long a = x % 8;
		if (a == 0 || a == 1)
			return x;
		if (a == 2 || a == 3)
			return 2;
		if (a == 4 || a == 5)
			return x + 2;
		if (a == 6 || a == 7)
			return 0;
		return 0;
	}
}
