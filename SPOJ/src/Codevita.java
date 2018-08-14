import java.util.Scanner;

public class Codevita {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long sum = 0;
		int N = sc.nextInt();
		for (int i = 0; i < N; i++) {
			final long x = sc.nextLong();
			long str = (long) power(2, x, 100);
			sum = ((sum % 100) + (str % 100)) % 100;
		}

		System.out.println(sum % 100);
	}

	static long power(long x, long y, long p) {
		long res = 1;
		x = x % p;

		while (y > 0) {
			if ((y & 1) == 1)
				res = (res * x) % p;
			y = y >> 1;
			x = (x * x) % p;
		}
		return res;
	}

}