package Lecture33;

import java.util.Scanner;

public class QueueUsingStack_client {

	public static void main(String[] args) throws Exception {

		QueueUsingStackDequeE q = new QueueUsingStackDequeE();

		Scanner scn = new Scanner(System.in);
		char choice = '\0';
		do {
//			try {
				System.out.println("enter 1 to enqueue");
				System.out.println("enter 2 to dequeue");
				System.out.println("enter 3 to front");
				System.out.println("enter 4 to size");
				System.out.println("enter 5 to isEmpty");
				System.out.println("enter 6 to display");
				System.out.println("enter x to exit");

				choice = scn.next().charAt(0);
				switch (choice) {
				case '1':
					int item = scn.nextInt();
					q.Enqueue(item);
					break;
				case '2':
					System.out.println(q.Dequeue());
					break;
				case '3':
					System.out.println(q.front());
					break;
				case '4':
					System.out.println(q.size());
					break;
				case '5':
					System.out.println(q.IsEmpty());
					break;
				case '6':
					q.display();
					break;
				case '7':
					break;
				}
//			} catch (Exception e) {
//				System.out.println(e.getMessage());
//			}
		} while (choice != 'x');
		System.out.println("thanks");

	}

}