package Implementation;

import java.util.Scanner;

public class StrangeCounter {

	public static void main(String[] args) {
		
		Scanner scn=new Scanner(System.in);
		long n=scn.nextLong();
		long table=(long) ((Math.log((n+2)/3))/(Math.log(2)));
		long first=Math.abs((long) (3*(Math.pow(2, table))) -2);
		long value=first+2;
		long x=n-first;
		System.out.println(value-x);

	}

}
