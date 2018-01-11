import java.util.Scanner;

public class sachinAndVarun {

	public static class Triplet {
		long x;
		long y;
		long gcd;
	}

	public static Triplet extendedeuclid(long a, long b) {
		if (b == 0) {
			Triplet baseans = new Triplet();
			baseans.gcd = a;
			baseans.x = 1;
			baseans.y = 0;
			return baseans;
		}
		Triplet smallans = extendedeuclid(b, a % b);
		Triplet myans = new Triplet();
		myans.gcd = smallans.gcd;
		myans.x = smallans.y;
		myans.y = (smallans.x - ((a / b) * (smallans.y)));
		return myans;
	}

	public static long moduloInverse(long a, long m) {
		long x = extendedeuclid(a, m).x;
		return (x % m + m) % m;
	}

	public static long gcd(long a, long b) {
		long g, t, m = 0;
		if (b <= a) {
			while (b != 0) {
				g = a % b;
				a = b;
				b = g;
				if (b == 0) {
					m = a;
				}
			}
		} else {
			while (a != 0) {
				g = b % a;
				b = a;
				a = g;
				if (a == 0) {
					m = b;
				}
			}
		}
		return m;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int t = scn.nextInt();
		while (t > 0) {
			long a, b, d;
			t--;
			a = scn.nextLong();
			b = scn.nextLong();
			d = scn.nextLong();
			long g = gcd(a, b);
			if (d % g != 0) {
				System.out.println(0);
				continue;
			}
			if (d == 0) {
				System.out.println(1);
				continue;
			}
			a /= g;
			b /= g;
			d /= g;
			long y1 = ((d % a) * moduloInverse(b, a)) % a;
			long firstvalue = d / b;
			if (d < y1 * b) {
				System.out.println(0);
				continue;
			}
			long n = (firstvalue - y1) / a;
			System.out.println(n + 1);
			
		}
	}

}
