package BitManipulation;

import java.math.BigInteger;
import java.util.Scanner;

public class twoscompliment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int t = scn.nextInt();
		while (t > 0) {
			long a = scn.nextLong();
			long b = scn.nextLong();
			if (a >= 0 && b >= 0) {
				long r1 = setbitsfrom1ton(b);
				long r2 = setbitsfrom1ton(a - 1);
				System.out.println(r1 - r2);
			} else if (a < 0 && b >= 0) {
				long r1 = setbitsfrom1ton(b);
				long r2 = totalonesinnegative(a);
				System.out.println(r1 + r2);
			} else {
				long r1 = totalonesinnegative(b + 1);
				long r2 = totalonesinnegative(a);
				System.out.println(r2 - r1);
			}
			t--;
		}
	}

	public static long totalbitsupton(long n) {
		return (32 * (n + 1));
	}

	public static long totalonesinnegative(long a) {
		if (a == 0)
			return 0;
		else {
			long n = Math.abs(a);
			long total_bits = totalbitsupton(n - 1);
			long total_ones = setbitsfrom1ton(n - 1);
			return total_bits - total_ones;
		}
	}

	public static long setbitsfrom1ton(long N) {
		if (N == 2147483647) {
			return 33285996514L+30;
		} else {
			long temp = N;
			long count = 0L;
			long log_val = 0L;
			while (temp >= 1) {
				log_val++;
				temp >>= 1;
			}

			for (int i = 1; i <= log_val; i++) // O(logN)
			{
				count = count + ((N + 1) / (1 << i)) * (1 << (i - 1)); // #Step
																		// 1

				long error = (N + 1) - (((N + 1) / (1 << i)) * (1 << i)) - (1 << (i - 1));
				if (error > 0)
					count = count + error;
			}

			return count;
		}
	}

	public static long OnesUptoNearestPowerofTwo(long n) {
		long power = nearestPoweroftwo(n) - 1;
		return (power) * (1 << (power - 1));
	}

	public static long nearestPoweroftwo(long num) {
		long temp = num;
		long count = 0;
		int log_val = 0;
		while (temp > 0) {
			log_val++;
			temp >>= 1;
		}
		return log_val;
	}

	public static long brianKernighan(long num) {
		long count = 0;
		while (num > 0) {
			num = num & (num - 1);
			count++;
		}
		return count;
	}

}
