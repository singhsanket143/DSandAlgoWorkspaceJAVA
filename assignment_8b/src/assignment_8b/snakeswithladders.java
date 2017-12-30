package assignment_8b;

public class snakeswithladders {

	public static void main(String[] args) {
		System.out.println(laddersnakeboard(15, 0, getladder(15), new int[] {5,4,2,6,2}, 0));

	}

	public static boolean laddersnakeboard(int end, int curr, int[] ladder, int[] dv, int si) {
		if (curr == end) {

			return true;

		}
		if (si == dv.length) {
			return false;
		}
		if(curr>end){
			return false;
		}
		if (ladder[curr] != 0) {
			return laddersnakeboard(end, ladder[curr], ladder, dv, si);
		} else {

			return laddersnakeboard(end, curr + dv[si], ladder, dv, si + 1);
		}
//		return false;
	}

	public static boolean[] printprimesoe(int n) {
		boolean[] primes = new boolean[n + 1];
		for (int i = 0; i < primes.length; i++) {
			primes[i] = true;
		}
		for (int div = 2; div * div < n; div++) {
			if (primes[div]) {
				for (int multiple = 2; div * multiple <= n; multiple++) {
					primes[div * multiple] = false;
				}
			}
		}
		return primes;
	}

	public static int[] getladder(int n) {
		int[] rv = new int[n + 1];
		boolean[] primes = printprimesoe(n);
		int left = 0, right = primes.length - 1, count = 0;
		while (left <= right) {
			while (!primes[left]) {
				left++;
			}
			while (!primes[right]) {
				right--;
			}
			if (left <= right) {
				count++;
				if (count % 2 == 1) {
					rv[left] = right;
				} else
					rv[right] = left;
				left++;
				right--;
			}

		}
		return rv;
	}

}
