package Strings;

import java.util.Scanner;

public class makingAnagrams {

	public static void main(String[] args) {

		Scanner scn=new Scanner(System.in);
		String s1=scn.next();
		String s2=scn.next();
		int[] a1=new int[26];
		int[] a2= new int[26];
		for(int i=0;i<s1.length();i++){
			a1[s1.charAt(i)-'a']++;
		}
		for(int i=0;i<s2.length();i++){
			a2[s2.charAt(i)-'a']++;
		}
		int c=0;
		for(int i=0;i<26;i++){
			if(a1[i]!=a2[i]){
				c+=Math.abs(a1[i]-a2[i]);
			}
		}
		System.out.println(c);
	}

}
