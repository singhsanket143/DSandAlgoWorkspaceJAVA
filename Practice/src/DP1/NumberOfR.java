package DP1;

import java.util.Scanner;

public class NumberOfR {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int t = scn.nextInt();
		while (t-- > 0) {
			String str = scn.next();
			
			int[] arr = new int[str.length()];
			
			for (int i = 0; i < str.length(); i++) {
				arr[i] = (str.charAt(i) == 'R') ? -1 : 1;
			}
			int result=0;
			int[] r = printmaxSubarray(arr);
			for(int i=0;i<r.length;i++){
				if(r[i]==-1)
					result++;
			}
			System.out.println(result);
		}
	}

	public static int maxSubarray(int[] arr) {
		int max = 0, ending = 0;
		for (int i = 0; i < arr.length; i++) {
			ending += arr[i];
			if (ending < 0) {
				ending = 0;
			} else if (max < ending) {
				max = ending;
			}
		}
		return max;
	}

	public static int[] printmaxSubarray(int[] arr) {
		int max = 0, ending = 0, si = 0, li = 0;
		int[] a = new int[2];
		for (int i = 0; i < arr.length; i++) {
			ending += arr[i];
			if (ending <= 0) {
				ending = 0;
				si = i + 1;
				li = i + 1;
			} else if (max < ending) {
				max = ending;
				li = i;
				a[0]=si;
				a[1]=li;
			}
		}
		
		
		
		for(int i=a[0];i<=a[1];i++){
			arr[i]=(arr[i]==1)?-1:1;
		}
		
		return arr;
	}

}
