package Lecture23;



public class to_check_balanced_brackets_using_stacks extends stack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			stack st = new stack(4);
			for (int i = 0; i < 20; i++) {
				st.push(20 - i);
				displaystackinfo(st);
			}

			System.out.println("point 1");
			st.push(100);
			displaystackinfo(st);
			System.out.println("point 2");

			while (!st.isempty()) {
				System.out.println(st.top());
				System.out.println(st.pop());
				displaystackinfo(st);
			}

			System.out.println("point 3");
			st.pop();
			System.out.println("point 4");

		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

	public static void displaystackinfo(stack st) {
		System.out.println("size = " + st.size());
		System.out.println("is empty = " + st.isempty());
		st.display();
	}
}
