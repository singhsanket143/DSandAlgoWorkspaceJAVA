package TwoPointer;

import java.util.Scanner;

public class SanketAndString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int k=scn.nextInt();
		String str = scn.next();
		int left=0, ans=0;
		int[] count = {0,0};
		for (char c: str.toCharArray()) {
			count[c-'a']++;
			if(Math.min(count[0], count[1]) > k) {
				count[str.charAt(left)-'a']--;
				left++;
			} else {
				ans++;
			}
		}
		System.out.println(ans);
	}

}
