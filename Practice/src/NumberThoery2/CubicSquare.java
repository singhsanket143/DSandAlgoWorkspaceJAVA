package NumberThoery2;

import java.util.Scanner;

public class CubicSquare {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		long t = scn.nextLong();
		while (t-- > 0) {
			long a = scn.nextLong();
			String b = scn.next();
			long c = scn.nextLong();
			System.out.println(modIterative(a, b, c));
		}

	}

	public static long modIterative(long a, String b, long c) {
		long ans = 1;
		for (int i = b.length() - 1; i >= 0; i--) {
			if (b.charAt(i) == '1') {
				ans = ((ans) % c * (a % c)) % c;
			} else if (b.charAt(i) == '2') {
				ans = ((((ans) % c * (a % c)) % c) * (a % c)) % c;

			}
			a = ((((a) % c * (a) % c) % c) * (a % c)) % c;

		}
		return ans;
	}

}
