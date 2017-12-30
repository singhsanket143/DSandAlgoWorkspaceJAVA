package Lecture4;

import java.util.Scanner;

public class to_calculate_the_no_of_5s_in_a_no {

	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
		
		int num = scn.nextInt(),k,i=0;
		Scanner scn1=new Scanner(System.in);
		
		int n1 = scn.nextInt();
		while(num!=0){
			k=num%10;
			if(k==n1)
				i=i+1;
			num=num/10;
		}
		System.out.println(i);

	}

}
