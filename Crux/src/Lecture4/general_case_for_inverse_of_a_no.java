package Lecture4;

import java.util.Scanner;

public class general_case_for_inverse_of_a_no {

	public static void main(String[] args) {
		System.out.println("enter the number");
		Scanner scn=new Scanner(System.in);
		int n=scn.nextInt();
		int pow=0,temp=n,i=1,inv=0,d=0;
		while(temp!=0){
			temp/=10;
			d++;}
		while(i<=d){
			pow=(n%10)-1;
			n/=10;
			inv+=i*Math.pow(10,pow);
			i++;}
		System.out.println(inv);
		

	}

}
