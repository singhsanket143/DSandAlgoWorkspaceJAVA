package Dynamic;

import java.math.BigInteger;
import java.util.Scanner;

public class modifiedfibonacci {
	
	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
		long t1=scn.nextLong();
		long t2=scn.nextLong();
		long n=scn.nextLong();
		
		System.out.println(factorial(n, t1, t2));
	}
	public static BigInteger factorial(long n,long t1,long t2) {
		BigInteger x = new BigInteger("1");
		BigInteger a=BigInteger.valueOf(t1);
		BigInteger b=BigInteger.valueOf(t2);
		for (int i = 2; i < n; i++) {
			x = a.add(b.multiply(b));
			a=b;
			b=x;
			
		}
		return x;
	}
}
