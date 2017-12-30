package Lecture33;

import Lecture33.queuesandstacks.dynamic_queue;

public class StackUsingQueuePopE {
	private dynamic_queue queuePrimary;
	private dynamic_queue queueSecondary;

	public StackUsingQueuePopE() {
		this.queuePrimary = new dynamic_queue();
		this.queueSecondary = new dynamic_queue();
	}

	public void push(int item) throws Exception {
		while (!this.queuePrimary.isempty())
			this.queueSecondary.enqueue(this.queuePrimary.dequeue());

		this.queuePrimary.enqueue(item);

		while (!this.queueSecondary.isempty())
			this.queuePrimary.enqueue(this.queueSecondary.dequeue());

	}

	public int size() {
		return this.queuePrimary.size();
	}

	public boolean isEmpty() {
		return this.size() == 0;
	}

	public int pop() throws Exception {
		return this.queuePrimary.dequeue();
	}

	public int top() throws Exception {
		return this.queuePrimary.front();
	}

	public void display() throws Exception {
		this.queuePrimary.display();
	}

}