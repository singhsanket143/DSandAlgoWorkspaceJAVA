package Implementation;

import java.math.BigInteger;
import java.util.Scanner;

public class BIgIntegerFactorial {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		System.out.println(factorial(n));

	}

	public static BigInteger factorial(int n) {
		BigInteger x = new BigInteger("1");
		for (int i = 2; i <= n; i++) {
			x = x.multiply(BigInteger.valueOf(i));
		}
		return x;
	}

}
