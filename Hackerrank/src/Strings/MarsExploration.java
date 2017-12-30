package Strings;

import java.util.Scanner;

public class MarsExploration {

	public static void main(String[] args) {

		Scanner scn= new Scanner(System.in);
		String str=scn.next();
		int c=0;
		for(int i=0;i<str.length();i+=3){
			if(str.charAt(i)!='S')
				c++;
		}
		for(int i=1;i<str.length();i+=3){
			if(str.charAt(i)!='O')
				c++;
		}
		for(int i=2;i<str.length();i+=3){
			if(str.charAt(i)!='S')
				c++;
		}
		System.out.println(c);
	}

}
