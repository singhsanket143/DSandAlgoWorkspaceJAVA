package janChallenge;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class killjee {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		ArrayList<String> arr=substring(str);
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<arr.size();i++) {
			sb.append(arr.get(i));
		}
		int q = scn.nextInt();
		int g = 0;
		while(q-- > 0) {
			int p = scn.nextInt();
			int m=scn.nextInt();
			int k = (((p%m)*(g%m))%m)+1;
			char ch = sb.charAt(k-1);
			System.out.println(ch);
			g+=ch;
		}
	}
	
	public static ArrayList<String> substring(String str) {
		ArrayList<String> arr=new ArrayList();
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<str.length();i++) {
			sb=new StringBuilder();
			sb.append(str.charAt(i));
			arr.add(sb.toString());
			for(int j=i+1;j<str.length();j++) {
				sb.append(str.charAt(j));
				arr.add(sb.toString());
			}
		}
		Collections.sort(arr);
		return arr;
	}

}
