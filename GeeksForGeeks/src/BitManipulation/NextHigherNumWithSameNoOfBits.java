package BitManipulation;

import java.util.Scanner;

public class NextHigherNumWithSameNoOfBits {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		System.out.println(snoob(n));

	}
	// snoob==Same No Of One Bits

	public static int snoob(int num) {
		int isolaterightmostone = num & -num;
		int leftshift = num + isolaterightmostone;
		int series = num ^ leftshift;
		int result = series / isolaterightmostone;
		result = result >>= 2;

		return (result | leftshift);
	}

}
