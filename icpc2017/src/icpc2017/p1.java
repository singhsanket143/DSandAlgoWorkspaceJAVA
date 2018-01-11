package icpc2017;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

public class p1 {
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

		public int nextint() throws IOException {
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

	public static void main(String[] args) throws IOException {
		Reader scn = new Reader();
		PrintWriter pw = new PrintWriter(System.out);
		int t = scn.nextInt();
		while (t-- > 0) {
			int n = scn.nextInt();
			int[] A = new int[n];
			int[] B = new int[n];
			for (int i = 0; i < n; i++) {
				A[i] = scn.nextint();
			}
			for (int i = 0; i < n; i++) {
				B[i] = scn.nextint();
			}
			System.out.println(search(A, B));
		}

		pw.flush();
	}

	public static int max(int[] A, int[] B) {
		int max = Integer.MAX_VALUE;
		int m2=Integer.MIN_VALUE;
		for (int i = 0; i < A.length; i++) {
			if (B[i]< max) {
				max = B[i];
			}
			if(A[i]%B[i]>m2){
				m2=A[i]%B[i];
			}
		}
		return max;
	}

	public static int modulo(int[] A, int[] B, int c) {
		// Arrays.sort(A);
		// Arrays.sort(B);
		// int max=Integer.MIN_VALUE;
		// for(int i=0;i<A.length;i++){
		// if(A[i]%B[i]>max){
		// max=A[i]%B[i];
		// }
		// }
		int result = 0;
		for (int i = 0; i < A.length; i++) {
			int a = A[i];
			int b = B[i];
			long x = (a + b) % b;
			if (a % b == c)
				continue;
			if (a > b) {
				if (a % b < c) {
					result += (c-(a%b));
				} else {
					long y=Math.abs(c-x);
					result += b - y;
				}
			} else if (a < b) {
				result += ((Math.abs(a - b)) + c) % b;
			}

		}
		return result;
	}

	public static int search(int[] A, int[] B) {
		int lo = Integer.MIN_VALUE, hi = max(A, B);
		for (int i = 0; i < A.length; i++) {
			
			if(A[i]%B[i]>lo){
				lo=A[i]%B[i];
			}
		}
		int numop = Integer.MAX_VALUE;
		while (lo <= hi) {
			int result = (lo + hi) / 2;

			int nresult = modulo(A, B, result);
			if (nresult < numop) {
				numop = nresult;
				lo = result + 1;
			} else {
				hi = result - 1;
			}

		}
		return numop;
	}

}
