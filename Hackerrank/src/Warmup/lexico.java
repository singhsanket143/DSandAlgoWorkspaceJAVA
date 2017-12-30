package Warmup;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class lexico {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		abc:
		for (int i = 0; i < n; i++) {
			String str = scn.next();
			char[] arr = new char[str.length()];
			for (int j = 0; j < arr.length; j++) {
				arr[j] = str.charAt(j);
			}
			int largestI = -1, largestJ = -1;
			boolean bool = false;
			for (int j = 0; j < arr.length - 1; j++) {
				if (arr[j] != arr[j + 1]) {
					bool = true;
					break;
				}
			}
			if (bool == true) {
				for (int j = 0; j < arr.length - 1; j++) {
					if (arr[j] < arr[j + 1]) {
						largestI = j;
					}
				}
				if(largestI==-1){
					System.out.println("no answer");
					continue abc;
				}
				for (int j = 0; j < arr.length; j++) {
					if (arr[largestI] < arr[j]) {
						largestJ = j;
					}
				}
				
				
				
				String ros1 = "", ros2 = "", ros = "", result = "";

				swap(arr, largestI, largestJ);
				for (int j = 0; j < arr.length; j++) {
					ros += arr[j];
				}
				ros1 = ros.substring(0, largestI + 1);
				ros2 = ros.substring(largestI + 1);
				char[] arr1 = new char[ros2.length()];
				for (int j = 0; j < ros2.length(); j++) {
					arr1[j] = ros2.charAt(j);
				}
				Arrays.sort(arr1);
				result += ros1;
				for (int j = 0; j < arr1.length; j++) {
					result += arr1[j];
				}
				System.out.println(result);
			} else{
				System.out.println("no result");
			}

		}
	}

	public static void swap(char[] arr, int i, int j) {
		char temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

}
