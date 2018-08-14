package TwoPointer;

import java.util.Scanner;

public class ArnavAndBooks {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int k = scn.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = scn.nextInt();
		}
		System.out.println(books(arr, k));

	}

	public static int books(int[] arr, int t) {
		int left = 0, ans = 0, sum = 0, current = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
			current++;
			while (sum > t) {
				current--;
				sum -= arr[left];
				left++;
			}
			ans = Math.max(ans, current);
		}
		return ans;
	}

}
