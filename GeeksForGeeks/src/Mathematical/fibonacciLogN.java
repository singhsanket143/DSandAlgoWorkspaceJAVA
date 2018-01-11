package Mathematical;

import java.util.Scanner;

public class fibonacciLogN {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] strg = new int[ 1];
		System.out.println(fibLogN(n, strg));
	}

	 public static long fibLogN(long n, int[] strg) {
			if (n == 0 || n == 1) {
				return n;
			}
			long k = ((n & 1) == 0) ? n / 2 : (n + 1) / 2;

			long j = ((n & 1) == 0) ? (fibLogN(k, strg) * (2 * fibLogN(k - 1, strg) + fibLogN(k, strg)))
					: (fibLogN(k, strg) * fibLogN(k, strg) + fibLogN(k - 1, strg) * fibLogN(k - 1, strg));
			return j%1000000007 ;
		}

}
