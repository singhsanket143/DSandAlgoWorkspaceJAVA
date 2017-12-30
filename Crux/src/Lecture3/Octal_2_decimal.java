package Lecture3;

import java.util.Scanner;

public class Octal_2_decimal {

	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
		System.out.println("enter the number");
		int bin = scn.nextInt(),dec=0,eightPowers=1;
		while(bin!=0){
			int rem=bin%10;
			dec = dec+eightPowers*rem;
			eightPowers*=8;
			bin/=10;
		}
		System.out.println("Decimal value="+dec);

	}

}
