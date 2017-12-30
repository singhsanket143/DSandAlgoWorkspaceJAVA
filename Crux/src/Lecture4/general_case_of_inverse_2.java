package Lecture4;

import java.util.Scanner;

public class general_case_of_inverse_2 {

	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
		System.out.println("enter the number");
		int num = scn.nextInt();
		int n=5,i,rem;
		double k=0.0,result=0.0;
		for(i=5;i>=1;i--){
			rem=num%10;
			k=i*(Math.pow(10,5-rem));
			num=num/10;
			result=result+k;
		}
		
		System.out.print("inverse of the given number is\n"+(int)result);
		
		


	}

}
