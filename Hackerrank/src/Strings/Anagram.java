package Strings;

import java.util.Scanner;

public class Anagram {

	public static void main(String[] args) {

		Scanner scn=new Scanner(System.in);
		int t=scn.nextInt();
		for(int j=0;j<t;j++){
			String str=scn.next();
			if(str.length()%2!=0){
				System.out.println("-1");
				continue;
			}
			String m=str.substring(0, str.length()/2);
			String s=str.substring(str.length()/2);
			int[] arr=new int[26];
			for(int i=0;i<s.length();i++){
				arr[s.charAt(i)-'a']++;
			}
			int c=0;
			for(int i=0;i<m.length();i++){
				if(arr[m.charAt(i)-'a']==0){
					c++;
				} else{
					arr[m.charAt(i)-'a']--;
				}
			}
			System.out.println(c);
		}
	}

}
