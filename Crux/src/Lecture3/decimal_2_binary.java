package Lecture3;

import java.util.Scanner;

public class decimal_2_binary {

	public static void main(String[] args) {
		Scanner scn1=new Scanner(System.in);
		System.out.println("enter the number");
		int dec = scn1.nextInt(),bin=0,tenPowers=1;
		while(dec!=0){
			int rem=dec%2;
			bin = bin+tenPowers*rem;
			tenPowers*=10;
			dec/=2;
		}
		System.out.println("Decimal value="+bin);

	}

}
