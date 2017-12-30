package assignment_8a;

public class dictionary_permutation {

	public static void main(String[] args) {
		permutationpart2("bcad", "");

	}

	public static void permutationpart2(String str, String osf) {
		if (str.length() == 0) {
			for (int i = 1; i < osf.length(); i++) {

				if (osf.charAt(i - 1) - 'a' < osf.charAt(i) - 'a') {
					break;

				} else
					System.out.println(osf);
				return;
			}
		}
		boolean[] used = new boolean[26];
		for (int i = 0; i < str.length(); i++) {
			char cc = str.charAt(i);

			String ros = str.substring(0, i) + str.substring(i + 1);
			if (used[cc - 'a'] == false) {
				permutationpart2(ros, osf + cc);
				used[cc - 'a'] = true;
			}

		}
	}

}
