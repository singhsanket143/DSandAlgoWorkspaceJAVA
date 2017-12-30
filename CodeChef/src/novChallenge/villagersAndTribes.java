package novChallenge;

import java.util.Scanner;
import java.util.Stack;

public class villagersAndTribes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int t = scn.nextInt();
		while (t-- > 0) {
			String str = scn.next();
			int[] arr = tribes(str);
			System.out.println(arr[0] + " " + arr[1]);
		}

	}

	public static int[] tribes(String str) {
		Stack<Character> s = new Stack<>();
		int[] tribes = new int[2];
		int c = 1;
		if (str.charAt(0) == 'A' || str.charAt(0) == 'B')
			s.push(str.charAt(0));
		for (int i = 1; i < str.length(); i++) {
			if (str.charAt(i) == '.') {
				c++;
				continue;
			}
			if (!s.isEmpty()) {
				if (s.peek() == str.charAt(i)) {
					tribes[str.charAt(i) - 'A'] += c;

				} else {
					tribes[s.peek() - 'A'] += 1;
				}
				c = 1;
				s.pop();
				s.push(str.charAt(i));
			} else {
				s.push(str.charAt(i));
				c = 1;
			}
		}
		if (!s.isEmpty())
			tribes[s.peek() - 'A']++;
		return tribes;
	}

}
