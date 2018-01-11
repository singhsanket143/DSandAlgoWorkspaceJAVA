package novChallenge;

import java.util.Scanner;

public class chefHatesPalindrome {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		int t = scn.nextInt();
		while (t-- > 0) {
			int n = scn.nextInt();
			int a = scn.nextInt();
			String s=hatedPalindrome(n, a);
			System.out.println(s);
		}
	}

	public static String hatedPalindrome(int n, int a) {
		if (a >= 3) {
			int temp = 0;
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < n; i++) {
				sb.append((char) (temp + 'a'));
				temp++;
				if (temp >= a)
					temp = 0;
			}
			return "1"+" "+sb.toString();
		} else if (a == 2) {
			if(n==1){
				return "1 a";
			} else if(n==2){
				return "1 ab";
			} else if(n==3){
				return "2 abb";
			} else if(n==4){
				return "2 aabb";
			} else if(n==5){
				return "3 aaabb";
			} else if(n==6){
				return "3 aaabbb";
			} else if(n==7){
				return "3 aaababb";
			} else if(n==8){
				return "3 aaababbb";
			} else if(n==9){
				return "4 aaababbaa";
			} else if(n>9){
				String str="aa";
				String str2="babb";
				StringBuilder sb=new StringBuilder();
				sb.append('a');
				for(int i=0;sb.length()<n;i++){
					if(i%2==0){
						sb.append(str);
					} else {
						sb.append(str2);
					}
				}
//				str=str.substring(0, n-sb.length());
//				sb.append(str);
				String k=sb.toString();
				if(k.length()>n){
					k=k.substring(0, n);
//					System.out.println(k.length());
				}
				return "4"+" "+k;
			}
				
		} else if (a == 1) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < n; i++) {
				
				sb.append((char) ('a'));
			}
			return sb.toString().length()+" "+sb.toString();
		}
		return "";
	}

}
