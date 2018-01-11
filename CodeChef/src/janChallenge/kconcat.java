package janChallenge;

import java.util.Scanner;

public class kconcat {

	public static int[] range=new int[4];
	public static long[] range2=new long[4];
	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		int t = scn.nextInt();
		while (t-- > 0) {
			int n = scn.nextInt();
			int k = scn.nextInt();
			int[] a = new int[n];
			for (int i = 0; i < a.length; i++) {
				a[i] = scn.nextInt();
			}
			if (isPositive(a)) {
				System.out.println(k * maxSubarray(a));
			} else if (isnegative(a)) {
				System.out.println(maxSubarray(a));
			} else {

				if(k==1) {
					System.out.println(maxSubarray(a));
					continue;
				}
				int[] arr = new int[2 * a.length];
				int[] arr2=new int[3*a.length];
				for (int i = 0; i < arr.length; i++) {
					arr[i] = a[i % a.length];
				}
				for (int i = 0; i < arr2.length; i++) {
					arr2[i] = a[i % a.length];
				}
				long one = 0;
				 long two=maxSubarray(arr);
				 long three=maxSubarray(a);
				 long four = maxSubarray(arr2);
//				 System.out.println(three);
				 if(two==three) {
					 System.out.println(three);
					 continue;
				 }
				 long val=four-two;
				 one+=two;
				for(int i=2;i<k;i++) {
					one+=val;
				}
				System.out.println(one);
			}
		}

	}

	public static boolean isnegative(int[] arr) {
		boolean result = true;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] < 0) {
				result = true;
				continue;
			} else {
				result = false;
				break;
			}
		}
		return result;
	}

	public static boolean isPositive(int[] arr) {
		boolean result = true;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > 0) {
				result = true;
				continue;
			} else {
				result = false;
				break;
			}
		}
		return result;
	}

	public static void printmaxSubarray(int[] arr) {
		int max = 0, ending = 0, si = 0, li = 0;
		for (int i = 0; i < arr.length; i++) {
			ending += arr[i];
			if (ending < 0) {
				ending = 0;
				si = i + 1;
			} else if (max < ending) {
				max = ending;
				li = i;
				range[0] = si;
				range[1] = li;
			}
		}
//		range = new long[4];
//		for (int i = si; i <= li; i++) {
//			System.out.print(arr[i] + " ");
//		}
		long sum1 = 0, sum2 = 0;
		
		for (int i = range[1]+ 1; i < arr.length; i++) {
			sum1 += arr[i];
		}
		for (int i = range[0]- 1; i >= 0; i--) {
			sum2 += arr[i];
		}
		range2[2] = sum1;
		range2[3] = sum2;
//		System.out.println(range[0] + "," + range[1] + "," + range[2] + "," + range[3]);
	}

	public static long maxSubarray(int[] arr) {
		long max = 0, ending = 0;
		for (int i = 0; i < arr.length; i++) {
			ending += arr[i];
			if (ending < 0) {
				ending = 0;
			} else if (max < ending) {
				max = ending;
			}
		}
		if (max <= 0) {
			long m = Long.MIN_VALUE;
			for (int i = 0; i < arr.length; i++) {
				if (arr[i] > m)
					m = arr[i];
			}
			return m;
		}
		return max;
	}

}
