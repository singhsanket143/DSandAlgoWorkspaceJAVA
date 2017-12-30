package Implementation;

import java.util.ArrayList;
import java.util.Scanner;

public class permutation {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		for (int m = 0; m < n; m++) {
			ArrayList<String> a = new ArrayList<>();
			int b = scn.nextInt();

			int k = scn.nextInt();
			String str = "";
			for (int i = 1; i <= b; i++) {
				str += i;
			}
			permutation(str, "", a);
			boolean bool = false;
			for (int i = 0; i < a.size(); i++) {

				for (int j = 0; j < a.get(i).length(); j++) {
					if (Math.abs((a.get(i).charAt(j) - '0') - j - 1) == k) {
						bool = true;
					} else {
						bool = false;
						break;
					}
				}
				if (bool) {
					print(a.get(i));
					break;
				}
			}
			System.out.println();
			if (!bool) {
				System.out.print(-1);
			}
		}
		
	}

	public static void permutation(String str, String osf, ArrayList<String> a) {
		if (str.length() == 0) {
			a.add(osf);
			return;
		}
		for (int i = 0; i < str.length(); i++) {
			char cc = str.charAt(i);
			String ros = str.substring(0, i) + str.substring(i + 1);
			permutation(ros, osf + cc, a);
		}

	}

	public static void print(String str) {
		for (int i = 0; i < str.length(); i++) {
			System.out.print(str.charAt(i) + " ");
		}
	}

}
