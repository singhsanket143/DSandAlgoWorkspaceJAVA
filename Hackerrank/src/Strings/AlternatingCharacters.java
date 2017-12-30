package Strings;

import java.util.Scanner;
import java.util.Stack;

public class AlternatingCharacters {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		int t=scn.nextInt();
		for(int j=0;j<t;j++){
			String str=scn.next();
			Stack<Character> s= new Stack<>();
			int c=0;
			s.push(str.charAt(0));
			for(int i=1;i<str.length();i++){
				if(s.peek()==str.charAt(i)){
					c++;
					continue;
				} else {
					s.push(str.charAt(i));
				}
			}
			System.out.println(c);
		}
	}

}
