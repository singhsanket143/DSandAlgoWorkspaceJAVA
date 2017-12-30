package Backtracking;

import java.util.Scanner;

public class BiggestNumberwithkswaps2 {

//	public static long start=0;
//	public static long end=0;
//	public static void init(){
//		start=System.currentTimeMillis();
//	}
	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		int n=scn.nextInt();
		int k = scn.nextInt();
		//String str = scn.next();
//		init();
		char[] s=new char[n];
		for(int i=0;i<n;i++){
			s[i]=scn.next().charAt(0);
		}
		

		int greateridx = 0;
		int smalleridx = 0;
		int greater_counter = 0;
		int old_greater_counter = 0;
		boolean flag = false;

		for (int i = 0; i < k; i++) {

			for (int j = 0; j < s.length - 1; j++) {
				if (s[j] < s[j + 1])
					break;
				else if (j == s.length - 2)
					flag = true;
			}

			if (flag)
				break;

			if (i == old_greater_counter + greater_counter)
				old_greater_counter += greater_counter;

			char greater = 0;
			greater_counter = 0;
			for (int j = (old_greater_counter > 0) ? old_greater_counter : 0; j < s.length; j++) {
				if (s[j] == greater) {
					greater_counter++;
					greateridx = j;
				}
				if (s[j] > greater) {
					greater = s[j];
					greateridx = j;
					greater_counter = 1;
				}
			}
			char smaller = 255;

			for (int j = (old_greater_counter > 0) ? old_greater_counter : 0; j < ((old_greater_counter > 0)
					? old_greater_counter + greater_counter : greater_counter); j++) {
				if (s[j] < smaller) {
					smaller = s[j];
					smalleridx = j;
				}
			}
			if (smalleridx == greateridx || s[smalleridx] == s[greateridx]) {
				k++;
			} else {
				char temp = s[smalleridx];
				s[smalleridx] = s[greateridx];
				s[greateridx] = temp;

			}
		}
		for(int i=0;i<s.length;i++){
			System.out.print(s[i]+" ");
		}
		//System.out.println(s);
//		System.out.println("duration is");
//		System.out.println(duration());

	}	


}
