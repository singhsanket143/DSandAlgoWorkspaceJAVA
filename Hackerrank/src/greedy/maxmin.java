package greedy;

import java.util.Arrays;
import java.util.Scanner;

public class maxmin {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int k = scn.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = scn.nextInt();
		}
		Arrays.sort(arr);
		int result = Integer.MAX_VALUE;
		if (k > n)
			for (int i = 1; i < arr.length; i++) {
				int diff = arr[i] - arr[i - 1];
				result = (result > diff) ? diff : result;
			} else 
				for(int i=k-1;i<n;i++) {
					int diff = arr[i] - arr[(i-k)+1];
					result = (result > diff )? diff : result;
				}
			
		System.out.println(result);

	}

}
