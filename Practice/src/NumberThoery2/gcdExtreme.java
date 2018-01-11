package NumberThoery2;

import java.util.Scanner;

public class gcdExtreme {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		long[] dp=new long[1000005];
		long[] phi = eulerTotitent(1000005);
		gcd(1000004,phi,dp);
		while (n != 0) {
			System.out.println(dp[n]);
			n = scn.nextInt();
		}
	}

	public static long gcd(int n,long[] phi,long[] dp) {
		
		long[] result = new long[n + 1];
		for (int i = 1; i <= n; i++) {
			for (int j = 2; i * j <= n; j++) {
				result[i * j] += i * phi[j];
			}
		}
		long f = 0;
		for (int i = 0; i < result.length; i++) {
			f += result[i];
			dp[i]=f;
		}
		
		return f;
	}

	public static long[] eulerTotitent(int n) {
		long[] arr = new long[n + 1];
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
