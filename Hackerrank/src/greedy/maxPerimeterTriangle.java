package greedy;

import java.util.Arrays;
import java.util.Scanner;

public class maxPerimeterTriangle {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = scn.nextInt();
		}
		Arrays.sort(arr);
		int lo = 0, hi = arr.length - 1;
		while (lo <= hi) {
			int temp = arr[lo];
			arr[lo] = arr[hi];
			arr[hi] = temp;
			lo++;
			hi--;
		}
		
		for(int i=0;i<n-2;i++) {
			if(arr[i+2]+arr[i+1]<=arr[i]) {
				continue;
			}
			System.out.println(arr[i+2]+" "+arr[i+1]+" "+arr[i]);
			return;
		}
		System.out.println("-1");
	}

}
