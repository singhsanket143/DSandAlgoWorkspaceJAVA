package Lecture33;

import java.util.Scanner;

import Lecture33.queuesandstacks.dynamic_queue;

public class StckusingqueuepushEclient {

	public static void main(String[] args) throws Exception {

//		StackUsingQueuePushE st = new StackUsingQueuePushE();
//
//		Scanner scn = new Scanner(System.in);
//		char choice = '\0';
//		do {
//			System.out.println("enter 1 to push");
//			System.out.println("enter 2 to pop");
//			System.out.println("enter 3 to top");
//			System.out.println("enter 4 to size");
//			System.out.println("enter 5 to isEmpty");
//			System.out.println("enter 6 to display");
//			System.out.println("enter x to exit");
//
//			choice = scn.next().charAt(0);
//			switch (choice) {
//			case '1':
//				int item = scn.nextInt();
//				st.push(item);
//				break;
//			case '2':
//				st.pop();
//				break;
//			case '3':
//				st.top();
//				break;
//			case '4':
//				st.size();
//				break;
//			case '5':
//				st.isEmpty();
//				break;
//			case '6':
//				st.display();
//				break;
//			case '7':
//				break;
//			}
//
//		} while (choice != 'x');
//		System.out.println("thanks");
		StackusingLinkedList q=new StackusingLinkedList();
		StackusingLinkedList qh=new StackusingLinkedList();
		q.push(10);
		q.push(20);
		q.push(30);
		q.push(40);
		q.push(50);
		q.display();
		reverseAStack(q, qh, 0);
		q.display();

	}
	public static void reverseAQueue(dynamic_queue q) throws Exception{
		if(q.isempty()){
			return;
		}
		int rv=q.dequeue();
		reverseAQueue(q);
		q.enqueue(rv);
		
	}
	
	public static void reverseAStack(StackusingLinkedList st1,StackusingLinkedList st2,int floor) throws Exception{
		if(st1.isEmpty()){
			return;
		}
		int rv=st1.pop();
		reverseAStack(st1, st2, floor+1);
		st2.push(rv);
		if(floor==0){
			while(!st2.isEmpty()){
				int k=st2.pop();
				st1.push(k);
			}
		}
		
	}
}
