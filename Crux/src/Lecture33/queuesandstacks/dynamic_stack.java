package Lecture33.queuesandstacks;


public class dynamic_stack extends stack {

	public void push(int item) {
		if (this.size() == super.data.length) {
			int[] temp = super.data;
			this.data = new int[temp.length * 2];
			for (int i = 0; i < temp.length; i++) {
				this.data[i] = temp[i];
			}
		}
		try {
			super.push(item);
		} catch (Exception ex) {
			// never lands here
		}
	}

	public int pop() throws Exception {
		{
			if (this.size() == super.data.length / 4) {
				int[] temp = super.data;
				super.data = new int[temp.length / 2];
				for (int i = 0; i < this.size(); i++) {
					super.data[i] = temp[i];
				}
			}

			return super.pop();

		}

	}

	public dynamic_stack(int capacity) {
		super(capacity);
	}

	public dynamic_stack() {
		this(DEFAULT_CAPACITY);
	}
}
