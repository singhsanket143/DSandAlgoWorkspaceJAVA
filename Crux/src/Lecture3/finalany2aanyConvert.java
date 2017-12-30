package Lecture3;

import java.util.Scanner;

public class finalany2aanyConvert {

	public static void main(String[] args) {
Scanner scn = new Scanner(System.in);
		
		System.out.println("Enter source base ");
		int sb = scn.nextInt();
		
		System.out.println("Enter destination base ");
		int db = scn.nextInt();
		
		System.out.println("Enter source number ");
		int sn = scn.nextInt();
		
		int dn = 0, sp = 1;
		
		while(sn != 0){
			int rem = sn % db;
			
			dn = dn + rem * sp;
			sp = sp * sb;
			
			sn = sn / db;
		}
		
		System.out.println("Destination number is " + dn);
	}

}
