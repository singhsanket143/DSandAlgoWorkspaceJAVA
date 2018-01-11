package DynamicProgramming;

public class MinimumCutsToMAkePalindrome {

	public static void main(String[] args) {

		System.out.println(minimumCuts("eeegeeksforskeeggeeks"));
	}

	public static int minimumCuts(String str) {
		boolean[][] strg = new boolean[str.length()][str.length()];
		int[] check = new int[str.length()];

		for (int i = 0; i < str.length(); i++) {
			strg[i][i] = true;
		}

		for (int l = 2; l <= str.length(); l++) {
			for (int i = 0; i < str.length() - l + 1; i++) {
				int j = i + l - 1;
				if (l == 2) {
					strg[i][j] = (str.charAt(i) == str.charAt(j));
				} else {
					strg[i][j] = (str.charAt(i) == str.charAt(j)) && strg[i + 1][j - 1];
				}
			}
		}

		for (int i = 0; i < str.length(); i++) {
			if (strg[0][i] == true) {
				check[i] = 0;
			} else {
				check[i] = Integer.MAX_VALUE;
				for (int j = 0; j < i; j++) {
					if (strg[j + 1][i] == true && 1 + check[j] < check[i]) {
						check[i] = 1 + check[j];
					}
				}
			}
		}

		return check[str.length() - 1];
	}

}
