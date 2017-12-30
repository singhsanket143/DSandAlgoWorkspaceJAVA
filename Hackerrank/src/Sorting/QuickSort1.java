package Sorting;

import java.util.ArrayList;
import java.util.Scanner;

public class QuickSort1 {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();

		int[] arr = new int[n];
		int[] a1=new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = scn.nextInt();
		}
		for (int i = 0; i < n; i++) {
			a1[i] = arr[i];
		}

		quicksort(arr, 0, arr.length - 1);
		int c=insertionsort(a1);
		System.out.println(c);

	}

	public static void display(int[] arr) {
		for (int val : arr) {
			System.out.print(val + " ");
		}
		System.out.println();
	}
	public static void quicksort(int[] arr, int low, int high) {
		if (low < high) {
			int pi = partition(arr, low, high);
			//display(arr);
			quicksort(arr, low, pi - 1);
			quicksort(arr, pi + 1, high);
		}
	}
	public static int s=0;
	public static int partition(int[] arr, int lo, int hi) {
		int pivot = arr[hi];
		int i = (lo - 1);
		for (int j = lo; j <= hi - 1; j++) {
			if (arr[j] <= pivot) {
				i++;
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				s++;
			}
		}

		int temp = arr[i + 1];
		arr[i + 1] = arr[hi];
		arr[hi] = temp;
		s++;
		
		return i + 1;
	}
	public static int insertionsort(int[] arr) {
		int n = arr.length;
		int c=0;
//		for (int i = 0; i < arr.length; i++) {
//			System.out.print(arr[i] + " ");
//		}
//		System.out.println();
		for (int i = 1; i < n; ++i) {
			int key = arr[i];
			int j = i - 1;

			/*
			 * Move elements of arr[0..i-1], that are greater than key, to one
			 * position ahead of their current position
			 */
			boolean bool = false;
			while (j >= 0 && arr[j] > key) {
				 arr[j+1] = arr[j];
				j = j - 1;
				bool = true;
                c++;
			}
			arr[j + 1] = key;
//			if (bool) {
//				for (int m = 0; m < arr.length; m++) {
//					System.out.print(arr[m] + " ");
//				}
//				System.out.println();
				
//			}
		}
		return c;
	}

}
