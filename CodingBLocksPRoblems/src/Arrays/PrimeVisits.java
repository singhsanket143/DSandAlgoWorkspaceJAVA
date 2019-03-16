package Arrays;

import java.util.Scanner;

public class PrimeVisits {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 100000;
		int sieve[] = new int[100005];
		primeSieve(n, sieve);
		Scanner scn = new Scanner(System.in);
		int t = scn.nextInt();
		while(t-- > 0) {
			int a = scn.nextInt();
			int b = scn.nextInt();
			int count = 0;
			for(int i=a;i<=b;i++) {
				if(sieve[i] == 1) {
					count++;
				}
			}
			System.out.println(count);
		}

	}
	
	public static void primeSieve(int n, int sieve[]) {
		sieve[0] = sieve[1] = 0;
		sieve[2] = 1;
		for(int i=3;i<=n;i+=2) {
			sieve[i] = 1;
		}
		for (int div = 2; div * div < n; div++) {
			if (sieve[div] == 1) {
				for (int multiple = 2; div * multiple <= n; multiple++) {
					sieve[div * multiple] = 0;
				}
			}
		}
	}

}
