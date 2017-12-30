package Lecture2;

import java.util.Scanner;

public class sum_of_odd_and_even_digits {

	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
		System.out.println("enter the number");
		int n = scn.nextInt(),i=1,odd=0,even=0;
		while(i<=n){
			if(i%2==0){
				even=even+i;
			}
			else{
				odd=odd+i;
			}
			i+=1;
			
		}
		System.out.println("sum of even digits is "+even);

		System.out.println("sum of odd digits is "+odd);

	}

}
