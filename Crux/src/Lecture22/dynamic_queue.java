package Lecture22;


public class dynamic_queue extends queue {
	public void enqueue(int item) throws Exception {
		if (this.size() == this.data.length - 1) {
			int[] temp = super.data;
			this.data = new int[temp.length * 2];
			for (int i = 0; i < temp.length; i++) {
				int ai = (this.front + i) % temp.length;
				this.data[i] = temp[ai];
			}
			this.front = 0;
		}
		try {
			super.enqueue(item);
		} catch (Exception ex) {
			// never lands here
		}
	}

	public int dequeue() throws Exception {
		if (this.size() == super.data.length / 4) {
			int[] temp = super.data;
			super.data = new int[temp.length / 2];
			for (int i = 0; i < this.size(); i++) {
				super.data[i] = temp[i];
			}
		}
		return super.dequeue();
	}public int size() {
		return super.size ;
	}
	public boolean isEmpty() {
		return super.size==0 ;
	}

	public dynamic_queue(int capacity) {
		super(capacity);
	}

	public dynamic_queue() {
		this(DEFAULT_CAPACITY);
	}

	public void display() {
		System.out.println("***********************************");
		System.out.println("front=" + this.front + ", capacity=" + this.data.length);
		super.display();
	}
}
