package Lecture4;

import java.util.Scanner;

public class power {

	public static void main(String[] args) {
	      Scanner scn = new Scanner(System.in);

	      int X = scn.nextInt();
	      int N = scn.nextInt();
	      
	      System.out.println(power(X, N));
	   }
	   
	   public static int power(int b, int p){

			int i=1;
			int a=1;
			while(i<=p)
			{
				a*=b;
				i++;
			}
	      return a;
	   }

}
