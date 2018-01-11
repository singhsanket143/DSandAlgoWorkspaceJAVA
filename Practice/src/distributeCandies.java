import java.util.Arrays;
import java.util.Scanner;

public class distributeCandies {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int t = scn.nextInt();
		while (t > 0) {
			int n = scn.nextInt();
			int k = scn.nextInt();
			int[] arr = new int[n];
			int max = Integer.MIN_VALUE;
			int min = Integer.MAX_VALUE;
			for (int i = 0; i < n; i++) {
				arr[i] = scn.nextInt();
				if (arr[i] > max) {
					max = arr[i];
				}
				if (arr[i] < min) {
					min = arr[i];
				}
			}
			int helper = max;
			System.out.println(distribution(arr, k, helper));
			t--;
		}

	}

	public static int distribution(int[] arr, int child, int helper) {
		Arrays.sort(arr);
		int lo = 1, hi = helper;
		int result = 0;
		while (lo <= hi) {
			int mid = (hi + lo) / 2;
			if (isValid(child, mid, arr)) {
				lo = mid + 1;
				result = mid;
			} else {
				hi = mid - 1;
			}
		}
		return result;

	}

	public static boolean isValid(long child, int ans, int[] a) {
		int t = 0;
		for (int i = 0; i < a.length; i++) {
			t = a[i];
			int k = t / ans;
			child -= k;
		}
		if (child <= 0) {
			return true;
		} else {
			return false;
		}
	}

}
