import java.math.BigInteger;
import java.util.Scanner;

public class poerofTwo {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int t = scn.nextInt();
		while (t > 0) {
			t--;
			int n = scn.nextInt();
			System.out.println(pow(n));

		}
	}

	public static BigInteger pow(int n) {
		BigInteger one = new BigInteger("1");
		BigInteger onehellp = new BigInteger("1");
		one=one.shiftLeft(n);
		return one.subtract(onehellp);
	}

}
