package Assignment7;

import java.util.ArrayList;
import java.util.Scanner;

public class recursionAssignment {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		// String str = scn.next();
		// int num = scn.nextInt();
		// System.out.println(sumOfDigitis(str));
		// System.out.println(StringtoNum2(str));
		// System.out.println(checkReverse("dcba", "abcd"));
		// System.out.println(isPalindrome("aba"));
		// System.out.println(insertstarbtweenconsecutive("helloo"));
		// System.out.println(reduceconsecutive("helllolloo"));
		//System.out.println(shiftXtolast("xxxx"));
		// System.out.println(removeHI("hihellhij"));
		// System.out.println(countHIT("hihellohithi"));
		// System.out.println(replaceHIT("hihellohihi"));
		// System.out.println(countaaaNooverlapallowed("aaaa"));
		// System.out.println(countaaaoverlapallowed("aaaa"));
//		 System.out.println(twins("aaaxa"));
		 char[] arr = { 'a', 'b', 'c', 'd', 'e', 'f','g','h','i', 'j', 'k',
		 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v',
		 'w', 'x', 'y', 'z' };
		 printCodes("121", "", arr);
		// printinparenthesis("cde(abc)def", "", false);
		// System.out.println(checkbalancedbrackets(")a+b(", ""));
		// int[] arr = { 5, 6, 1, 4, 3, 9, 7, 2, 4 };
		// selectionsort(arr, 0, arr.length - 1);
		// for (int i = 0; i < arr.length; i++) {
		// System.out.println(arr[i]);
		// }
//		int[] arr={1,2,3,4,5};
//		reversearray(arr, 0);
//		for(int i=0;i<arr.length;i++){
//			System.out.println(arr[i]);
//		}
	}

	public static int sumOfDigitis(String str) {
		if (str.length() == 0) {
			return 0;
		}
		char ch = str.charAt(0);
		String ros = str.substring(1);
		int sum = sumOfDigitis(ros);
		return sum + (ch - '0');
	}

	public static String numtoString(int num) {
		if (num == 0) {
			return "";
		}
		String str = "";
		str += num % 10;
		String newstr = numtoString(num / 10);
		return newstr + str;
	}

	public static int StringtoNum(String str) {
		if (str.length() == 0) {
			return 0;
		}
		int first = str.charAt(0) - '0';
		String ros = str.substring(1);
		int recresult = StringtoNum(ros);
		return first * ((int) Math.pow(10, str.length() - 1)) + recresult;
	}

	public static int StringtoNum2(String str) {
		if (str.length() == 0) {
			return 0;
		}
		int first = str.charAt(str.length() - 1) - '0';
		String ros = str.substring(0, str.length() - 1);
		int recresult = StringtoNum2(ros);
		int myresult = first + recresult * 10;
		return myresult;
	}

	public static boolean checkReverse(String str1, String str2) {
		if (str1.length() == 0 && str2.length() == 0) {
			return true;
		}
		char ch1 = str1.charAt(0);
		char ch2 = str2.charAt(str2.length() - 1);
		String ros1 = str1.substring(1);
		String ros2 = str2.substring(0, str2.length() - 1);
		boolean bool = checkReverse(ros1, ros2);
		if (bool == true && ch1 == ch2) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean isPalindrome(String str) {
		if (str.length() == 1) {
			return true;
		}
		if (str.length() == 0) {
			return true;
		}
		char ch1 = str.charAt(0);
		char ch2 = str.charAt(str.length() - 1);
		String ros = str.substring(1, str.length() - 1);
		boolean bool = isPalindrome(ros);
		if (bool == true && ch1 == ch2) {
			return true;
		} else {
			return false;
		}
	}

	public static String insertstarbtweenconsecutive(String str) {
		if (str.length() == 1) {
			return str;
		}
		char ch = str.charAt(0);
		String ros = str.substring(1);
		String recresult = insertstarbtweenconsecutive(ros);
		if (ros.charAt(0) == ch) {
			char star = '*';
			String myresult = "";
			myresult += (char) ch;
			myresult += star;
			myresult += recresult;
			return myresult;
		} else {
			String myresult = (char) ch + recresult;
			return myresult;
		}
	}

	public static String reduceconsecutive(String str) {
		if (str.length() == 1) {
			return str;
		}
		char ch = str.charAt(0);
		String ros = str.substring(1);
		String recresult = reduceconsecutive(ros);
		if (ros.charAt(0) == ch) {
			// char star = '*';
			String myresult = "";
			myresult += (char) ch;
			// myresult += star;
			myresult += recresult.substring(1);
			return myresult;
		} else {
			String myresult = (char) ch + recresult;
			return myresult;
		}
	}

	public static String shiftXtolast(String str) {
		if (str.length() == 0) {
			return "";
		}
		char ch = str.charAt(0);
		String ros = str.substring(1);
		String recresult = shiftXtolast(ros);
		if (ch == 'x' || ch == 'X') {
			String myresult = "";
			myresult += recresult + ch;
			return myresult;
		} else {
			return ch + recresult;
		}
	}

	public static String replacehiwithbye(String str) {
		if (str.length() < 2) {
			return str;
		}
		String ros = "";
		String ch = str.substring(0, 2);
		if (ch.equals("hi")) {
			ros = str.substring(2);
			String recresult = replacehiwithbye(ros);
			return "bye" + recresult;
		} else {
			ros = str.substring(1);
			String recresult = replacehiwithbye(ros);
			return ch.charAt(0) + recresult;
		}

	}

	public static int counthi(String str) {
		if (str.length() < 2) {
			return 0;
		}
		String ros = "";
		String ch = str.substring(0, 2);
		if (ch.equals("hi")) {
			ros = str.substring(2);
			return 1 + counthi(ros);
		} else {
			ros = str.substring(1);
			return counthi(ros);

		}
	}

	public static String removeHI(String str) {
		if (str.length() < 2) {
			return str;
		}
		String ros = "";
		String ch = str.substring(0, 2);
		if (ch.equals("hi")) {
			ros = str.substring(2);
			String recresult = removeHI(ros);
			return recresult;
		} else {
			ros = str.substring(1);
			String recresult = removeHI(ros);
			return ch.charAt(0) + recresult;
		}

	}

	public static int countHIT(String str) {
		if (str.length() < 3) {
			if (str.equals("hi")) {
				return 1;
			} else {
				return 0;
			}
		}
		String ros = "";
		String ch = str.substring(0, 3);
		if (!ch.equals("hit") && (ch.charAt(0) == 'h' && ch.charAt(1) == 'i')) {
			ros = str.substring(2);
			return 1 + countHIT(ros);

		} else {
			ros = str.substring(1);
			return countHIT(ros);

		}
	}

	public static String removeHIT(String str) {
		if (str.length() < 3) {
			if (str.equals("hi")) {
				return "";
			} else {
				return str;
			}
		}
		String ros = "";
		String ch = str.substring(0, 3);
		if (!ch.equals("hit") && (ch.charAt(0) == 'h' && ch.charAt(1) == 'i')) {
			ros = str.substring(2);
			String recresult = removeHIT(ros);
			return recresult;
		} else {
			ros = str.substring(1);
			String recresult = removeHIT(ros);
			return ch.charAt(0) + recresult;
		}
	}

	public static String replaceHIT(String str) {
		if (str.length() < 3) {
			if (str.equals("hi")) {
				return "bye";
			} else {
				return str;
			}
		}
		String ros = "";
		String ch = str.substring(0, 3);
		if (!ch.equals("hit") && (ch.charAt(0) == 'h' && ch.charAt(1) == 'i')) {
			ros = str.substring(2);
			String recresult = replaceHIT(ros);
			return "bye" + recresult;
		} else {
			ros = str.substring(1);
			String recresult = replaceHIT(ros);
			return ch.charAt(0) + recresult;
		}
	}

	public static int countaaaoverlapallowed(String str) {
		if (str.length() < 3) {
			return 0;
		}
		String ch = str.substring(0, 3);
		String ros = "";

		if (ch.equals("aaa")) {
			ros = str.substring(1);
			return 1 + countaaaoverlapallowed(ros);
		} else {
			ros = str.substring(1);
			return countaaaoverlapallowed(ros);
		}
	}

	public static int countaaaNooverlapallowed(String str) {
		if (str.length() < 3) {
			return 0;
		}
		String ch = str.substring(0, 3);
		String ros = "";

		if (ch.equals("aaa")) {
			ros = str.substring(3);
			return 1 + countaaaNooverlapallowed(ros);
		} else {
			ros = str.substring(1);
			return countaaaNooverlapallowed(ros);
		}
	}

	public static int twins(String str) {
		if (str.length() < 3) {
			return 0;
		}
		String ch = str.substring(0, 3);
		String ros = "";

		if (ch.charAt(0) == ch.charAt(2)) {
			ros = str.substring(1);
			return 1 + twins(ros);
		} else {
			ros = str.substring(1);
			return twins(ros);
		}
	}
	
	public static ArrayList<String> getcode(String str, int j) {
		if (str.length() == j) {
			ArrayList<String> basecase = new ArrayList<String>();
			basecase.add("");
			return basecase;
		}
		ArrayList<String> myresult = new ArrayList<String>();
		int cc = (int) str.charAt(j) - '0';
		ArrayList<String> recresult = getcode(str, j + 1);
		for (int i = 0; i < recresult.size(); i++) {
			myresult.add((char) (cc + 96) + recresult.get(i));
		}
		if (j + 1 != str.length()) {
			int u = (int) (str.charAt(j) - '0') * 10 + (int) (str.charAt(j + 1) - '0');
			if (u <= 26) {
				ArrayList<String> recresult2 = getcode(str, j + 2);
				for (int i = 0; i < recresult2.size(); i++) {
					myresult.add((char) (u + 96) + recresult2.get(i));
				}
			}
		}
		return myresult;
	}

	public static void printCodes(String str, String osf, char[] arr) {
		if (str.length() == 0) {
			System.out.println(osf);
			return;
		}
		int one = str.charAt(0) - '0';
		int two = 0;
		if (str.length() > 1)
			two = Integer.parseInt(str.substring(0, 2));
		else
			two = 0;
		if (two < 27 && str.length() > 1) {
			printCodes(str.substring(1), osf + arr[one - 1], arr);
			printCodes(str.substring(2), osf + arr[two - 1], arr);
		} else {
			printCodes(str.substring(1), osf + arr[one - 1], arr);
		}
	}

	public static void printinparenthesis(String str, String osf, boolean bool) {
		if (str.charAt(1) == ')') {
			System.out.println(osf);
			bool = false;
			return;
		}

		char ch = str.charAt(0);
		if (ch == '(')
			bool = true;
		String ros = str.substring(1);
		if (bool) {
			printinparenthesis(ros, osf + str.charAt(1), bool);
		} else {
			printinparenthesis(ros, osf, bool);
		}
	}

	public static void selectionsort(int[] arr, int si, int ei) {
		if (si == arr.length)
			return;
		if (si >= ei) {

			selectionsort(arr, si + 1, arr.length - 1);
			return;
		}
		if (arr[ei] < arr[ei - 1]) {
			int temp = arr[ei];
			arr[ei] = arr[ei - 1];
			arr[ei - 1] = temp;
		}
		selectionsort(arr, si, ei - 1);

	}

	public static void bubblesort(int[] arr, int si, int ei) {
		if (si == ei) {
			return;
		}
		for (int i = si; i < ei; i++) {
			if (arr[i] > arr[i + 1]) {
				int temp = arr[i];
				arr[i] = arr[i + 1];
				arr[i + 1] = temp;
			}
		}
		bubblesort(arr, 0, ei - 1);
		return;
	}

	public static boolean checkbalancedbrackets(String str, String osf) {
		if (str.length() == 0) {
			if (osf.length() == 0) {
				return true;
			} else {
				return false;
			}
		}
		char ch = str.charAt(0);
		String ros = str.substring(1);
		if (ch == '(' || ch == '{' || ch == '[') {
			return checkbalancedbrackets(ros, osf + ch);
		} else if (ch == ')' || ch == '}' || ch == ']') {
			if (osf.length() > 0)
				return checkbalancedbrackets(ros, osf.substring(0, osf.length() - 1));
			else
				return checkbalancedbrackets(ros, osf + ch);
		} else {
			return checkbalancedbrackets(ros, osf);
		}
	}

	public static void reversearray(int[] arr, int si) {
		if (si > (arr.length - 1 - si)) {
			return;
		}

		int temp = arr[si];
		arr[si] = arr[arr.length - 1 - si];
		arr[arr.length - 1 - si] = temp;
		reversearray(arr, si + 1);
	}
}
