package Lecture9;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class stringops {

	public static void main(String[] args) {

		// String s1 = "str";
		// substrings(s1);
		// printchars(s1);
		// if (ispalindrome(s1))
		// System.out.println("yes it is a palindrome");
		// else
		// System.out.println("not a palindrome");
		// /////////////
		// substrings(s1);
		// System.out.println(countpalindrome(s1));
		// Scanner scn=new Scanner(System.in);
		// String str=scn.nextLine();
		// System.out.println(togglecase(str));
//		permutation("121");
		System.out.println(ispalindrome("1234321"));
		// System.out.println(replace("aiou"));
		//System.out.print(addDifference("ACSA"));
		// System.out.print(compression("aaabbdccs"));
	}

	public static void printchars(String str) {
		for (int i = 0; i < str.length(); i++) {
			System.out.println(str.charAt(i));
		}
	}

	public static boolean ispalindrome(String str) {
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {
				return false;
			}
		}
		return true;
	}

	public static void substrings(String str) {
		for (int i = 0; i < str.length(); i++) {
			for (int j = i + 1; j <= str.length(); j++) {
				System.out.println(str.substring(i, j));
			}
		}
	}

	public static int countpalindrome(String str) {
		int counter = 1;
		for (int i = 0; i < str.length() - 1; i++) {
			for (int j = i + 1; j <= str.length() + 1; j++) {
				if (ispalindrome(str.substring(i, j))) {
					counter++;
				}
			}
		}
		return counter;
	}

	public static String togglecase(String str) {
		char s;
		String ss = "";
		for (int i = 0; i < str.length(); i++) {
			char cc = str.charAt(i);
			if (cc >= 'A' && cc <= 'Z') {
				s = (char) (str.charAt(i) - 'A' + 'a');
				ss = ss + s;
			} else if (cc >= 'a' && cc <= 'z') {
				s = (char) (str.charAt(i) + 'A' - 'a');
				ss = ss + s;
			}

		}
		return ss;

	}

	public static String replace(String str) {
		char s;
		String retval = "";
		for (int i = 0; i < str.length(); i++) {
			if (i % 2 == 0) {
				s = (char) (str.charAt(i) + 1);
				retval = retval + s;
			} else {
				s = (char) (str.charAt(i) - 1);
				retval = retval + s;
			}
		}
		return retval;
	}

	public static String addDifference(String str) {
		int s;
		String retval = "";
		for (int i = 1; i < str.length(); i++) {
			if (i < str.length()) {
				s = str.charAt(i) - str.charAt(i - 1);
				retval = retval + str.charAt(i - 1) + s;
			} else
				retval = retval + str.charAt(i - 1);
		}
		return retval + str.charAt(str.length() - 1);
	}

	public static void permutation(String str) {
		if(str.length()==2){
			System.out.println(str);
			String newstr="";
			newstr+=(char)str.charAt(1);
			newstr+=(char)str.charAt(0);
			System.out.println(newstr);
			System.out.println(newstr.length());
			return;
		}
		int check=0;
		Set<String> set = new HashSet<String>();
		boolean[] used = new boolean[26];
		int k = str.length() - 1;
		int val = 1;
		while (k != 1) {
			val *= k;
			k--;
		}
		for (int i = 0; i < str.length(); i++) {
			int counter = 0;
			for (int j = 1; j < str.length() - 1; j++) {
				char[] array = str.toCharArray();
				char ch = (char) array[j];
				
					array[j] = array[j + 1];
					array[j + 1] = ch;
					str = new String(array);
					check++;
					set.add(str);
				
				counter++;
				if (j == str.length() - 2)
					j = 0;
				if (counter == val)
					break;
			}
			if (check == val * str.length())
				break;
			char[] array = str.toCharArray();
			char ch = (char) array[0];
			array[0] = array[i + 1];
			array[i + 1] = ch;
			str = new String(array);
		}
		for (String s : set) {
		    System.out.println(s);
		}
		System.out.println(set.size());
	}

	public static char maxfreqchar(String str) {
		int[] cap = new int[26];
		int[] small = new int[26];
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if (ch >= 65 && ch <= 90)
				cap[ch - 'A']++;
			else if (ch >= 97 && ch <= 122)
				small[ch - 'a']++;
		}
		int max = -1;
		char result = ' ';
		for (int i = 0; i < cap.length; i++) {
			if (cap[i] > max) {
				max = cap[i];
				result = (char) (i + 65);
			}
		}
		for (int i = 0; i < small.length; i++) {
			if (small[i] > max) {
				max = small[i];
				result = (char) (i + 97);
			}
		}
		return result;
	}

}