package Lecture17;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class time_and_space_complexity_1 {

	public static void main(String[] args) {
		// System.out.println(getpv(3, 2));
		Scanner scn=new Scanner(System.in);
		System.out.println(countpalindromicss(scn.next()));
		
		// printprimesoe(100000000);
//		String str="a";
//		str.charAt(0);

	}

	public static int getpv(int x, int n) {
		int rv = 0;
		int powx = x;
		while (n > 0) {
			rv += powx * n;
			powx = powx * x;
			n--;
		}
		return rv;
	}

	public static int countpalindromicss(String str) {
		int rv = 0;

		// odd length palindromes
		for (int axis = 0; axis < str.length(); axis++) {
			for (int orbit = 0; axis - orbit >= 0 && axis + orbit < str.length(); orbit++) {
				if (str.charAt(axis + orbit) == str.charAt(axis - orbit)) {
					rv++;
				} else {
					break;
				}
			}
		}

		// even length palindrome
		for (int axis = 1; axis < str.length(); axis++) {
			for (int orbit = 1; axis - orbit >= 0 && axis + orbit - 1 < str.length(); orbit++) {
				if (str.charAt(axis - orbit) == str.charAt(axis + orbit - 1)) {
					rv++;
				} else {
					break;
				}
			}
		}

		return rv;


	}

	public static void printprimesoe(int n) {
		boolean[] primes = new boolean[n + 1];
		for (int i = 0; i < primes.length; i++) {
			primes[i] = true;
		}
		for (int div = 2; div * div < n; div++) {
			if (primes[div]) {
				for (int multiple = 2; div * multiple <= n; multiple++) {
					primes[div * multiple] = false;
				}
			}
		}
		int c=0;
		for (int i = 2; i < primes.length; i++) {
			if (primes[i])
				c++;
		}
		System.out.println(c);
	}
}
