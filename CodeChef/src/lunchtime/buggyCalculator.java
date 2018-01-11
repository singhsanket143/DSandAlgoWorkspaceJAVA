package lunchtime;

import java.util.Scanner;

public class buggyCalculator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int t = scn.nextInt();
		while (t-- > 0) {
			String a = scn.next();
			String b = scn.next();
			adder(a, b);
		}
	}

	public static void halfAdder(int a, int b) {
		String str1 = Integer.toBinaryString(a);
		String str2 = Integer.toBinaryString(b);
		System.out.println(str1);
		System.out.println(str2);
		int min = Math.min(str1.length(), str2.length());
		int[] bit1 = new int[32];
		int[] bit2 = new int[32];
		int[] bit3 = new int[32];
		for (int i = 0; i < str1.length(); i++) {
			bit1[bit1.length - 1 - i] = str1.charAt(str1.length() - i - 1) - '0';
		}
		for (int i = 0; i < str2.length(); i++) {
			bit2[bit2.length - 1 - i] = str2.charAt(str2.length() - i - 1) - '0';
		}
		int carry = 0;
		for (int i = 31; i >= 0; i--) {
			if (bit1[i] == 0 && bit2[i] == 1) {
				if (carry == 0)
					bit3[i] = 1;

				else {
					bit3[i] = 0;
					carry = 1;
				}
			} else if (bit2[i] == 0 && bit1[i] == 1) {
				if (carry == 0)
					bit3[i] = 1;
				else {
					bit3[i] = 0;
					carry = 1;
				}
			} else if (bit1[i] == 1 && bit2[i] == 1) {
				if (carry == 0) {
					bit3[i] = 0;
					carry = 1;
				} else {
					bit3[i] = 1;
					carry = 1;
				}
			} else {
				if (carry == 0)
					bit3[i] = 0;
				else {
					bit3[i] = 1;
					carry = 0;
				}
			}
		}
		for (int i = 0; i < bit3.length; i++) {
			System.out.print(bit3[i]);
		}

	}

	public static void adder(String str1, String str2) {
		String res="";
		int min = Math.min(str1.length(), str2.length());
		for (int i = 0; i < min; i++) {
			int k=(str1.charAt(str1.length()-i-1)-'0')+(str2.charAt(str2.length()-i-1)-'0');
			k=k%10;
			res=k+res;
		}
		if(str1.length()>str2.length()){
			res=str1.substring(0, str1.length()-min)+res;
		} else{
			res=str2.substring(0, str2.length()-min)+res;
		}
		System.out.println(Integer.parseInt(res, 10));
	}
}
