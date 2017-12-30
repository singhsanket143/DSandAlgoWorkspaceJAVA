package Lecture7;

import java.util.Scanner;

public class FunWith2dArrays {

	public static void main(String[] args) {
		 //int arr[][] = takeinput(); 
		
		 //display(arr); 
		 
		int[][] arr = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		spiral(arr);
	}

	public static int[][] takeinput() {
		Scanner scn = new Scanner(System.in);
		int[][] retval = null;
		System.out.println("enter no of rows");
		int rows = scn.nextInt();
		retval = new int[rows][];

		for (int row = 0; row < retval.length; row++) {
			System.out.println("enter col" + row + "th row");
			int cols = scn.nextInt();
			retval[row] = new int[cols];
			for (int col = 0; col < retval[row].length; col++) {
				System.out.println("enter value for col" + (row + "," + col));
				retval[row][col] = scn.nextInt();
			}
		}
		return retval;
	}

	public static void display(int[][] arr) {
		if (arr == null) {
			System.out.println("nothing");
		} else {
			System.out.println("row=" + arr.length);
			for (int row = 0; row < arr.length; row++) {
				if (arr[row] == null) {
					System.out.print("blank");
				} else {
					for (int col = 0; col < arr[row].length; col++) {
						System.out.print(arr[row][col] + "\t");
					}
				}
				System.out.println();
			}
		}
	}

	public static void wave(int[][] arr) {
		for (int col = 0; col < arr[0].length; col++) {

			if (col % 2 == 0) {
				for (int row = 0; row < arr.length; row++) {
					System.out.print(arr[row][col] + "\t");
				}
			} else {
				for (int row = arr.length - 1; row >= 0; row--) {
					System.out.print(arr[row][col] + "\t");
				}
			}
		}
	}

	public static void spiral(int[][] arr) {
		int j = arr.length * arr[0].length;
		int i = 1;
		while (i <= j) {
			int mincol = 0, minrow = 0, maxcol = arr[0].length - 1, maxrow = arr.length - 1;
			for (int row = minrow; i <= j && row <= maxrow; row++) {
				System.out.println(arr[row][mincol]);
				i++;
			}
			mincol++;
			for (int col = mincol; i <= j && col <= maxcol; col++) {
				System.out.println(arr[maxrow][col]);
				i++;
			}
			maxrow--;
			for (int row = maxrow; i <= j && row >= minrow; row--) {
				System.out.println(arr[row][maxcol]);
				i++;
			}
			maxcol--;
			for (int col = maxcol; i <= j && col >= mincol; col--) {
				System.out.println(arr[minrow][col]);
				i++;
			}
			minrow++;
		}
	}
}
