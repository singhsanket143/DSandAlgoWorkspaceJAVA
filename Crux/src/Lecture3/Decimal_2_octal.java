package Lecture3;

import java.util.Scanner;

public class Decimal_2_octal {

	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
		System.out.println("enter the number");
		int dec = scn.nextInt(),bin=0,tenPowers=1;
		while(dec!=0){
			int rem=dec%8;
			bin = bin+tenPowers*rem;
			tenPowers*=10;
			dec/=8;
		}
		System.out.println("Decimal value="+bin);
	}

}
