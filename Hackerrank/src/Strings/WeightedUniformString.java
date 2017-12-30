package Strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class WeightedUniformString {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26 };
		Set<Integer> map=new HashSet<>();
		int h=0;
		for (int j = h; j < str.length();j=h ) {
			int num=0;
			for (int i = j ; i < str.length(); i++) {
				if(str.charAt(i)!=str.charAt(j)){
					map.add((i-j)*arr[str.charAt(j)-'a']);
					//h=i;
					break;
				} else{
					num++;
					h++;
					map.add((num)*arr[str.charAt(j)-'a']);
				}
			}
		}
		int t=scn.nextInt();
		while(t>0){
			int a=scn.nextInt();
			if(map.contains(a)){
				System.out.println("Yes");
			} else{
				System.out.println("No");
			}
			t--;
		}
		
	}
	public static boolean uniform(String s){
		for(int i=0;i<s.length()-1;i++){
			if(s.charAt(i)!=s.charAt(i+1))
				return false;
		}
		return true;
	}

}
