package NumberThoery2;

public class MatrixExponentiationRecursive {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(modRecursive(2, 6, 5));
	}

	public static int modRecursive(int a, int b, int c) {
		if (b == 0) {
			return 1;
		}
		if (b % 2 == 0) {
			return modRecursive((a * a) % c, b / 2, c);
		} else {
			return ((a % c) * (modRecursive((a * a) % c, b / 2, c))) % c;
		}
	}

}
