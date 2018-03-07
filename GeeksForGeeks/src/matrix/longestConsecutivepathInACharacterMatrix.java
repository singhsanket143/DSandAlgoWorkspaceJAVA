package matrix;

public class longestConsecutivepathInACharacterMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		char mat[][] = { { 'a', 'c', 'd' }, { 'h', 'b', 'a' }, { 'i', 'g', 'f' } };

		System.out.println(getLength(mat, 'a'));
		System.out.println(getLength(mat, 'e'));
		System.out.println(getLength(mat, 'b'));
		System.out.println(getLength(mat, 'f'));
	}

	public static int[] x = { 0, 1, 1, -1, 1, 0, -1, -1 };
	public static int[] y = { 1, 0, 1, 1, -1, -1, 0, -1 };

	public static int getLengthHelper(char[][] mat, int i, int j, char prev, int[][] dp) {
		if (!(isValid(i, j, mat)) || !isAdjacent(prev, mat[i][j])) {
			return 0;
		}
		if (dp[i][j] != -1) {
			return dp[i][j];
		}
		int ans = 0;
		for (int k = 0; k < 8; k++) {
			ans = Math.max(ans, 1 + getLengthHelper(mat, i + x[k], j + y[k], mat[i][j], dp));
		}
		dp[i][j] = ans;
		return ans;
	}

	public static int getLength(char[][] mat, char s) {
		int[][] dp = new int[mat.length][mat[0].length];
		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp.length; j++) {
				dp[i][j] = -1;
			}
		}

		int ans = 0;
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++) {
				if (mat[i][j] == s) {
					for (int k = 0; k < 8; k++) {
						ans = Math.max(ans, 1 + getLengthHelper(mat, i + x[k], j + y[k], s, dp));
					}
				}
			}
		}
		return ans;
	}

	public static boolean isValid(int i, int j, char[][] mat) {
		if (i < 0 || j < 0 || i >= mat.length || j >= mat[0].length) {
			return false;
		} else {
			return true;
		}
	}

	public static boolean isAdjacent(char prev, char curr) {
		return ((curr - prev) == 1);
	}

}
