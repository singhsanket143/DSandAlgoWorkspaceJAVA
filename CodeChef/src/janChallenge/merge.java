package janChallenge;

import java.util.Scanner;
import java.io.*;
import java.util.StringTokenizer;
 class merge {
 
	static class Reader {
		final private int BUFFER_SIZE = 1 << 16;
		private DataInputStream din;
		private byte[] buffer;
		private int bufferPointer, bytesRead;
 
		public Reader() {
			din = new DataInputStream(System.in);
			buffer = new byte[BUFFER_SIZE];
			bufferPointer = bytesRead = 0;
		}
 
		public Reader(String file_name) throws IOException {
			din = new DataInputStream(new FileInputStream(file_name));
			buffer = new byte[BUFFER_SIZE];
			bufferPointer = bytesRead = 0;
		}
 
		public String readLine() throws IOException {
			byte[] buf = new byte[64]; // line length
			int cnt = 0, c;
			while ((c = read()) != -1) {
				if (c == '\n')
					break;
				buf[cnt++] = (byte) c;
			}
			return new String(buf, 0, cnt);
		}
 
		public int nextInt() throws IOException {
			int ret = 0;
			byte c = read();
			while (c <= ' ')
				c = read();
			boolean neg = (c == '-');
			if (neg)
				c = read();
			do {
				ret = ret * 10 + c - '0';
			} while ((c = read()) >= '0' && c <= '9');
 
			if (neg)
				return -ret;
			return ret;
		}
 
		public long nextLong() throws IOException {
			long ret = 0;
			byte c = read();
			while (c <= ' ')
				c = read();
			boolean neg = (c == '-');
			if (neg)
				c = read();
			do {
				ret = ret * 10 + c - '0';
			} while ((c = read()) >= '0' && c <= '9');
			if (neg)
				return -ret;
			return ret;
		}
 
		public double nextDouble() throws IOException {
			double ret = 0, div = 1;
			byte c = read();
			while (c <= ' ')
				c = read();
			boolean neg = (c == '-');
			if (neg)
				c = read();
 
			do {
				ret = ret * 10 + c - '0';
			} while ((c = read()) >= '0' && c <= '9');
 
			if (c == '.') {
				while ((c = read()) >= '0' && c <= '9') {
					ret += (c - '0') / (div *= 10);
				}
			}
 
			if (neg)
				return -ret;
			return ret;
		}
 
		private void fillBuffer() throws IOException {
			bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
			if (bytesRead == -1)
				buffer[0] = -1;
		}
 
		private byte read() throws IOException {
			if (bufferPointer == bytesRead)
				fillBuffer();
			return buffer[bufferPointer++];
		}
 
		public void close() throws IOException {
			if (din == null)
				return;
			din.close();
		}
	}
 
	public static void main(String[] args) {
 
		FastReader scn = new FastReader();
		// Reader scn = new Reader();
		PrintWriter pw = new PrintWriter(System.out);
		int t = scn.nextInt();
		for (int iterator = 0; iterator < t; iterator++) {
			int length_of_string1 = scn.nextInt();
			int length_of_string2 = scn.nextInt();
			String string1 = scn.nextLine();
			String string2 = scn.nextLine();
			long[][][] mem = new long[string1.length() + 10][string2.length() + 10][];
			
			long result = string1.length() + string2.length() + (string1.length() * string2.length());
			long memResult1 = mergeString(1, 0, string1, string2, string1.charAt(0), mem);
			long memResult2 = mergeString(0, 1, string1, string2, string2.charAt(0), mem);
			long memresult = Math.max(memResult1, memResult2);
			result = result - memresult - (string1.length() * string2.length());
			pw.println(result);
			pw.flush();
		}
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
 
	public static long mergeString(int a, int b, String str1, String str2, char chosen, long[][][] mem) {
		if (mem[a][b]!=null &&mem[a][b][chosen - 'a'] >= 0) {
			return mem[a][b][chosen - 'a'];
		}
		if (a == str1.length()) {
			if (b == str2.length()) {
				if(mem[a][b]!=null)
					mem[a][b]=new long[26];
				mem[a][b][chosen - 'a'] = 0;
			}
		}
		if (a == str1.length()) {
			int retval = 0;
			for (int r = b; r < str2.length() - 1; r++) {
				if (str2.charAt(r) == str2.charAt(r + 1)) {
					retval = retval + 1;
				}
				// System.out.println(retval);
 
				// for(int j=1;j<=n;j++) {
				// int val = Math.max(mem[i-1][j], mem[i][j-1]);
				// if(str1.charAt(i-1)!=str2.charAt(j-1)) {
				// mem[i][j]=1+val;
				// } else {
				// mem[i][j]=val;
				// }
 
			}
			if(mem[a][b]!=null)
				mem[a][b]=new long[26];
			mem[a][b][chosen - 'a'] = (str2.charAt(b) != chosen) ? (retval) : (++retval);
			return mem[a][b][chosen - 'a'];
		}
		if (b == str2.length()) {
			int retval = 0;
			for (int r = b; r < str1.length() - 1; r++) {
				if (str1.charAt(r) == str1.charAt(r + 1)) {
					retval = retval + 1;
					// System.out.println(retval);
				}
			}
			if(mem[a][b]!=null)
				mem[a][b]=new long[26];
			mem[a][b][chosen - 'a'] = (str1.charAt(a) != chosen) ? (retval) : (++retval);
			return mem[a][b][chosen - 'a'];
		}
 
		long val1 = mergeString(a + 1, b, str1, str2, str1.charAt(a), mem);
		long val2 = mergeString(a, b + 1, str1, str2, str2.charAt(b), mem);
		val1 = (chosen != str1.charAt(a)) ? (val1) : (++val1);
		val2 = (chosen != str2.charAt(b)) ? (val2) : (++val2);
 
		if(mem[a][b]!=null)
			mem[a][b]=new long[26];
		mem[a][b][chosen - 'a'] = Math.max(val2, val1);
		return mem[a][b][chosen - 'a'];
	}
 
	public static int mergeString1(int m, int n, String str1, String str2) {
		int[][] mem = new int[m + 1][n + 1];
		for (int i = 0; i <= m; i++) {
			mem[i][0] = 1;
		}
		for (int i = 0; i <= n; i++) {
			mem[0][i] = 1;
		}
 
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				int val = Math.max(mem[i - 1][j], mem[i][j - 1]);
				if (str1.charAt(i - 1) != str2.charAt(j - 1)) {
					mem[i][j] = 1 + val;
				} else {
					mem[i][j] = val;
				}
			}
		}
 
		return mem[m][n];
	}
 
}