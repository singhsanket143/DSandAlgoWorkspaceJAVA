package Sorting;

import java.util.Scanner;

public class CountingSort2 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] count = new int[100];
		StringBuilder[] str=new StringBuilder[100];
		//StringBuilder k=new StringBuilder();
		
		for(int i=0;i<str.length;i++){
			str[i]=new StringBuilder();
			str[i].append("");
		}
		
		//String str = "";
		for (int i = 0; i < n; i++) {
			int check=scn.nextInt();
			count[check]++;
			//arr[i] = scn.nextInt();
			
			String c=scn.next();
			if(i<n/2){
				str[check].append("- ");}
			else
				str[check].append(c+" ");
		}
		countingsort4(count,str);

	}
	
	public static void countingsort(int[] arr) {
		int[] count = new int[100];
		for (int i = 0; i < arr.length; i++) {
			count[arr[i]]++;
		}
		for (int i = 0; i < count.length; i++) {

			System.out.print(count[i] + " ");
			// count[i]--;

		}
	}

	public static void countingsort2(int[] arr) {
		int[] count = new int[100];
		for (int i = 0; i < arr.length; i++) {
			count[arr[i]]++;
		}
		for (int i = 0; i < count.length; i++) {
			while (count[i] > 0) {
				System.out.print(i + " ");
				count[i]--;
			}
		}
	}
	public static void countingsort4(int[] count,StringBuilder[] str) {
//		int[] count = new int[100];
//		for (int i = 0; i < arr.length; i++) {
//			count[arr[i]]++;
//		}
		for (int i = 0; i < count.length; i++) {
			if(count[i]>0){
				System.out.print(str[i]);
			}
		}
	}

	public static void countingsort3(int[] arr) {
		int[] count = new int[100];
		for (int i = 0; i < arr.length; i++) {
			count[arr[i]]++;
		}
		int sum = 0;
		for (int i = 0; i < count.length; i++) {
			sum += count[i];
			System.out.print(sum + " ");
			// count[i]--;

		}
	}

}
