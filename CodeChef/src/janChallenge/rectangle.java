package janChallenge;

import java.util.Scanner;

public class rectangle {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		int t = scn.nextInt();
		while (t-- > 0) {
			int a = scn.nextInt();
			int b = scn.nextInt();
			int c = scn.nextInt();
			int d = scn.nextInt();
			if (isRectangle(a, b, c, d)) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
	}

	public static boolean isRectangle(int a, int b, int c, int d) {
		boolean result = true;
		int[] arr = { a, b, c, d };
		for (int i = 0; i < arr.length; i++) {
			int check = arr[i];
			int count = 1;
			for (int j = 0; j < arr.length; j++) {
				if (i == j)
					continue;
				if (arr[j] == arr[i]) {
					count++;
				}
			}
			if (count % 2 != 0) {
				return false;
			}
		}
		return result;
	}

}
