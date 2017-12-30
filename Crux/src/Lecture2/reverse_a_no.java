package Lecture2;

import java.util.Scanner;

public class reverse_a_no {

	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
		int N=scn.nextInt(),rev=0,rem;
		while(N!=0){
			rem=N%10;
			rev=rev*10+rem;
			N=N/10;
		}
		System.out.println("reverse of the number is "+rev);
	}

}
