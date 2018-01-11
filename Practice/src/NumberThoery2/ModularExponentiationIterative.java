package NumberThoery2;

public class ModularExponentiationIterative {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(modIterative(2, 45, 5));
	}

	public static int modIterative(int a, int b, int c) {
		int ans = 1;
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
