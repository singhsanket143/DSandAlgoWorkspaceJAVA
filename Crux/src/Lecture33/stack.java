package Lecture33;


public class stack {
	protected int[] data;
	private int tos;
	public static final int DEFAULT_CAPACITY = 10;

	public stack(int capacity) {
		this.data = new int[capacity];
		this.tos = -1;
	}

	public stack() {
		this(DEFAULT_CAPACITY);
	}

	public int size() {
		return this.tos + 1;
	}

	public boolean isempty() {
		return this.size() == 0;
	}

	public void push(int item) throws Exception {
		if (this.tos == this.data.length - 1) {
			throw new Exception("stack is full");
		}
		// if (this.size()==this.data.length) {
		// throw new Exception("zstack is full");
		// }
		this.tos++;
		this.data[this.tos] = item;
	}

	public int top() throws Exception {
		if (this.isempty()) {
			throw new Exception("Stack is empty");
		}
		int rv = this.data[this.tos];
		return rv;

	}

	public int pop() throws Exception {
		if (this.isempty()) {
			throw new Exception("Stack is empty");
		}
		int rv = this.data[this.tos];
		this.tos--;
		return rv;
	}

	public void display() {
		for (int i = this.tos; i >= 0; i--) {
			System.out.println("***********************************");
			System.out.println("tos="+this.tos+", capacity="+this.data.length);
			System.out.println();
			System.out.print(this.data[i] + ",");
		}
		System.out.println("END");
		System.out.println("**********************************");

	}
}
