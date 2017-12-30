package Backtracking;

import java.util.ArrayList;

public class TugOfwar {

	public static void main(String[] args) {

		int arr[] = { 1,2,3,4,5,6,7,8,9,10 };
		printgrouparray1(arr, 0, 0, 0, "",0, "",0, Integer.MAX_VALUE);
		String str="121314";
		

	}

	public static void printgrouparray1(int[] arr, int si, int sum1, int sum2, String osf1,int c1, String osf2,int c2, int c) {

		if (si == arr.length) {
			if (Math.abs(sum1 - sum2) <c) {
				if (c1==c2)
					System.out.println(osf1 + "---" + osf2);
			}
			return;
		}
		if (Math.abs(sum1 - sum2) < c)
			c = Math.abs(sum1 - sum2);
		printgrouparray1(arr, si + 1, sum1 + arr[si], sum2, osf1 + arr[si] + " ",c1+1, osf2,c2, c);
		printgrouparray1(arr, si + 1, sum1, sum2 + arr[si], osf1,c1, osf2 + arr[si] + " ",c2+1, c);
	}

}
