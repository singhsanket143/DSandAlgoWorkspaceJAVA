package Lecture19;

import java.util.Random;

public class tnsdemos {

	public static void main(String[] args) {

		String s1 = "aa";
		String s2 = "a";
		// init();
		// System.out.println(lcs(s1, s2));
		// System.out.println(duration());
		// init();
//		 System.out.println(lcprefixbtr(s1, s2,new
//		 int[s1.length()+1][s2.length()+1]));
		// System.out.println(duration());
		// init();
		// System.out.println(editdistance(s1, s2));
		// System.out.println("duration is "+duration());
		// init();
//		 System.out.println(editdistancebtr(s1, s2,new
//		 int[s1.length()+1][s2.length()+1]));
		// System.out.println("duration is "+duration());
//		int n = 28;
		int[] val = {10,5,11};
		int[] wts = {5,2,3};
		int tw =5;
//		Random random = new Random();
//		for (int i = 0; i < val.length; i++) {
//			val[i] = random.nextInt(100);
//			wts[i] = random.nextInt(n);
//
//		}
//		init();
		int[][] strg=new int[tw + 1][val.length];
		System.out.println(knapsackbtr(val, wts, tw, 0, strg));
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				System.out.print(strg[i][j]+", ");
			}
			System.out.println();
		}
//		System.out.println("duration is " + duration());
//		init();
//		System.out.println(knapsack(val, wts, tw, 0));
//		System.out.println("duration is " + duration());
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

	public static int countSubsetTarget(int[] arr, int si, int tar, String osf) {
		if (si == arr.length) {
			if (tar == 0) {
				System.out.println(osf + "END");
				return 1;
			} else {
				return 0;
			}
		}

		int count = 0;

		count += countSubsetTarget(arr, si + 1, tar - arr[si], osf + arr[si] + ", ");
		count += countSubsetTarget(arr, si + 1, tar - 0, osf);

		return count;
	} 
	public static int lcprefixbtr(String s1, String s2, int[][] storage) {
		int rv = 0;
		if(s1.length()==0 || s2.length()==0 )
			return 0;
		if (s1.length()!=0 && s2.length()!=0 && s1.charAt(0) != s2.charAt(0)) {
			return 0;
		}
		if (storage[s1.length()][s2.length()] != 0)
			return storage[s1.length()][s2.length()];
		if (s1.length()!=0 && s2.length()!=0 && s1.charAt(0) == s2.charAt(0)) {
			rv = 1 + lcprefixbtr(s1.substring(1), s2.substring(1), storage);
		} else {
			int f1 = lcprefixbtr(s1, s2.substring(1), storage);

			int f2 = lcprefixbtr(s1.substring(1), s2, storage);
			rv = Math.max(f1, f2);
		}
		storage[s1.length()][s2.length()] = rv;
		return rv;
	}


	public static int lcsbtr(String s1, String s2, int[][] storage) {
		int rv = 0;
		if (s1.length() == 0 || s2.length() == 0) {
			return 0;
		}
		if (storage[s1.length()][s2.length()] != 0)
			return storage[s1.length()][s2.length()];
		if (s1.charAt(0) == s2.charAt(0)) {
			rv = 1 + lcsbtr(s1.substring(1), s2.substring(1), storage);
		} else {
			int f1 = lcsbtr(s1, s2.substring(1), storage);

			int f2 = lcsbtr(s1.substring(1), s2, storage);
			rv = Math.max(f1, f2);
		}
		storage[s1.length()][s2.length()] = rv;
		return rv;
	}

	public static int editdistance(String s1, String s2) {
		int rv = 0;
		if (s1.length() == 0)
			return s2.length();

		if (s2.length() == 0)
			return s1.length();
		if (s1.charAt(0) == s2.charAt(0)) {
			rv = editdistance(s1.substring(1), s2.substring(1));
		} else {
			int remove = 1 + editdistance(s1.substring(1), s2.substring(1));
			int add = 1 + editdistance(s1.substring(1), s2);
			int delete = 1 + editdistance(s1, s2.substring(1));
			rv = Math.min(remove, Math.min(add, delete));
		}

		return rv;
	}

	public static int editdistancebtr(String s1, String s2, int[][] storage) {
		int rv = 0;
		if (s1.length() == 0)
			return s2.length();

		if (s2.length() == 0)
			return s1.length();
		if (storage[s1.length()][s2.length()] != 0)
			return storage[s1.length()][s2.length()];
		if (s1.charAt(0) == s2.charAt(0)) {
			rv = editdistancebtr(s1.substring(1), s2.substring(1), storage);
		} else {
			int remove = 1 + editdistancebtr(s1.substring(1), s2.substring(1), storage);
			int add = 1 + editdistancebtr(s1.substring(1), s2, storage);
			int delete = 1 + editdistancebtr(s1, s2.substring(1), storage);
			rv = Math.min(remove, Math.min(add, delete));
		}
		storage[s1.length()][s2.length()] = rv;
		return rv;
	}

	public static int knapsack(int[] vals, int[] wts, int tw, int si) {
		int rv = 0;
		if (si == vals.length)
			return 0;

		if (tw >= wts[si]) {
			// leave or use
			int leave = knapsack(vals, wts, tw, si + 1);
			int use = vals[si] + knapsack(vals, wts, tw - wts[si], si + 1);
			rv = Math.max(leave, use);
		} else {
			// leave
			rv = knapsack(vals, wts, tw, si + 1);
		}
		return rv;
	}

	public static int knapsackbtr(int[] vals, int[] wts, int tw, int si, int[][] storage) {
		int rv = 0;
		if (si == vals.length)
			return 0;
		if (storage[tw][si] != 0)
			return storage[tw][si];
		if (tw >= wts[si]) {
			// leave or use
			int leave = knapsackbtr(vals, wts, tw, si + 1, storage);
			int use = vals[si] + knapsackbtr(vals, wts, tw - wts[si], si + 1, storage);
			rv = Math.max(leave, use);
		} else {
			// leave
			rv = knapsackbtr(vals, wts, tw, si + 1, storage);
		}
		storage[tw][si] = rv;
		return rv;

	}
}
