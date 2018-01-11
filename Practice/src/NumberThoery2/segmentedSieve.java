package NumberThoery2;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class segmentedSieve {

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

		Reader s = new Reader();
		int t = s.nextInt();
		
		ArrayList<Integer> sieve = sieve();
		while (t > 0) {
			t--;
			int l = s.nextint();
			int r = s.nextint();
			printPrimes(l, r,sieve);
		}
	}

	public static void printPrimes(long l, long r) {
		boolean[] isprime = new boolean[(int) (r - l + 1)];
		PrintWriter pw=new PrintWriter(System.out);
		for (int i = 0; i < isprime.length; i++) {
			isprime[i] = true;
		}
		for (long i = 2;i * i <= r; i++) {
			
				for(long multiple=Math.max(i*i, (l+(i-1))/i*i);multiple<=r;multiple+=i){
					isprime[(int) (multiple-l)]=false;
				}
			
		}
		for(long i=l;i<=r;i++){
			if(isprime[(int)(i-l)]){
				pw.println(i);
			}
		}
		pw.flush();
	}

	public static void printPrimes(long l, long r, ArrayList<Integer> sieve) {
		boolean[] isPrime = new boolean[(int) (r - l + 1)];
		PrintWriter pw=new PrintWriter(System.out);
		for (int i = 0; i < isPrime.length; i++) {
			isPrime[i] = true;
		}
		for (int i = 0; sieve.get(i) * sieve.get(i) <= r; i++) {
			int currPrime = sieve.get(i);
			long base = (l / currPrime) * (currPrime);
			if (base < l)
				base += currPrime;
			for (long j = base; j <= r; j += currPrime) {
				isPrime[(int) (j - l)] = false;
			}
			if (base == currPrime) {
				isPrime[(int) (base - l)] = true;
			}
		}

		for (long i = l; i <= r; i++) {
			if (isPrime[(int) (i - l)]) {
				pw.println(i);
			}
		}
		pw.flush();
	}

	public static ArrayList<Integer> sieve() {
		boolean[] arr = new boolean[100001];
		for (int i = 0; i < 100001; i++) {
			arr[i] = true;
		}
		for (int i = 2; i * i < 100001; i++) {
			if (arr[i]) {
				for (int multiple = 2; i * multiple < 100001; multiple++) {
					arr[i * multiple] = false;
				}
			}
		}
		ArrayList<Integer> result = new ArrayList<>();
		for (int i = 2; i < arr.length; i++) {
			if (arr[i]) {
				result.add(i);
			}
		}
		return result;
	}
}
