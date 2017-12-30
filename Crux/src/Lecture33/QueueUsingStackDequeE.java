package Lecture33;

import Lecture33.queuesandstacks.dynamic_stack;

public class QueueUsingStackDequeE {

	private dynamic_stack primaryStack;
	private dynamic_stack secondryStack;

	public QueueUsingStackDequeE() {
		 this.primaryStack = new dynamic_stack();
		 this.secondryStack = new dynamic_stack();

	}

	public void Enqueue(int item) throws Exception {
		while (!this.primaryStack.isempty())
			this.secondryStack.push(this.primaryStack.pop());

		this.secondryStack.push(item);

		while (!this.secondryStack.isempty())
			this.primaryStack.push(this.secondryStack.pop());
	}

	public int Dequeue() throws Exception {
		return this.primaryStack.pop();
	}

	public int front() throws Exception {
		return this.primaryStack.top();
	}

	public void display() throws Exception {
		this.primaryStack.display();
	}
	public int size(){
		return this.primaryStack.size();
	}

	public boolean IsEmpty(){
		return this.primaryStack.isempty();
	}
}