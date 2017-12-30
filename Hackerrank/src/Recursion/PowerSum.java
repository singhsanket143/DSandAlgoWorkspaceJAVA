package Recursion;

import java.util.Scanner;

public class PowerSum {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		int num = scn.nextInt();
		int n = scn.nextInt();
		
		System.out.println(nthpower(num, n, 1, 0, ""));
	}

	public static int nthpower(int num, int n, int k, double osf, String st) {
		
		if (osf == num) {
			//System.out.println(st);
			return 1;
		}
		if (osf > num) {
			return 0;
		}
		if (Math.pow(k, n) > num) {
			return 0;
		}

		// if(k>Math.pow(num, (1/n))){
		// return 0;
		// }
		int count = 0;
		count += nthpower(num, n, k + 1, osf + Math.pow(k, n), st + k + ",");
		count += nthpower(num, n, k + 1, osf, st);
		// nthpower(num, n, k+2, osf+Math.pow(k, n));
		return count;
	}
}
