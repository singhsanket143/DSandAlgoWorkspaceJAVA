package Lecture4;

import java.util.Scanner;

public class lcm_of_2_numbers {

	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
		System.out.println("enter the number");
		int a = scn.nextInt();
		Scanner scn1=new Scanner(System.in);
		System.out.println("enter the number");
		int b = scn1.nextInt(),g,t,lcm=1,temp1=a,temp2=b;
		while(b!=0){
			if(b<=a){
				g=a%b;
				a=b;
				b=g;}
				
			else{
			t=a;
			a=b;
			b=t;}
			
		}
			
		lcm=(temp1*temp2)/a;
		System.out.println(lcm);
		
	}

}
