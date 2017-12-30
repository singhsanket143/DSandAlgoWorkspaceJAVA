package Lecture4;

import java.util.Scanner;

public class to_check_whether_the_given_number_is_armstrong_no {

	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
		System.out.println("enter the number");
		int num = scn.nextInt();
		int j,temp=num;
		double rem=0.0;
		while(num!=0){
			j=num%10;
			rem=rem+1*(Math.pow(j,3));
			num=num/10;
		}
		if((int)rem==temp){
			System.out.print("yes");
		}
		else
			System.out.print("no");
	}

}
