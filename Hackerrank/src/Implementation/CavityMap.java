package Implementation;

import java.util.Scanner;

public class CavityMap {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[][] arr = new int[n][n];
		for (int i = 0; i < arr.length; i++) {
			String str = scn.next();
			for (int j = 0; j < arr[0].length; j++) {
				arr[i][j] = str.charAt(j) - '0';
			}
		}
		boolean bool = false;
		for (int i = 1; i < arr.length - 1; i++) {
			for (int j = 1; j < arr[0].length - 1; j++) {
				if (Math.abs(arr[i][j]) > Math.abs(arr[i][j + 1]) && Math.abs(arr[i][j]) > Math.abs(arr[i][j - 1])
						&& Math.abs(arr[i][j]) > Math.abs(arr[i + 1][j])
						&& Math.abs(arr[i][j]) > Math.abs(arr[i - 1][j])) {
					int data=arr[i][j];
					arr[i][j] = -1*data;
				}
			}
		}
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				if (arr[i][j] < 0) {
					System.out.print("X");
				} else {
					System.out.print(Math.abs(arr[i][j]));
				}
			}
			System.out.println();
		}
	}

}
