package Stack;

import java.util.Scanner;
import java.util.Stack;

public class solveAlgebraicExpressions {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		System.out.println(algebraicExpression(str));
	}

	public static String algebraicExpression(String str) {
//		Stack<Character> st = new Stack<>();
		int sign = 0;
		String result = "";
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(0) == '(' && i == 0) {
				continue;
			}
			if (str.charAt(i) == ')' || str.charAt(i) == '(') {
				continue;
			}
			if (sign == 1) {
				if (str.charAt(i) == '+')
					result += '-';
				else if(str.charAt(i)=='-')
					result+='+';
				else
					result+=str.charAt(i);
			} else {
				result+=str.charAt(i);
			}
			if (str.charAt(i) == '-' && str.charAt(i + 1) == '(') {
				sign = (sign == 0) ? 1 : 0;
			}
		}
		return result;
	}
}
