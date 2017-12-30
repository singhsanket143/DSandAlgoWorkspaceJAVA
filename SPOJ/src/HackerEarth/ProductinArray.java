package HackerEarth;

import java.util.Scanner;

public class ProductinArray {

	public static void main(String[] args) {
		 Scanner scn=new Scanner(System.in);
	       int n=scn.nextInt();
	       long[] arr=new long[n];
	       for(int i=0;i<n;i++){
	           long data=scn.nextLong();
	           arr[i]=data;
	       }
	       double f=1;
	       for(int i=0;i<arr.length;i++){
	           f= ((f*arr[i])%((Math.pow(10,9))+7));
	       }
	       System.out.println((int)f);
	}

}
