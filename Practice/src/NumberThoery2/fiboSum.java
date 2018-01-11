package NumberThoery2;

public class fiboSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(fiboSum(500, 1000));
	}

	public static long fiboSum(long n, long m) {
		int mod = 1000000007;
//		System.out.println(((fib(m + 2))));
		long sum = ((fib(m + 2)) % mod - (fib(n + 1)) % mod + mod) % mod;
		return sum;
	}

	public static long fib(long n) {
		long[][] A = { { 1, 1 }, { 1, 0 } };
		if (n == 0) {
			return 0;
		}
		power(A, n - 1);
		return A[0][0];
	}

	public static void power(long[][] A, long n) {
		if (n == 0 || n == 1) {
			return;
		}
		power(A, n / 2);
		multiply(A, A);
		if (n % 2 != 0) {
			long[][] M = { { 1, 1 }, { 1, 0 } };
			multiply(A, M);
		}
	}

	public static void multiply(long[][] A, long[][] M) {
		int mod = 1000000007;
		long fvalue = ((A[0][0] % mod * M[0][0] % mod) % mod + (A[0][1] % mod * M[1][0] % mod) % mod) % mod;
		long svalue = ((A[0][0] % mod * M[1][0] % mod) % mod + (A[0][1] % mod * M[1][1] % mod) % mod) % mod;
		long tvalue = ((A[1][0] % mod * M[0][0] % mod) % mod + (A[1][1] % mod * M[1][0] % mod) % mod) % mod;
		long lvalue = ((A[1][0] % mod * M[0][1] % mod) % mod + (A[1][1] % mod * M[1][1] % mod) % mod) % mod;
		A[0][0] = fvalue;
		A[0][1] = svalue;
		A[1][0] = tvalue;
		A[1][1] = lvalue;
	}

}
