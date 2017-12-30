package NumberThoery2;

import java.util.Scanner;

public class SanchitAndReactor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		long n = scn.nextLong();
		while (n-- > 0) {
			long t = scn.nextLong();
			long m = scn.nextLong();
			System.out.println(reactor(t, m));
		}

	}

	public static long reactor(long t, long m) {
		long factor = m-1;
		if (t < m) {
			return multiply(t, m);
		} else {
			long v=t/m;
			if ((t / m) % 2 == 0) {
				factor = 1;
			}
			long val =1;
			for(long i=t%m;i>=1;i--){
				long r=t-i+1;
				val=((val%m)*(r%m))%m;
			}
			return (val * factor)%m;
		}
	}

	public static long multiply(long t, long m) {
		long result = 1;
		for (int i = 1; i <= t; i++) {
			result = ((result % m) * (i % m)) % m;
		}
		return result;

	}

}
