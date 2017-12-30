package Lecture22;


public class Stack_client {

	public static void main(String[] args) {
		try {
			stack st = new stack(5);
			for (int i = 0; i < 5; i++) {
				st.push(5 - i);
				displaystackinfo(st);

			}
			// System.out.println("Point 1");
			// st.push(100);
			// System.out.println("Point 2");
			while (!st.isempty()) {
				System.out.println(st.top());
				System.out.println(st.pop());
				displaystackinfo(st);
				// }
				// System.out.println("Point 3");
				// st.pop();
				// System.out.println("Point 4");
			}
		} catch (Exception ex) {
			System.out.println(ex);
			System.out.println("bye");
		}
	}

	public static void displaystackinfo(stack st) {
		System.out.println("Size=" + st.size());
		System.out.println("Empty=" + st.isempty());
		st.display();
	}
	
//	public static boolean balance(String str){
//		stack st=new stack(str.length());
//		for(int i=0;i<str.length();i++){
//			if(str.charAt(i)=='{'||str.charAt(i)=='['||str.charAt(i)=='('){
//				st.push(str.charAt(i));
//			}
//		}
//		
//	}
}
