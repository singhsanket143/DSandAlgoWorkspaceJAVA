package NumberThoery2;

import java.util.Scanner;

public class lcmsum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		long n = scn.nextLong();
		long[] phi = eulerTotitent(n + 1);
		long result = 0;
		long temp = 0, r = 0;
		for (int i = 1; i <= n; i++) {
			if (n % i == 0) {
				temp += phi[i] * i;
			}
		}
		result=temp+1;
		result*=n;
		System.out.println(result/2);
	}

	public static long[] eulerTotitent(long n) {
		long[] arr = new long[(int) (n + 1)];
		for (int i = 1; i <= n; i++) {
			arr[i] = i;
		}

		for (int i = 2; i <= n; i++) {
			if (arr[i] == i) {
				arr[i] = i - 1;
				for (int j = 2 * i; j <= n; j += i) {
					arr[j] = (arr[j] * (i - 1)) / i;
				}
			}
		}
		return arr;
	}

}
