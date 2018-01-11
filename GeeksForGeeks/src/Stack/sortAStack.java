package Stack;

import java.util.Scanner;
import java.util.Stack;

public class sortAStack {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		Stack<Integer> st = new Stack<>();
		while (n-- > 0) {
			st.push(scn.nextInt());
		}
		
		st = sort(st);
		while (!st.isEmpty()) {
			System.out.println(st.pop());
		}

	}

	public static Stack<Integer> sort(Stack<Integer> st) {
		Stack<Integer> temp = new Stack<>();
		int el = st.pop();
		temp.push(el);
		while (!st.isEmpty()) {
			if (st.peek() > temp.peek()) {
				el = st.pop();
				temp.push(el);
			} else {
				el = st.pop();
				while (!temp.isEmpty() && temp.peek() > el) {
					st.push(temp.pop());
				}
				temp.push(el);
			}
		}

		return temp;
	}

}
