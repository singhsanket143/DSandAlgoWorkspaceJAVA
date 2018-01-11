package Lecture18;

import java.util.Scanner;

public class dynamicprogramming {

	public static void main(String[] args) {
		//int N = 55000;
		
		//System.out.println(lcs("SHINCHAN", "NOHARAAA"));
		//printprimesoe(10);
		Scanner scn=new Scanner(System.in);
		String str=scn.next();
		System.out.println(str.length());
//		 init();
//		 getConcatenatedValsBtr(N);
//		 System.out.println(duration());
//		 System.out.println("**********");
//		 init();
//		 printprimesoe(100000000);
//		 System.out.println(duration());

//		init();
//		System.out.println(FibBtr(N, new int[N + 1]));
////		System.out.println(duration());
//		System.out.println("**************");
//		init();
//		System.out.println(Fib(N));
//		System.out.println(duration());

		// .init();
		// System.out.println(countBoardPathsBtr(N, 0, new int[N + 1]));
		// System.out.println( .duration());
		//
		// .init();
		// System.out.println(countBoardPaths(N, 0));
		// System.out.println( .duration());

		// .init();
		// System.out.println(countMazePathBtr(N, N, 0, 0, new int[N + 1][N +
		// 1]));
		// System.out.println( .duration());
		//
		// .init();
		// System.out.println(countMazePath(N, N, 0, 0));
		// System.out.println( .duration());
		init();
		System.out.println(maxfreqchar(str));
		System.out.println(duration());
		init();
		System.out.println(mfcha(str));
		System.out.println(duration());
	}
	public static char mfcha(String s) {
		int count = 1;
		int max = 0;
		char maxchar = 'a';
		
		for (int counter = 0; counter < s.length(); counter++) {
			count = 1;
			
			for (int i = counter + 1; i < s.length(); i++) {
				
				if (s.charAt(counter) == s.charAt(i)) {
					count++;
				}
				
			}
			
			if (count >= max) {
				max = count;
				maxchar = s.charAt(counter);
			}
			
		}
		
		return maxchar;
	}
	public static char maxfreqchar(String str) {
		int[] cap = new int[26];
		int[] small = new int[26];
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if (ch >= 65 && ch <= 90)
				cap[ch - 'A']++;
			else if (ch >= 97 && ch <= 122)
				small[ch - 'a']++;
		}
		int max = -1;
		char result = ' ';
		for (int i = 0; i < cap.length; i++) {
			if (cap[i] > max) {
				max = cap[i];
				result = (char) (i + 65);
			}
		}
		for (int i = 0; i < small.length; i++) {
			if (small[i] > max) {
				max = small[i];
				result = (char) (i + 97);
			}
		}
		return result;
	}

	public static String getConcatenatedVals(int N) {
		String rv = "";

		for (int i = 0; i <= N; i++) {
			rv = rv + i + "\n";
		}

		return rv;
	}

	public static String getConcatenatedValsBtr(int N) {
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i <= N; i++) {
			sb.append(i);
			sb.append('\n');
		}

		return sb.toString();
	}

	public static int Fib(int n) {
		if (n == 0 || n == 1) {
			return n;
		}

		int fibnm1 = Fib(n - 1);
		int fibnm2 = Fib(n - 2);
		int fibn = fibnm1 + fibnm2;

		return fibn;
	}

	public static int FibBtr(int n, int[] storage) {
		if (n == 0 || n == 1) {
			return n;
		}

		if (storage[n] != 0) {
			return storage[n];
		}

		int fibnm1 = FibBtr(n - 1, storage);
		int fibnm2 = FibBtr(n - 2, storage);
		int fibn = fibnm1 + fibnm2;
		storage[n] = fibn;

		return storage[n];
	}

	public static int countBoardPaths(int end, int current) {
		if (current == end) {
			return 1;
		}

		if (current > end) {
			return 0;
		}

		int myResult = 0;

		for (int dice = 1; dice <= 6; dice++) {
			int recResult = countBoardPaths(end, current + dice);
			myResult += recResult;
		}

		return myResult;
	}

	public static int countBoardPathsBtr(int end, int current, int[] storage) {
		if (current == end) {
			return 1;
		}

		if (current > end) {
			return 0;
		}


		int myResult = 0;

		for (int dice = 1; dice <= 6; dice++) {
			int recResult = countBoardPathsBtr(end, current + dice, storage);
			myResult += recResult;
		}

		storage[current] = myResult;
		return myResult;
	}

	public static int countMazePath(int er, int ec, int cr, int cc) {
		if (cr == er && cc == ec) {
			return 1;
		}

		if (cr > er || cc > ec) {
			return 0;
		}

		int count = 0;

		count += countMazePath(er, ec, cr + 1, cc);
		count += countMazePath(er, ec, cr, cc + 1);

		return count;
	}

	public static int countMazePathBtr(int er, int ec, int cr, int cc, int[][] storage) {
		if (cr == er && cc == ec) {
			return 1;
		}

		if (cr > er || cc > ec) {
			return 0;
		}

		if (storage[cr][cc] != 0) {
			return storage[cr][cc];
		}

		int count = 0;

		count += countMazePathBtr(er, ec, cr + 1, cc, storage);
		count += countMazePathBtr(er, ec, cr, cc + 1, storage);

		storage[cr][cc] = count;
		return count;
	}

	public static long startTime = 0;
	public static long endTime = 0;

	public static void init() {
		startTime = System.currentTimeMillis();
	}

	public static long duration() {
		endTime = System.currentTimeMillis();
		return endTime - startTime;
	}

	public static int lcs(String s1, String s2) {
		int rv = 0;
		if (s1.length() == 0 || s2.length() == 0) {
			return 0;
		}
		if (s1.charAt(0) == s2.charAt(0)) {
			rv = 1 + lcs(s1.substring(1), s2.substring(1));
		} else {
			int f1 = lcs(s1, s2.substring(1));

			int f2 = lcs(s1.substring(1), s2);
			rv = Math.max(f1, f2);
		}
		return rv;
	}

	public static void printprimesoe(int n) {
		boolean[] primes = new boolean[n + 1];
		for (int i = 0; i < primes.length; i++) {
			primes[i] = true;
		}
		for (int div = 2; div * div < n; div++) {
			if (primes[div]) {
				for (int multiple = 2; div * multiple <= n; multiple++) {
					primes[div * multiple] = false;
				}
			}
		}
		for (int i = 2; i < primes.length; i++) {
			if (primes[i])
				System.out.println(i);
		}
	}
}
