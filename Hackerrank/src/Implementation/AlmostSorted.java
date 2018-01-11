package Implementation;

import java.util.Scanner;

public class AlmostSorted {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
		}
		int si = 0, li = arr.length - 1, c = 0;
		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i] > arr[i + 1]) {
				si = i;
				c++;
				break;

			}
		}

		for (int i = arr.length - 1; i > si; i--) {
			if (arr[i] < arr[i - 1]) {
				li = i;
				c++;
				break;

			}
		}

		while (true) {
			if (issortedF(arr, 0, arr.length - 1)) {
				System.out.println("yes");
				break;
			} else if (issortedR(arr, 0, arr.length - 1) && arr.length != 2) {
				System.out.println("yes");
				System.out.println("reverse 0 " + (arr.length - 1));
				break;
			} else {

				boolean forward = issortedF(arr, si + 1, li - 1);
				boolean backward = issortedR(arr, si + 1, li - 1);
				if (Math.abs(si - li) >= 2) {
					if (forward == true) {
						System.out.println("yes");
						System.out.println("swap " + (si + 1) + " " + (li + 1));
						break;
					} else if (backward == true) {
						System.out.println("yes");
						System.out.println("reverse " + (si + 1) + " " + (li + 1));
						break;
					} else {
						System.out.println("no");
						break;
					}
				} else if (arr.length == 2) {
					if (issortedF(arr, si, li)) {
						System.out.println("yes");
						break;
					} else {
						System.out.println("yes");
						System.out.println("swap 1 2");
						break;
					}
				} else {
					if (arr[li + 1] < arr[si] || arr[si - 1] > arr[li]) {
						System.out.println("no");
						break;
					} else {
						System.out.println("yes");
						System.out.println("swap " + (si + 1) + " " + (li + 1));
						break;
					}
				}
			}

		}
	}

	public static boolean issortedR(int[] arr, int si, int li) {
		if (si == li)
			return true;
		if (si == arr.length - 1)
			return true;
		if (arr[si] < arr[si + 1])
			return false;
		else {
			boolean issasorted = issortedR(arr, si + 1, li);
			return issasorted;
		}
	}

	public static boolean issortedF(int[] arr, int si, int li) {
		if (si == li)
			return true;
		if (si == arr.length - 1)
			return true;
		if (arr[si] > arr[si + 1])
			return false;
		else {
			boolean issasorted = issortedF(arr, si + 1, li);
			return issasorted;
		}
	}

}
