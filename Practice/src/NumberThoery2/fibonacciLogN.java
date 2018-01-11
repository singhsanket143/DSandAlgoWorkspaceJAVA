package NumberThoery2;

public class fibonacciLogN {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(fib(8));
	}

	public static int fib(int n) {
		int[][] A = { { 1, 1 }, { 1, 0 } };
		if (n == 0) {
			return 0;
		}
		power(A, n - 1);
		return A[0][0];
	}

	public static void power(int[][] A, int n) {
		if (n == 0 || n == 1) {
			return;
		}
		power(A, n / 2);
		multiply(A, A);
		if (n % 2 != 0) {
			int[][] M = { { 1, 1 }, { 1, 0 } };
			multiply(A, M);
		}
	}

	public static void multiply(int[][] A, int[][] M) {
		int fvalue=A[0][0]*M[0][0]+A[0][1]*M[1][0];
		int svalue=A[0][0]*M[1][0]+A[0][1]*M[1][1];
		int tvalue=A[1][0]*M[0][0]+A[1][1]*M[1][0];
		int lvalue=A[1][0]*M[0][1]+A[1][1]*M[1][1];
		A[0][0]=fvalue;
		A[0][1]=svalue;
		A[1][0]=tvalue;
		A[1][1]=lvalue;
	}

}
