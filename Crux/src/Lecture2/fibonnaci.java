package Lecture2;

import java.util.Scanner;

public class fibonnaci {

	public static void main(String[] args) {
		int a=0,b=1,sum=0;
		Scanner scn=new Scanner(System.in);
		System.out.println("enter the number");
		int n = scn.nextInt();
		while(sum<=n){
			System.out.println(sum);
			sum=a+b;
			b=a;
			a=sum;
		}

	}

}
