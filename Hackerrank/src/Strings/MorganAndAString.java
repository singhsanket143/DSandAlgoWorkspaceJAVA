package Strings;

import java.util.Scanner;
import java.util.Stack;

public class MorganAndAString {

	public static void main(String[] args) {

		Scanner scn=new Scanner(System.in);
		int t=scn.nextInt();
		for(int m=0;m<t;m++){
			String s1=scn.next();
			String s2=scn.next();
			Stack<Character> a= new Stack<>();
			Stack<Character> b= new Stack<>();
			for(int i=s1.length()-1;i>=0;i--){
				a.push(s1.charAt(i));
			}
			for(int i=s2.length()-1;i>=0;i--){
				b.push(s2.charAt(i));
			}
			String str="";
			while(str.length()!=s1.length()+s2.length()){
				if(a.isEmpty()){
					str+=b.pop();
					continue;
				}
				if(b.isEmpty()){
					str+=a.pop();
					continue;
				} 
				if(a.peek()<b.peek()){
					str+=a.pop();
					continue;
				} else if(a.peek()>b.peek()){
					str+=b.pop();
					continue;
				} else if(a.peek()==b.peek()){
					if(a.size()>b.size()){
						str+=a.pop();
						continue;
					}else{
						str+=b.pop();
						continue;
					}
				}
			}
			System.out.println(str);
		}
	}

}
