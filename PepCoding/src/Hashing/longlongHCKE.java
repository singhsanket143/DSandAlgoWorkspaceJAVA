package Hashing;

import java.io.*;
import java.util.*;

public class longlongHCKE {

	public static void main(String[] args) {

		FastReader scn = new FastReader();
		PrintWriter pw = new PrintWriter(System.out);
		String str = scn.next();
		long[] p = new long[1 << 20];
		long[] s = new long[1 << 20];
		p[0] = 1;
		for (int i = 1; i <= 1000000; i++)
			p[i] = p[i - 1] * 173;

		for (int i = 1; i <= str.length(); i++)
			s[i] = s[i - 1] + str.charAt(i - 1) * (p[i - 1]);

		int l = 0, r = str.length() - 1;
		int ans = 0;
		while (l <= r) {
			int mid = (l + r) / 2;
			if (check(mid, str, s, p)) {
				l = mid + 1;
				ans = mid;
			} else {
				r = mid - 1;
			}

		}
		pw.println(ans);
		pw.flush();

	}

	public static boolean check(int k, String str, long[] s, long[] p) {
		HashMap<Long, Long> map = new HashMap();
		for (int i = 0; i + k <= str.length(); i++) {
			long q = s[i + k] - s[i];
			q *= p[1000000 - i];
			if (map.containsKey(q))
				return true;
			map.put(q, q);
		}
		return false;
	}

	static class FastReader {
		BufferedReader br;
		StringTokenizer st;

		public FastReader() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() {
			while (st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(next());
		}

		long nextLong() {
			return Long.parseLong(next());
		}

		double nextDouble() {
			return Double.parseDouble(next());
		}

		String nextLine() {
			String str = "";
			try {
				str = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return str;
		}
	}

}
