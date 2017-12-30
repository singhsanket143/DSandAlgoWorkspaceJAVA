package Lecture33;

import java.util.Scanner;

import queuesandstacks.linkedlist;

public class stackusinglinkedlistClient {

	public static void main(String[] args) {

		StackusingLinkedList st = new StackusingLinkedList();

		Scanner scn = new Scanner(System.in);
		char choice = '\0';
		do {
			try{
			System.out.println("enter 1 to push");
			System.out.println("enter 2 to pop");
			System.out.println("enter 3 to top");
			System.out.println("enter 4 to size");
			System.out.println("enter 5 to isEmpty");
			System.out.println("enter 6 to display");
			System.out.println("enter x to exit");

			choice = scn.next().charAt(0);
			switch (choice) {
			case '1':
				int item = scn.nextInt();
				st.push(item);
				break;
			case '2':
				System.out.println(st.pop());
				break;
			case '3':
				System.out.println(st.top());
				break;
			case '4':
				st.size();
				break;
			case '5':
				st.isEmpty();
				break;
			case '6':
				st.display();
				break;
			case '7':
				break;
			}
			}catch(Exception ex){
				System.out.println(ex.getMessage());
			}

		} while (choice != 'x');
		System.out.println("thanks");
	}

}
