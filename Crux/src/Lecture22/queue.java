package Lecture22;


public class queue {
	protected int[] data;
	protected int front;
	public int size;
	public static final int DEFAULT_CAPACITY = 10;

	public queue(int capacity) {
		this.data = new int[capacity];
		this.front = 0;
		this.size = 0;
	}

	public queue() {
		this(DEFAULT_CAPACITY);
	}

	public int size() {
		return this.size ;
	}

	public boolean isempty() {
		return this.size() == 0;
	}

	public void enqueue(int item) throws Exception {
		if (this.size == this.data.length - 1) {
			throw new Exception("queue is full");
		}
		// if (this.size()==this.data.length) {
		// throw new Exception("zqueue is full");
		// }
		int ai=(this.front + this.size)%this.data.length;
		this.size++;
		this.data[ai] = item;
	}

	public int front() throws Exception {
		if (this.isempty()) {
			throw new Exception("queue is empty");
		}
		int rv = this.data[this.front];
		return rv;

	}

	public int dequeue() throws Exception {
		if (this.isempty()) {
			throw new Exception("queue is empty");
		}
		int rv = this.data[this.front];
		this.front=(this.front+1)%this.data.length;
		this.size--;
		return rv;
	}

	public void display() {
		for (int i = 0; i<this.size(); i++) {
			int ai=(this.front+i)%this.data.length;
			System.out.print(this.data[ai] + ",");
		}
		System.out.println("END");
		System.out.println("**********************************");

	}
}
