package Searching;

import java.util.Scanner;

public class IceCreamParlour {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		int t = scn.nextInt();
		while (t > 0) {
			int sum = scn.nextInt();
			int n = scn.nextInt();
			int[] arr = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = scn.nextInt();
			}
			for (int i = 0; i < arr.length - 1; i++) {
				int x = arr[i];
				boolean bool = false;
				for (int j = i + 1; j < arr.length; j++) {
					if (x + arr[j] == sum) {
						bool = true;
						System.out.println((i+1)+" "+(j+1));
						break;
					}

				}
				if(bool){
					break;
				}
			}
			t--;
		}
	}

}
