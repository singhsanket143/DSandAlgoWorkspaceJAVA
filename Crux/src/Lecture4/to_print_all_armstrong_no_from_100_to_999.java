package Lecture4;

import java.util.Scanner;

public class to_print_all_armstrong_no_from_100_to_999 {

	public static void main(String[] args) {
		System.out.println("armstrongs between 100 to 999 are");
		int num,j,rem;
		for(num=100;num<=999;num++){
			int k;
			rem=0;
			k=num;
			while(k!=0){
				j=k%10;
				rem=rem+(j*j*j);
				k=(int)k/10;}
			
			if((int)rem==num){
				System.out.println(rem);
			}
		}
	}
}
