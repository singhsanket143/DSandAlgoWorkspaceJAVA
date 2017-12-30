public class multiplicativeModuloInverse {

	public static class Triplet {
		int x;
		int y;
		int gcd;
	}

	public static Triplet extendedeuclid(int a, int b) {
		if (b == 0) {
			Triplet baseans = new Triplet();
			baseans.gcd = a;
			baseans.x = 1;
			baseans.y = 0;
			return baseans;
		}
		Triplet smallans = extendedeuclid(b, a % b);
		Triplet myans = new Triplet();
		myans.gcd = smallans.gcd;
		myans.x = smallans.y;
		myans.y = (smallans.x - ((a / b) * (smallans.y)));
		return myans;
	}

	public static int moduloInverse(int a, int m) {
		int x = extendedeuclid(a, m).x;
		return x;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Triplet extend = new Triplet();
		extend = extendedeuclid(16, 10);
		System.out.println(extend.gcd);
		System.out.println(extend.x);
		System.out.println(extend.y);
	}

}
