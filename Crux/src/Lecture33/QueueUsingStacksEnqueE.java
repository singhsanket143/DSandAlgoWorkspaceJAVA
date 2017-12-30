package Lecture33;

import Lecture33.queuesandstacks.dynamic_stack;

public class QueueUsingStacksEnqueE {
	private dynamic_stack primaryStack;
	private dynamic_stack secondryStack;

	public QueueUsingStacksEnqueE() {
		this.primaryStack = new dynamic_stack();
		this.secondryStack = new dynamic_stack();

	}

	public void Enqueue(int item) {
		this.primaryStack.push(item);
	}

	public int Dequeue() throws Exception {

		while (!primaryStack.isempty())
			secondryStack.push(primaryStack.pop());

		int rv = secondryStack.pop();

		while (!secondryStack.isempty())
			primaryStack.push(secondryStack.pop());

		return rv;
	}

	public int front() throws Exception {

		while (!primaryStack.isempty())
			secondryStack.push(primaryStack.pop());

		int rv = secondryStack.top();

		while (!secondryStack.isempty())
			primaryStack.push(secondryStack.pop());

		return rv;

	}

	public void display() throws Exception {
		while (!primaryStack.isempty())
			secondryStack.push(primaryStack.pop());

		secondryStack.display();

		while (!secondryStack.isempty())
			primaryStack.push(secondryStack.pop());
	}

	public int size() {
		return primaryStack.size();
	}

	public boolean IsEmpty() {
		return primaryStack.isempty();
	}
}