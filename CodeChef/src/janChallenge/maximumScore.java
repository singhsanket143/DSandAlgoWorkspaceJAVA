package janChallenge;

import java.util.Arrays;
import java.util.Scanner;

public class maximumScore {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		int t = scn.nextInt();
		while (t-- > 0) {
			int n = scn.nextInt();
			long[][] arr = new long[n][n];

			for (int i = 0; i < n; i++) {
				long[] temp = new long[n];
				for (int j = 0; j < arr.length; j++) {
					temp[j] = scn.nextLong();
				}
				Arrays.sort(temp);
				arr[i] = temp;
			}
			long[] a = {0};
			long k =maxScore(arr);
			System.out.println(k);
		}
	}

	public static long maxScore(long[][] arr) {
		long sum=0;
		int row = arr.length-1;
		for(int i = arr.length-1;i>=0;i--) {
			long candidate = arr[row][i];
			sum = candidate;
			for(int j =arr.length-2;j>=0;j--) { // upper row looping
				int k = arr.length-1;
				for(k = arr.length-1;k>=0;k--) { // col looping
					if(arr[j][k]<candidate) {
						candidate = arr[j][k];
						break;
					}
				}
				if(k!=-1)
					sum+=candidate;
				else
					break;
				if(j==0) {
					return sum;
				}
			}
			if(i==0 && arr.length!=1) {
				return -1;
			} 
		}
		return sum;
	}

}
