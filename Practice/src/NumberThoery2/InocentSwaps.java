package NumberThoery2;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;


public class InocentSwaps{
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
		PrintWriter pw=new PrintWriter(System.out);
		int t=scn.nextInt();
		long[] fact=fact(1000007, 1000000007);
		while(t-- >0){
			int n=scn.nextInt();
			int k=scn.nextInt();
			pw.println(swapsEmotions(n, k,fact));
			pw.flush();
		}
	}
	
	public static long swapsEmotions(int n,int k,long[] f){
		long m=1000000007;
		long a=modRecursive(2, k, m);
		long b=f[n];
		long kfact=f[k];
		long c=modRecursive(kfact, m-2, m);
		long nkfact=f[n-k];
		
		long d=modRecursive(nkfact, m-2, m);
		long result=1;
		result=((result%m)*(a%m))%m;
		result=((result%m)*(b%m))%m;
		result=((result%m)*(c%m))%m;
		result=((result%m)*(d%m))%m;
		return result;
	}
	
	public static long[] fact(int n,long m){
		long result=1;
		long[] rec=new long[n+1];
		for(int i=1;i<=n;i++){
			result=((result%m)*(i%m))%m;
			rec[i]=result;
		}
		return rec;
	}

	public static long modRecursive(long a, long b, long c) {
		if (b == 0) {
			return 1;
		}
		if (b % 2 == 0) {
			return modRecursive((a * a) % c, b / 2, c);
		} else {
			return ((a % c) * (modRecursive((a * a) % c, b / 2, c))) % c;
		}
	}


}