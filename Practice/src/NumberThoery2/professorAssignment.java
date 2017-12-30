package NumberThoery2;

import java.math.BigInteger;
import java.util.Scanner;

public class professorAssignment {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		long n = scn.nextLong();
		System.out.println(assignment(n));
	}

	public static long assignment(long n) {
		long result = 0;
		int mod = 1000000007;
		long m = 1;
		for (m = 1; m * m <= n; m++) {
			result += (m % mod * (m % mod + (n / m) % mod) % mod * ((n / m) % mod + 1 - m % mod) % mod);
			result = result % mod;
		}
		if (m * m == n)
			result = (result % mod - bigch(m) % mod + mod) % mod;
		else
			result = (result % mod - bigch(m - 1) % mod + mod) % mod;
		return result % mod;
	}

	public static long ch(long n) {
		long mod = 1000000007;
		long a = n % mod;
		long b = (n % mod + 1) % mod;
		long c = ((2 * n) % mod + 1) % mod;
		long r = ((((a % mod) * (b % mod)) % mod) * (c % mod)) % mod;
		r = r / 6L;
		return r % mod;
	}
	
	public static long bigch(long n){
		String str=Long.toString(n);
		BigInteger bg=new BigInteger(str);
		BigInteger one=new BigInteger("1");
		BigInteger two=new BigInteger("2");
		BigInteger six=new BigInteger("6");
		BigInteger mod=new BigInteger("1000000007");
		BigInteger a=bg.add(one);
		BigInteger t=bg.multiply(two);
		BigInteger b=t.add(one);
		bg=bg.multiply(a.multiply(b));
		bg=bg.divide(six);
		bg=bg.mod(mod);
		return Long.parseLong(bg.toString());
		
	}

}