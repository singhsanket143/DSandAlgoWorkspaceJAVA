package lunchtime;

import java.math.BigInteger;
import java.util.Scanner;

public class maximumNumber {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		int t = scn.nextInt();
		while (t-- > 0) {
			String str = scn.next();
			System.out.println(maxNumber(str));
		}
	}

	public static String maxNumber(String s) {
		int n = s.length();
		int sum = 0;
		for (int i = 0; i < s.length(); i++) {
			sum += s.charAt(i) - '0';
			sum = sum % 3;
		}
		int lpos = -1;
		for (int i = 0; i < n; i++) {
			int k=(i==n-1)?1:0;
			if((s.charAt(i)-'0')%3==sum && (s.charAt(n-1-k)-'0')%2==0) {
				lpos = i;
				if(i+1<n&& s.charAt(i)<s.charAt(i+1)) {
					break;
				}
			}
		}
		return (lpos==-1)?"-1":s.substring(0, lpos)+s.substring(lpos+1);
	}

}
