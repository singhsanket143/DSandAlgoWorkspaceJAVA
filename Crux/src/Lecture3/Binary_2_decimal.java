package Lecture3;

import java.util.Scanner;

public class Binary_2_decimal {

	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
		int bin = scn.nextInt(),dec=0,twoPowers=1;
		while(bin!=0){
			int rem=bin%10;
			dec = dec+twoPowers*rem;
			twoPowers*=2;
			bin/=10;
		}
		System.out.println(dec);
	}

}
