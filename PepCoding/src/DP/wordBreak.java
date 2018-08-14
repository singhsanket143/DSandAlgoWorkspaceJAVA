package DP;

public class wordBreak {

	public static void main(String[] args) {
		// TODO Auto-generated method stubs
		System.out.println(wordbreak("samsungandmangok"));

	}

	public static boolean checkDict(String str) {
		String[] dict = { "mobile", "samsung", "sam", "sung", "man", "mango", "icecream", "and", "go", "i", "like",
				"ice", "cream", "am", "ace" };

		for (int i = 0; i < dict.length; i++) {
			if (str.equals(dict[i])) {
				return true;
			}
		}
		return false;
	}

	public static boolean wordbreak(String str) {
		boolean[] dp = new boolean[str.length() + 1];
		for (int i = 1; i <= str.length(); i++) {
			if (dp[i] == false && checkDict(str.substring(0, i))) {
				dp[i] = true;
			}

			if (dp[i] == true) {
				if (i == str.length()) {
					return true;
				}
				for (int j = i + 1; j <= str.length(); j++) {
					String temp = (str.substring(i, j));
					if (dp[j] == false && checkDict(temp)) {
						dp[j] = true;
					}

					if (j == str.length() && dp[j] == true) {
						return true;
					}

				}
			}
		}
		return false;
	}

}
