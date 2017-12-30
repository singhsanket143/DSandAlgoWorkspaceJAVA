package BitManipulation;

import java.util.Scanner;

public class SetBitsFrom1ToN {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		System.out.println("Enter a number");
		int n = scn.nextInt();
		int result = OnesUptoNearestPowerofTwo(n);
		int k = nearestPoweroftwo(n)-1;
		for (int i = (1 << k); i <= n; i++) {
			result+=brianKernighan(i);
		}
		System.out.println(result);
	}

	public static int OnesUptoNearestPowerofTwo(int n) {
		int power = nearestPoweroftwo(n)-1;
		return (power) * (1 << (power - 1));
	}

	public static int nearestPoweroftwo(int num) {
		long temp = num;
		long count = 0;
		int log_val = 0;
		while (temp > 0) {
			log_val++;
			temp >>= 1;
		}
		return log_val;
	}

	public static int brianKernighan(int num) {
		int count = 0;
		while (num > 0) {
			num = num & (num - 1);
			count++;
		}
		return count;
	}

}
