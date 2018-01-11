package Lecture33.queuesandstacks;

import java.util.Scanner;
import java.util.Stack;

public class duplicateparenthesis {

	public static void main(String[] args) throws Exception {
		Scanner s=new Scanner(System.in);
		String str=s.nextLine();

		System.out.println(duplicateparanthesis(str));
	}

	public static boolean duplicateparanthesis(String s) throws Exception {

		Stack<Character> st = new Stack<>();

		for (int i = 0; i < s.length(); i++) {

			if (s.charAt(i) != ')')
				st.push(s.charAt(i));

			else {

				if (st.peek() != '(') {

					while (st.peek() != '(')
						st.pop();
					st.pop();
				} else {
					return true;
				}
			}
		}

		return false;
	}

}
