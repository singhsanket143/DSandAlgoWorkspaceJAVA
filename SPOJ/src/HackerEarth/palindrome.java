package HackerEarth;

import java.util.Scanner;

public class palindrome {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.nextLine();
		int i = 0;
		int j = str.length()-1;
		while (i < j) {
			if (str.charAt(i) == str.charAt(j)) {
				i++;
				j--;
			}else{
				System.out.println("NOT");
				break;
			}
		}
		if(i==j || j-i==1 || i-j==1){
			System.out.println("YES");
		}
	}

}
