package implementation;

import java.util.Scanner;

public class reachNumber {

	public static void main(String args[]) {
		Scanner scn=new Scanner(System.in);
		int t=scn.nextInt();
		while(t-- > 0) {
			int n=scn.nextInt();
			System.out.println(reachNumber(n));
		}
	}

	public static long reachNumber(long target) {
		target = Math.abs(target);
		long k = 0;
		while (target > 0)
			target -= ++k;
		return target % 2 == 0 ? k : k + 1 + k % 2;
	}
}
