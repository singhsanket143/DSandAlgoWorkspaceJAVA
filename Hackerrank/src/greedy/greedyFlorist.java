package greedy;

import java.util.Arrays;
import java.util.Scanner;

public class greedyFlorist {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int k = scn.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = scn.nextInt();
		}
		Arrays.sort(arr);
		int ans = 0;
		int purchaseRound = 0;
		for (int i = arr.length - 1; i >= 0;) {
			int m = k;
			while (m-- > 0 && i >= 0) {
				ans = ans + (purchaseRound + 1) * arr[i];
				i--;
			}
			purchaseRound++;
		}
		System.out.println(ans);
	}

}
