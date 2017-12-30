package HackerEarth;

import java.util.Scanner;

public class magicalWord {
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		replacingstring();
	}

	public static void replacingstring() {

		int N = scn.nextInt();

		for (int i = 0; i < N; i++) {
			scn.nextInt();
			String str = scn.next();
			System.out.println(replacingchars(str));

		}

	}

	public static String replacingchars(String str) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			int ac = (int) ch;
			int fg = (int) ch;
			if (!ifprime((int) ch)) {
				if (fg < 65) {
					sb.append((char) 67);
				} else if (fg > 112) {
					sb.append((char) 113);
				} else {
					int a = NextPrime((int) ch);
					int b = previousPrime((int) ch);
					char convert = (char) tobereturn(a, b, fg);
					sb.append(convert);
				}
			} else if (ifprime((int) ch)) {
				if (fg < 65) {
					sb.append((char) 67);
				} else if (fg > 112) {
					sb.append((char) 113);
				} else {
					sb.append(ch);
				}
			}
		}
		return sb.toString();

	}

	public static boolean ifprime(int n) {
		boolean val = true;
		int i = 2;
		int rem = 0;
		while (i * i <= n) {
			rem = n % i;
			if (rem == 0) {
				val = false;
				return val;
			}
			i = i + 1;
		}
		return val;
	}

	public static int NextPrime(int n) {
		int i = n;
		for (; i < 2 * n; ++i) {
			if (ifprime(i)) {
				break;
			}
		}
		return i;
	}

	public static int previousPrime(int n) {
		int i = n;
		for (; i < 2 * n; --i) {
			if (ifprime(i)) {
				break;
			}
		}
		return i;
	}

	public static int tobereturn(int a, int b, int ch) {
		if ((a - ch) < (ch - b)) {
			return a;
		} else {
			return b;

		}
	}

}
