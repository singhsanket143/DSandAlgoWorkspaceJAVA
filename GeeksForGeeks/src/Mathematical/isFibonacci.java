package Mathematical;

import java.util.Scanner;

public class isFibonacci {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		System.out.println(isfib(n));

	}

	public static boolean isfib(int n) {
		return isPerfectSquare(5 * n * n + 4) || isPerfectSquare(5 * n * n - 4);
	}

	public static boolean isPerfectSquare(int n) {
		int s = (int) Math.sqrt(n);
		return s * s == n;
	}

}
