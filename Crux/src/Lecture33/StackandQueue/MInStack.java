package StackandQueue;

import queuesandstacks.StackusingLinkedList;

public class MInStack {
	StackusingLinkedList minstack = new StackusingLinkedList();
	StackusingLinkedList normalstack = new StackusingLinkedList();

	public void push(int item) throws Exception {
		this.normalstack.push(item);

		if (this.minstack.isEmpty() || this.minstack.top() >= item)
			this.minstack.push(item);

	}

	public int pop() throws Exception {

		if (this.minstack.top() == this.normalstack.top()) {
			this.minstack.pop();

		}

		return this.normalstack.pop();
	}

	public int MinValue() throws Exception {
		return this.minstack.top();
	}

	public void display() throws Exception {
		this.normalstack.display();
		this.minstack.display();
	}
}