package Lecture8;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Arrayops {

	public static void main(String[] args) {
	//	Scanner scn=new Scanner(System.in);
		int[] arr = { 2, 1, 3, 1, 2 };
		int[] arr1 = { 10, 20, 30, 40 };
		int[] arrp=new int[1000000];
		// display(arr);
		// Swap1(arr, 0, arr.length-1);
		// display(arr);
		// bubblesort(arr);
		// selectionsort(arr);

		insertionsort(arr);
		
		// display(arr);
		// System.out.println(binarysearch(arr,5));
		//
		// System.out.println(binarysearch(arr,99));
	}

	public static void bubblesort(int[] arr) {
		int counter = 1;
		while (counter <= arr.length - 1) {
			for (int i = 0; i < arr.length - counter; i++) {
				if (arr[i + 1] < arr[i]) {
					// swap
					Swap(arr, i + 1, i);
				}

			}
			counter++;
		}
	}

	public static void Swap(int[] arr, int i, int j) {
		// System.out.println(i+"."+j);

		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;

		// System.out.println(arr[i] + ", " +arr[j]);
	}

	public static void Swap1(int[] arr, int i, int j) {
		// System.out.println(i+"."+j);

		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;

	}

	public static void display(int[] arr) {
		for (int val : arr) {
			System.out.print(val + ", ");
		}
		System.out.println("end");
	}

	public static void selectionsort(int[] arr) {
		int counter = 1;
		while (counter <= arr.length - 1) {
			for (int i = counter; i < arr.length; i++) {
				if (arr[i] < arr[counter - 1]) {
					// swap
					Swap(arr, counter - 1, i);
				}

			}
			counter++;
		}
	}

	public static void insertionsort(int[] arr) {
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
		System.out.println(c);
	}

	public static int binarysearch(int[] arr, int data) {
		int left = 0, right = arr.length - 1;
		while (left <= right) {
			int mid = (left + right) / 2;
			if (data > arr[mid]) {
				left = mid + 1;
			} else if (data < arr[mid]) {
				right = mid - 1;
			} else
				return mid;
		}
		return -1;

	}
}
