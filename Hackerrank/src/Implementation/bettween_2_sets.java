package Implementation;

import java.util.Arrays;
import java.util.Scanner;

public class bettween_2_sets {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int m = scn.nextInt();
		long[] arr1 = new long[n];
		long[] arr2 = new long[m];
		for (int i = 0; i < n; i++) {
			arr1[i] = scn.nextLong();
		}
		for (int i = 0; i < m; i++) {
			arr2[i] = scn.nextLong();
		}
		int c = 0;
		long data1 = lcm(arr1);
		long data2 = gcd(arr2);
		long temp = 0;
		int d = 0,count=0;
		if (data2 % data1 == 0) {
			while (temp <= data2) {
				temp = data1;
				c++;
				temp *= c;
				if(d==arr2.length){
					count++;
				}
				d=0;
				for (int i = 0; i < arr2.length; i++) {
					
					if (arr2[i] % temp == 0) {
						d++;
						continue;
					} else
						break;
				}
			}
		}
		System.out.println(count);
	}

	public static long gcd(long a, long b) {
		while (b > 0) {
			long temp = b;
			b = a % b; // % is remainder
			a = temp;
		}
		return a;
	}

	public static long gcd(long[] input) {
		long result = input[0];
		for (int i = 1; i < input.length; i++)
			result = gcd(result, input[i]);
		return result;
	}

	public static long lcm(long a, long b) {
		return a * (b / gcd(a, b));
	}

	public static long lcm(long[] input) {
		long result = input[0];
		for (int i = 1; i < input.length; i++)
			result = lcm(result, input[i]);
		return result;
	}
}
