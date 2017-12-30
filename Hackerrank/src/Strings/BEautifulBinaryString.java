package Strings;

import java.util.Scanner;

public class BEautifulBinaryString {

	public static void main(String[] args) {

		Scanner scn= new Scanner(System.in);
		int n=scn.nextInt();
		String str=scn.next();
		if(!isBinary(str)){
			System.out.println("0");
		} else{
			char[] arr=new char[str.length()];
			for(int i=0;i<str.length();i++){
				arr[i]=str.charAt(i);
			}
			int c=0;
			for(int i=0;i<str.length()-2;i++){
				if(arr[i]=='0' && arr[i+1]=='1' && arr[i+2]=='0'){
					arr[i+2]='1';
					c++;
				}
			}
			System.out.println(c);
		}
	}
	
	public static boolean isBinary(String str){
		boolean bool=false;
		for(int i=0;i<str.length()-2;i+=3){
			if(str.charAt(i)=='0' && str.charAt(i+1)=='1' && str.charAt(i+2)=='0'){
				bool=true;
				break;
			} else{
				bool=false;
				continue;
			}
		}
		return bool;
	}

}
