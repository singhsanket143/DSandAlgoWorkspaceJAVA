package Mathematical;

import java.util.Scanner;

public class MagicSquare {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn=new Scanner(System.in);
		int n=scn.nextInt();
		int arr[][]=new int[n][n];
		arr=magicSquare(n);
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				System.out.print(arr[i][j]+"\t");
			}
			System.out.println();
		}

	}

	public static int[][] magicSquare(int n) {
		int arr[][] = new int[n][n];
		int i = n / 2, j = n - 1;
		
		int counter = 1;
		while (counter <= n * n) {
			
			if (i == -1 && j == n) {
				i = 0;
				j = n - 2;
			} else {
				if (i == -1) {
					i = n - 1;
				}
				if (j == n) {
					j = 0;
				}
			}
			if (arr[i][j] != 0) {
				i = i + 1;
				j = j - 2;
				continue;
			} else {
				arr[i][j] = counter;
				counter++;
			}
			i = i - 1;
			j = j + 1;
		}
		return arr;
	}

}
