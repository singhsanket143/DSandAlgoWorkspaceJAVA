package Hack101_48;

import java.util.Scanner;

public class dreamplay {

	public static void main(String[] args) {

		Scanner scn=new Scanner(System.in);
		int q=scn.nextInt();
		int[] arr= new int[q];
		for(int i=0;i<q;i++){
			arr[i]=scn.nextInt();
		}
		long sum=0;
		//long r=18446744073709551616;
		for(int i=0;i<arr.length;i++){
			for(int j=i;j<arr.length;j++){
				int x=arr[i]-arr[j];
				sum+=Math.pow(x, 2);
			}
		}
		System.out.println(sum);
	}
	
	

}
