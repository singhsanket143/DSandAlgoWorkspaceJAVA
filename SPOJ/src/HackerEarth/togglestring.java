package HackerEarth;

import java.util.Scanner;

public class togglestring {

	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
        String str=scn.nextLine();
        for(int i=0;i<str.length();i++){
        	char z=str.charAt(i);
            if(z>='a' && z<='z'){
            	z=(char)(z-32);
            } else{
            	z=(char)(z+32);
            }
            System.out.print(z);
        }
	}

}
