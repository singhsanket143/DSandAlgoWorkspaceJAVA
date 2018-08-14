package NumberThoery2;

public class ModularExponentiationIterative {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(modIterative(12, 1000000000, 1000000007));
		long result =1;
		for(int i=1;i<100000000000000L;i++) {
			result=result*34;
			result%=1000000007L;
		}
		System.out.println(result%1000000007L);
	}

	public static long modIterative(long a, long b, long c) {
		long ans = 1;
		while (b != 0) {
			if ((b & 1) == 1) {
				ans = ((ans) % c * (a % c)) % c;
			}
			a = ((a) % c * (a) % c) % c;
			b = b >> 1;
		}
		return ans;
	}

}
