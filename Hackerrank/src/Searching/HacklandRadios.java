package Searching;

import java.util.Arrays;
import java.util.Scanner;

public class HacklandRadios {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int k = scn.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = scn.nextInt();
		}
		Arrays.sort(arr);
		int m = (2 * k) + 1;
		int c = 0;
		int j = n;
		for (int i = 0; i < arr.length;i++) {
			if(arr.length-i<m){
				c++;
				break;
			}
			if(i%m==0){
				c++;
			}

		}
		System.out.println(c);
	}

}
