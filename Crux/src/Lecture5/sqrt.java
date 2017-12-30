package Lecture5;

import java.util.Scanner;

public class sqrt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("entder number");
		Scanner scn= new Scanner(System.in);
		double n=scn.nextDouble();
		
		int a=(int)Math.pow(n, 0.5);
		
		System.out.println(a);

	}

}
