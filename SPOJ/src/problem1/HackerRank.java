package problem1;

import java.io.*;
import java.util.*;

public class HackerRank {

	static class FastReader {
		BufferedReader br;
		StringTokenizer st;

		public FastReader(InputStream in) {
			br = new BufferedReader(new InputStreamReader(in));
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

	public static void main(String[] args) throws Exception {
		
		Scanner scn = new Scanner(System.in);
		int k = scn.nextInt();
		for (int j = 0; j < k; j++) {
			int n = scn.nextInt();

			int[] arr = new int[n];
			int min = Integer.MAX_VALUE;

			for (int i = 0; i < arr.length; i++) {
				arr[i] = scn.nextInt();
				if (arr[i] < min) {
					min = arr[i];
				}
			}

			for (int i = arr.length / 2 - 1; i >= 0; i--) {
				downHeapify(arr, i, arr.length);
			}

			int counter = 0;
			while (arr[0] - min != 0) {
				int delta = arr[0] - min;

				if (delta == 1) {
					arr[0] = arr[0] - 1;
				} else if (delta >= 2 && delta <= 4) {
					arr[0] = arr[0] - 2;
				} else {
					arr[0] = arr[0] - 5;
				}

				downHeapify(arr, 0, arr.length);
				counter++;
			}

			System.out.println(counter);
		}
	}

//	public static int editElements(Integer[] maxH, int min) {
//
//		int delta = maxH[0] - min;
//
//		if (delta == 0) {
//			return 0;
//		} else if (delta == 1) {
//			maxH[0] = maxH[0] - 1;
//			downHeapify(maxH, 0, maxH.length);
//
//			return 1 + editElements(maxH, min);
//		} else if (delta >= 2 && delta <= 4) {
//			maxH[0] = maxH[0] - 2;
//			downHeapify(maxH, 0, maxH.length);
//
//			return 1 + editElements(maxH, min);
//		} else {
//			maxH[0] = maxH[0] - 5;
//			downHeapify(maxH, 0, maxH.length);
//
//			return 1 + editElements(maxH, min);
//		}
//
//	}

	public static void downHeapify(int[] arr, int pi, int lp) {
		int lci = 2 * pi + 1;
		int rci = 2 * pi + 2;
		int mi = pi;
		if (lci < lp && arr[lci] > arr[mi]) {
			mi = lci;
		}
		if (rci < lp && arr[rci] > arr[mi]) {
			mi = rci;
		}
		if (mi != pi) {
			int temp = arr[mi];
			arr[mi] = arr[pi];
			arr[pi] = temp;
			downHeapify(arr, mi, lp);
		}
	}

	public static int editelements(int[] arr, int delta, int[] stg) {
		Arrays.sort(arr);
		delta = arr[arr.length - 1] - arr[0];

		if (delta == 0) {
			return 0;
		}
		int counter = 0;
		if (delta == 1) {
			arr[arr.length - 1] -= 1;
			counter = 1 + editelements(arr, delta - 1, stg);
		} else if (delta > 1 && delta < 5) {
			arr[arr.length - 1] -= 2;

			counter = 1 + editelements(arr, delta - 2, stg);
		} else if (delta >= 5) {
			arr[arr.length - 1] -= 5;

			counter = 1 + editelements(arr, delta - 5, stg);
		}

		return counter;
	}

}
