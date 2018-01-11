package ArrayWorkshop;

import java.util.ArrayList;

public class pigeonHoleSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = { 8, 3, 2, 7, 4, 6, 8 };
		pigeonHoleSort(arr, 8, 2);
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}

	public static void pigeonHoleSort(int[] arr, int max, int min) {
		int range = max - min + 1;
		int j = 0;
		int[][] auxarr = new int[range][range];
		for (int i = 0; i < arr.length; i++) {
			int temp = arr[i] - min;
			j = 0;
			while (auxarr[arr[i] - min][j] > 0) {
				j++;
			}
			auxarr[arr[i] - min][j] = arr[i];
		}
		int iterator = 0;
		for (int i = 0; i < auxarr.length; i++) {
			j = 0;

			while (auxarr[i][j] > 0) {
//				int var = auxarr[i][j] - min;
				arr[iterator] = auxarr[i][j];
				iterator++;
				j++;
			}
		}
	}

}
