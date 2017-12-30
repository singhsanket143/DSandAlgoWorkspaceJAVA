package Strings;

import java.util.Scanner;

public class LoveLetterMystrey {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		int t=scn.nextInt();
		for(int j=0;j<t;j++){
			String str=scn.next();
			int c=0;
			int hi=0,lo=str.length()-1;
			while(hi<=lo){
				int x=Math.abs(str.charAt(lo)-str.charAt(hi));
				c+=x;
				hi++;lo--;
			}
			System.out.println(c);
		}
	}

}
