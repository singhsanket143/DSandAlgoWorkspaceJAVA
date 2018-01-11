package Mathematical;

import java.util.Scanner;

public class digitaalRoot {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn=new Scanner(System.in);
		long n=scn.nextLong();
		System.out.println(digitalRoot(n));

	}
	
	public static double digitalRoot(long n){
		double result=n-(9*Math.floor((n-1)/9));
		return result;
	}

}
