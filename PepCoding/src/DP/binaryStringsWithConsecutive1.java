package DP;

public class binaryStringsWithConsecutive1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(countstrings(4));
	}

	public static int countstrings(int n) {
		int[] a = new int[n];
		int[] b = new int[n];
		a[0] = 1;
		b[0] = 1;
		for (int i = 1; i < n; i++) {
			a[i] = a[i - 1] + b[i - 1];
			b[i] = a[i - 1];
		}
		return a[n - 1] + b[n - 1];
	}

}
