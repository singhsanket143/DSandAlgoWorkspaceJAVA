package Lecture31;


public class client {

	public static void main(String[] args) {
		System.out.println(search("the lazy dog is going to be sufficiently inconvinient", "lazy"));
	}

	public static int search(String src, String pat) {
		int rv = -1;
		int i = 0;
		while (i < src.length() - pat.length()) {
			int j = 0;
			while (j < pat.length()) {
				if (src.charAt(i + j) == pat.charAt(j)) {
					j++;
					if (j == pat.length())
						rv = i;
				} else {
					break;
				}
			}
			i++;
		}
		return rv;
	}

}
