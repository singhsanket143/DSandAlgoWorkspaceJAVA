
public class noOfBalancedBT {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static int balancedBT(int h) {
		if (h <= 1) {
			return 1;
		}
		int mod = (int) Math.pow(10, 9) + 7;
		int x = balancedBT(h - 1);
		int y = balancedBT(h - 2);
		int firstValue = (int) (((long)x * x) % mod);
		int secondValue = (int) (((long)(x) * y*2) % mod);
		int ans = (int) ((long)(firstValue + secondValue) % mod);
		return ans;
	}

}
