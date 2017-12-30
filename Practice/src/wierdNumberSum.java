import java.util.ArrayList;
import java.util.Scanner;

public class wierdNumberSum {
	public static void main(String[] args) {

		int n = 105;
		greatNumberComputation(n);

	}

	public static void precomputation(int n) {
		ArrayList<Integer> arr = new ArrayList<>();
		int temp = 0;
		for (int i = 0; temp < n; i++) {
			temp += i;
			arr.add(temp);
		}
		int[] a = new int[arr.size()];
		for (int i = 0; i < a.length; i++)
			a[i] = arr.get(i);
		arr = null;
		countPairs(a, n);
	}

	public static void greatNumberComputation(int n) {
		ArrayList<Integer> arr = new ArrayList<>();
		int temp = 0;
		for (int i = 0; temp < n; i++) {
			temp += i * i;
			arr.add(temp);
		}
		int[] a = new int[arr.size()];
		for (int i = 0; i < a.length; i++)
			a[i] = arr.get(i);
		arr = null;
		countPairs(a, n);
	}

	public static void countPairs(int[] arr, int tar) {
		int lo = 0, hi = arr.length - 1;
		boolean check = false;
		while (lo < hi) {
			if (arr[lo] + arr[hi] == tar) {
				check = true;
				System.out.println(arr[lo] + " and " + arr[hi]);
				hi--;
			} else if (arr[lo] + arr[hi] < tar) {
				lo++;
			} else
				hi--;
		}
		if (!check)
			// if no single pair was found then check will be false
			System.out.println("No the given number is not a sum of two great numbers");
	}
}
