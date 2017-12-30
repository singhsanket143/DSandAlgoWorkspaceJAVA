package lunchtime;

import java.math.BigInteger;
import java.util.Scanner;

public class maximumNumber {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		int t = scn.nextInt();
		while (t-- > 0) {
			String str = scn.next();
			StringBuilder sb = new StringBuilder(str);
			BigInteger b = new BigInteger(str);

			System.out.println(maxNumber(sb, b));
		}
	}

	public static BigInteger maxNumber(StringBuilder sb, BigInteger b) {
		BigInteger six = new BigInteger("6");
		BigInteger zero = new BigInteger("0");
		if(b.mod(six).equals(zero))
			return b;
		
//		int temp = -1;
		BigInteger t3 = new BigInteger("-1");
		for (int i = sb.length() - 1; i >= 0; i--) {
			String res = sb.substring(0, i) + sb.substring(i + 1);
			BigInteger t=new BigInteger(res);
//			int t1 = Integer.parseInt(res, 10);
			if (t.mod(six).equals(zero)) {
				if (t.compareTo(t3)==1) {
//					temp = t1;
					t3=t;
				}
			}

		}
		return t3;
	}

	

}
