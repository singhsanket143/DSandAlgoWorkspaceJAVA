package NumberThoery2;

import java.util.Scanner;

public class BoringFactorials {

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		long t = s.nextLong();
		while (t-- > 0) {
			long n = s.nextLong();
			long p = s.nextLong();
			System.out.println(willsonTheorem(n, p));
		}
	}

	public static long willsonTheorem(long n, long p) {
		if (n > p) {
			return 0;
		} else {
			long r = 1;
			for (long i = n + 1; i <= p - 1; i++) {
				r = ((r % p) * (modIterative(i, p - 2, p) % p)) % p;
			}
			
			return (((-1)*r)+p)%p;
		}

	}
	
	public static long modIterative(long a, long b, long c) {
		long ans = 1;
		while (b != 0) {
			if ((b & 1) == 1) {
				ans = ((ans) % c * (a % c)) % c;
			}
			a = ((a) % c * (a) % c) % c;
			b = b >> 1;
		}
		return ans;
	}

	public static long modRecursive(long a, long b, long c) {
		if (b == 0) {
			return 1;
		}
		if (b % 2 == 0) {
			return modRecursive((a * a) % c, b / 2, c);
		} else {
			return ((a % c) * (modRecursive((a * a) % c, b / 2, c))) % c;
		}
	}

}
