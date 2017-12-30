package assignment_8b;

public class ladder {

	public static void main(String[] args) {
		ladderboard(15, 0, getladder(15), "");

	}

	public static void ladderboard(int end, int curr, int[] ladder, String osf) {
		if (curr == end) {
			System.out.println(osf);
			return;

		}
		if (curr > end) {
			return;
		}
		if (ladder[curr] != 0) {
			ladderboard(end, ladder[curr], ladder, osf + "L");
		} else {
			for (int dice = 1; dice <= 6; dice++) {
				ladderboard(end, curr + dice, ladder, osf + "D" + dice);
			}
		}
	}

	public static boolean[] printprimesoe(int n) {
		boolean[] primes = new boolean[n + 1];
		for (int i = 2; i < primes.length; i++) {
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
		int left = 0, right = primes.length - 1;
		while (left <= right) {
			while (!primes[left]) {
				left++;
			}
			while (!primes[right]) {
				right--;
			}
			if (left <= right) {
				rv[left] = right;
				left++;
				right--;
			}

		}
		return rv;
	}
}
