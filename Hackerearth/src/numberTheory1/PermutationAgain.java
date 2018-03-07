package numberTheory1;

import java.io.PrintWriter;
import java.util.Scanner;

public class PermutationAgain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scn = new Scanner(System.in);
		
		int t = scn.nextInt();
		while (t-- > 0) {
			int n = scn.nextInt();
			if (n == 1) {
				System.out.println(1);
				continue;
			}
			System.out.println(permutation(n));
		}

	}

	public static long permutation(int n) {
		int[] arr = new int[n + 1];
		int left = 1, right = n;
		int i = 2;
		while (left <= right) {
			if (n % 2 == 0 && i == n) {
				arr[1] = left;
				arr[i] = right;
				break;
			} else if (n % 2 != 0 && i == n - 1) {
				arr[1] = left;
				if (n % 2 != 0) {
					arr[i] = right;
				}
				arr[i + 1] = ++left;
				break;
			}
			arr[i] = right;
			if ((i + 1) <= n) {
				arr[i + 1] = left;
			}

			left++;
			right--;
			i = i + 2;
		}
		long ans = 0;
		for (int j = 1; j < n; j++) {
			ans += Math.abs(arr[j] - arr[j + 1]);
		}
		return ans;
	}

}
