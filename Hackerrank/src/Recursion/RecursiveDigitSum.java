package Recursion;

import java.math.BigInteger;
import java.util.Scanner;

public class RecursiveDigitSum {

	public static void main(String[] args) {

		Scanner scn=new Scanner(System.in);
		BigInteger n=new BigInteger(scn.next());
		int k=scn.nextInt();
		StringBuilder s=new StringBuilder();
		while(k>0){
			s.append(n);
			k--;
		}
		n=new BigInteger(s.toString());
		System.out.println(superdigit(n));
		
	}
	
	public static int superdigit(BigInteger str){
		BigInteger x=new BigInteger("");
		BigInteger one=new BigInteger("1");
		BigInteger nine=new BigInteger("9");
		x=str.subtract(one);
		x=x.divide(nine);
		x=x.multiply(nine);
//		int count=str.subtract(x);
		
		return count;
		
	}

}

