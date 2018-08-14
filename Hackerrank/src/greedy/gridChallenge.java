package greedy;

import java.util.Arrays;
import java.util.Scanner;

public class gridChallenge {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		int t=scn.nextInt();
		while(t-- > 0) {
			int n=scn.nextInt();
			char[][] arr = new char[n][n];
			for(int i=0;i<n;i++) {
				String str=scn.next();
				for(int j=0;j<n;j++) {
					arr[i][j]=str.charAt(j);
				}
				Arrays.sort(arr[i]);
			}
			System.out.println(isValid(arr,n)?"YES":"NO");
		}
	}
	
	public static boolean isValid(char[][] arr, int n) {
		for(int i=0;i<n;i++) {
			for(int j=0;j<n-1;j++) {
				if(arr[j][i]>arr[j+1][i]) {
					return false;
				}
			}
		}
		return true;
	}

}
