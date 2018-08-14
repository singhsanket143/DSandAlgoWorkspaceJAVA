package Hashing;

import java.util.Scanner;

public class bobAndStringHCKE {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int t = scn.nextInt();
		while (t-- > 0) {
			String s1 = scn.next();
			String s2 = scn.next();
			int[] as1 = new int[26];
			int[] as2 = new int[26];
			for(int i=0;i<s1.length();i++) {
				as1[s1.charAt(i)-'a']++;
			}
			for(int i=0;i<s2.length();i++) {
				as2[s2.charAt(i)-'a']++;
			}
			int ans=0;
			for(int i=0;i<s1.length();i++) {
				if(as2[s1.charAt(i)-'a']<=0) {
					ans++;
				} else {
					as2[s1.charAt(i)-'a']--;
				}
			}
			for(int i=0;i<s2.length();i++) {
				if(as1[s2.charAt(i)-'a']<=0) {
					ans++;
				} else {
					as1[s2.charAt(i)-'a']--;
				}
			}
			System.out.println(ans);
		}

	}

}
