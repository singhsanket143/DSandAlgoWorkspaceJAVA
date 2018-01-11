package novChallenge;

import java.io.PrintWriter;
import java.util.Scanner;

public class periodicPallindromicstring {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		PrintWriter pw = new PrintWriter(System.out);
		int t = scn.nextInt();
		while (t-- > 0) {
			int n = scn.nextInt();
			int p = scn.nextInt();
			pw.println(periodicString(n, p));
			pw.flush();
		}

	}

	public static String periodicString(int n, int p) {
		if (n % p != 0 || p < 3) {
			return "impossible";
		}
		if (n == p) {
			if (n <= 2) {
				return "impossible";
			} else {
				StringBuilder sb = new StringBuilder();

				if (n % 2 != 0) {
					sb.append("b");
					for (int i = 0; i < n / 2; i++) {
						sb.insert(0, 'a');
						sb.append('a');
					}

					return sb.toString();
				} else {
					sb.append("bb");
					for (int i = 0; i < n / 2 - 1; i++) {
						sb.insert(0, 'a');
						sb.append('a');
					}
					return sb.toString();
				}
			}
		} else {
			if (n <= 2) {
				return "impossible";
			} else if (n % 2 != 0 && p % 2 != 0) {
				StringBuilder sb = new StringBuilder();
				sb.append("b");
				int x = (p > 1) ? (p - 1) : (1);
				if (x == 1) {
					return "impossible";
				}
				int temp = 1;
				while (sb.length() <= n / 2) {
					if (temp == p) {
						// sb.insert(0, 'b');
						sb.append('b');
						temp = 1;
					}
					temp++;
					// sb.insert(0, 'a');
					sb.append('a');
				}
				String str = sb.toString();
				String str1 = sb.reverse().toString();
				str = str1.substring(0, str1.length() - 1) + str;
				// System.out.println(str.length());
				return str;
			}

			else if (n % 2 == 0 && p % 2 != 0) {
				StringBuilder sb = new StringBuilder();
				// sb.append("aa");
				int x = (p > 1) ? (p) : (1);
				if (p == 1)
					return "impossible";
				int temp = 1;
				for (int i = 0; i < x / 2; i++) {
					// sb.insert(0, 'a');
					sb.append('a');
					temp += 2;
				}
				while (sb.length() < n / 2) {
					if (temp % p == 0) {
						// sb.insert(0, 'b');
						sb.append('b');
						temp = 1;
					}
					temp++;
					// sb.insert(0, 'a');
					sb.append('a');
				}
				String str = sb.toString();
				String str1 = sb.reverse().toString();
				// System.out.println((str+str1).length());
				return str1 + str;
			} else if (n % 2 != 0 && p % 2 == 0) {
				return "impossible";
			} else {
				StringBuilder sb = new StringBuilder();
				sb.append("bb");
				for (int i = 0; i < p / 2 - 1; i++) {
					sb.insert(0, 'a');
					sb.append('a');
				}

				StringBuilder res = new StringBuilder();
				while (res.length() < n) {
					res.append(sb.toString());
				}
				return res.toString();
			}
		}
	}
}