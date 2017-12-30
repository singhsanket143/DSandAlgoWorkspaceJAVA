package Strings;

import java.util.Scanner;

public class hackerrank_in_a_string {

	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
		int n=scn.nextInt();
		String h="hackerrank";
		for(int i=0;i<n;i++){
			String str=scn.next();
			int c=0,d=0;
			while(c!=str.length() && d!=h.length()){
				if(str.charAt(c)==h.charAt(d)){
					c++;
					d++;
				} else if(str.charAt(c)!=h.charAt(d)){
					c++;
				}
			}
			if(d==h.length())
				System.out.println("YES");
			else
				System.out.println("NO");
		}

	}

}
