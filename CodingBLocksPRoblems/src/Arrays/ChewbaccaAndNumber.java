package Arrays;

import java.util.Scanner;

public class ChewbaccaAndNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		String arr = scn.next();
		char str[] = arr.toCharArray();
		int i = 0;
		if(str[i]=='9') {
			i++;
		}
		for(;i<arr.length();i++) {
			int digit = str[i] - '0';
			if(digit>=5) {
				digit = 9 - digit;
				String s =  (digit + "");
				str[i] = (digit + "").charAt(0);
			}
		}
		for(int m=0;m<str.length;m++)
			System.out.print(str[m]);
	}

}
