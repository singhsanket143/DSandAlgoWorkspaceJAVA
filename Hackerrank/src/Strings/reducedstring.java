package Strings;

import java.util.Scanner;
import java.util.Stack;

public class reducedstring {

	public static void main(String[] args) {

		Scanner scn=new Scanner(System.in);
		String str=scn.next();
		String s1="";
		Stack<Character> s= new Stack<>();
		s.push(str.charAt(0));
		for(int i=1;i<str.length();i++){
			
			if(!s.isEmpty() && str.charAt(i)==s.peek() ){
				s.pop();
			} else if(!s.isEmpty() && str.charAt(i)!=s.peek()){
				s.push(str.charAt(i));
			} else if( s.isEmpty()){
				s.push(str.charAt(i));
			}
		}
		
		if(s.isEmpty()){
			System.out.println("Empty String");
		} else{
			while(!s.isEmpty()){
				s1+=s.pop();
			}
			for(int i=s1.length()-1;i>=0;i--){
				System.out.print(s1.charAt(i));
			}
		}
	}

}
