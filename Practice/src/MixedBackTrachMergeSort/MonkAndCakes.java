package MixedBackTrachMergeSort;

import java.util.Scanner;

public class MonkAndCakes {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		int t = scn.nextInt();
		while (t-- > 0) {
			int n = scn.nextInt();
			int m = scn.nextInt();
			int[] capacity = new int[m];
			for (int i = 0; i < m; i++) {
				capacity[i] = scn.nextInt();
			}
			int[] weight = new int[n];
			for (int i = 0; i < n; i++) {
				weight[i] = scn.nextInt();
			}
			int[] cake = new int[n];
			for (int i = 0; i < n; i++) {
				cake[i] = scn.nextInt();
			}
		}
	}

}
