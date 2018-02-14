package DP;

public class tilingProblem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] strg = new int[10];

	}

	public static int tiling(int n, int[] strg) {
		if (n == 1 || n == 2) {
			return n;
		}
		if (strg[n] != 0) {
			return strg[n];
		}
		int r1 = tiling(n - 1, strg);
		int r2 = tiling(n - 2, strg);
		strg[n] = r1 + r2;
		return strg[n];
	}

}
