package StackandQueue;

public class MInStackClient {

	public static void main(String[] args) throws Exception {

		MInStack min = new MInStack();
		min.push(12);
		min.push(10);
		min.push(13);
		min.push(6);
		min.push(7);
		min.push(8);
		min.push(1);
		min.push(0);
		min.push(2);

		min.display();

		System.out.println(min.MinValue());
		min.pop();
		min.display();
		System.out.println(min.MinValue());
		min.display();
		min.pop();
		System.out.println(min.MinValue());
		min.display();
		min.pop();
		System.out.println(min.MinValue());
		min.display();
		min.pop();
		System.out.println(min.MinValue());
		min.display();
		min.pop();
		System.out.println(min.MinValue());
		min.display();
		System.out.println("************");
		min.pop();
		System.out.println(min.MinValue());
		min.display();
		min.pop();
		System.out.println(min.MinValue());
		min.display();

		min.pop();
		System.out.println(min.MinValue());
		min.display();
		
	}

}
