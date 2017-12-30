package Lecture6;

import java.util.Scanner;

public class Arrays {
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		int[] arr = takeinput();
//		display(arr);
//		System.out.println(max(arr));
//		System.out.println(linearsearch(arr, 77));
//		display(arr);
//		reverse(arr);
//		display(arr);
		inverse(arr);
		display(arr);
	}

	public static int[] takeinput() {
		int[] retval = null;
		System.out.println("enter the size");
		int n = scn.nextInt();
		retval = new int[n];
		for (int i = 0; i < retval.length; i++) {
			System.out.println("enter" + i + "th element");
			;
			int data = scn.nextInt();
			retval[i] = data;
		}
		return retval;
	}

	public static void display(int[] arr) {
		for (int val : arr) {
			System.out.print(val + ", ");
		}
		System.out.println("end");
	}

	public static int max(int[] arr) {
		int g = arr[0];
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > g) {
				g = arr[i];
			}
		}
		return g;
	}

	public static int linearsearch(int[] arr, int data) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == data) {
				return i;
			}
		}

		return -1;

	}
	
	public static void reverse(int[] arr){
		int left=0,right=arr.length-1;
		while(left<=right){
			Swap(arr,left,right);
			left++;
			right--;
		}
	}
	
	public static void Swap(int[] arr,int i,int j) {
		//System.out.println(a + ", " + b);
		
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
		
		//System.out.println(arr[i] + ", " +arr[j]);
	}
	public static int[] inverse(int[]arr)
	{
		int [] a= null;
		a= new int[arr.length];
		for (int i=0;i<arr.length;i++)
		{
			a[arr[i]-1]=i+1;
		}
		return a;
	}
}
