package Lecture28.story;

public class LinkedList<T> {

	private class Node {

		T data;
		Node next;

		Node(T data, Node next) {// node constructor
			this.data = data;
			this.next = next;
		}
	}

	Node head;
	Node tail;
	int size;

	public LinkedList() {// linkedlist constructor
		this.head = null;
		this.tail = null;
		this.size = 0;
	}

	public void addfirst(T data) {
		Node node = new Node(data, this.head);
		if (this.size == 0) {
			// Node node=new Node(data,null);
			this.head = node;
			this.tail = node;
			// this.size++;
		} else {
			// Node node=new Node(data,this.head);
			this.head = node;
			/// this.size++;
		}
		this.size++;

	}

	public void addat(T data, int idx) throws Exception {
		if (idx < 0 || idx > this.size) {
			throw new Exception("index out of bound");
		}
		if (idx == 0) {
			this.addfirst(data);
		} else if (idx == this.size) {
			this.addlast(data);
		} else {
			Node nm1 = this.getNodeAt(idx - 1);
			Node n = nm1.next;
			Node node = new Node(data, n);
			nm1.next = node;
			this.size++;
		}
	}

	public T removefirst() throws Exception {

		if (this.size == 0) {
			throw new Exception("list is empty");
		}
		T temp = this.head.data;
		if (this.size == 1) {
			this.head = null;
			this.tail = null;
		} else {
			this.head = this.head.next;
		}

		this.size--;
		return temp;
	}

	public T removeat(int idx) throws Exception {

		if (this.isempty()) {
			throw new Exception("List is empty");
		}
		if (idx < 0 || idx >= this.size) {
			throw new Exception("index out of bound");
		}
		if (idx == 0) {
			return this.removefirst();
		} else if (idx == this.size - 1) {
			return this.removelast();
		} else {

			Node prev = this.getNodeAt(idx - 1);
			Node curr = prev.next;
			Node next = curr.next;

			prev.next = next;
			this.size--;
			return curr.data;
		}
	}

	public T removelast() throws Exception {
		if (this.size == 0) {
			throw new Exception("list is empty");
		}
		T rv = this.tail.data;
		if (this.size == 1) {
			this.head = null;
			this.tail = null;
		} else {
			Node nm2 = this.getNodeAt(this.size - 2);
			nm2.next = null;
			this.tail = nm2;
		}
		this.size--;
		return rv;

	}

	public void addlast(T data) {
		Node node = new Node(data, null);
		if (this.size == 0) {
			this.head = node;
			this.tail = node;
		} else {
			this.tail.next = node;
			this.tail = node;
		}
		this.size++;
	}

	public T getfirst() throws Exception {
		if (this.isempty()) {
			throw new Exception("List is empty");
		}
		return this.head.data;
	}

	public T getlast() throws Exception {
		if (this.isempty()) {
			throw new Exception("List is empty");
		}
		return this.tail.data;
	}

	private Node getNodeAt(int idx) {
		Node rv = this.head;
		int counter = 0;
		while (counter < idx) {
			counter++;
			rv = rv.next;
		}
		return rv;
	}

	public T getat(int idx) throws Exception {
		if (this.isempty()) {
			throw new Exception("List is empty");
		}
		if (idx < 0 || idx >= this.size) {
			throw new Exception("index out of bound");
		}
		Node node = this.getNodeAt(idx);
		return node.data;
	}

	public int size() {
		return this.size;
	}

	public boolean isempty() {
		return this.size == 0;
	}

	public void display() {
		Node temp = this.head;
		while (temp != null) {
			System.out.println(temp.data + ",");
			temp = temp.next;
		}
	}

	public void reversePI() {
		Node prev = null, curr = this.head, next = curr.next;

		while (next != null) {
			curr.next = prev;

			prev = curr;
			curr = next;
			next = next.next;
		}
		// manage the remaining one
		curr.next = prev;
		// swap heads and tails
		Node temp = this.head;
		this.head = this.tail;
		this.tail = temp;
	}

	public void reverseDI() {

		int left = 0, right = this.size - 1;

		while (left <= right) {
			Node leftNode = this.getNodeAt(left);
			Node rightNode = this.getNodeAt(right);

			T temp = leftNode.data;
			leftNode.data = rightNode.data;
			rightNode.data = temp;

			left++;
			right--;
		}

	}

	public void swap(int idx1, int idx2) {
		Node leftNode = this.getNodeAt(idx1);
		Node rightNode = this.getNodeAt(idx2);
		T temp = leftNode.data;
		leftNode.data = rightNode.data;
		rightNode.data = temp;

	}

	public void eliminateduplicate() {
		Node rv = this.getNodeAt(0);
		while (rv.next != null) {
			if (rv.data == rv.next.data) {
				Node curr = rv.next;
				Node next = curr.next;

				rv.next = next;
				// rv=rv.next;
				this.size--;
			} else
				rv = rv.next;
		}
	}

	public void append(int n) throws Exception {
		Node n1 = this.getNodeAt(this.size - n);
		Node n2 = this.getNodeAt(this.size - n + 1);
		if (n >= this.size) {
			throw new Exception("index out of bound");
		} else if (n == 1) {
			this.getNodeAt(this.size - 2).next = null;
			n1.next = this.getNodeAt(0);
			this.head = n1;
		} else {
			while (n2.next != null) {
				n2 = n2.next;
			}
			this.getNodeAt(this.size - n - 1).next = null;
			n2.next = this.getNodeAt(0);
			this.head = n1;
		}
	}

	public void reversePR() {// reverse the linked list using pointer recurrsion
		this.reversePR(this.head);

		Node temp = this.head;
		this.head = this.tail;
		this.tail = temp;

		this.tail.next = null;

	}

	private void reversePR(Node right) {
		if (right == this.tail)
			return;
		this.reversePR(right.next);
		right.next.next = right;
	}

	private class heapmover {
		Node leftnode;

		heapmover(Node node) {
			this.leftnode = node;
		}
	}

	public void reverseDR() {
		heapmover left = new heapmover(this.head);
		this.reverseDR(left, this.head, 0);
	}

	public void reverseDR(heapmover left, Node right, int floor) {
		if (right == null)
			return;
		reverseDR(left, right.next, floor + 1);
		if (floor >= this.size / 2) {
			T temp = left.leftnode.data;
			left.leftnode.data = right.data;
			right.data = temp;
			left.leftnode = left.leftnode.next;
		}
	}

	public void fold() {
		heapmover left = new heapmover(this.head);
		this.fold(left, this.head, 0);
	}

	private void fold(heapmover left, Node right, int floor) {
		if (right == tail)
			return;
		fold(left, right.next, floor + 1);
		if (floor >= this.size / 2) {
			Node lnext = left.leftnode.next;
			Node rnext = right.next;
			// removal
			right.next = null;
			// add
			left.leftnode.next = rnext;
			rnext.next = lnext;
			// increment left
			left.leftnode = lnext;
			if (floor == this.size / 2)
				this.tail = right;
		}

	}

	public T midpointWsize() {
		Node temp = midnode();
		return temp.data;

	}

	private Node midnode() {
		Node slow = this.head;
		Node fast = this.head;
		while (fast.next != null && fast.next.next != null) {

			fast = fast.next.next;
			slow = slow.next;
		}
		return slow;
	}

	public void finds(int index)// for example if we enter 2 then second last
								// element is returned // i.e K`th element from
								// last
	{
		Node slow = this.head;
		Node fast = this.head;
		int counter = 1;
		while (counter <= index) {
			fast = fast.next;
			counter++;
		}

		while (fast != null) {
			slow = slow.next;
			fast = fast.next;
		}
		System.out.println(index + " th item from last is " + slow.data);
	}

	public int find(T data) {
		int rv = this.find(this.head, data);
		return rv;
	}

	private int find(Node node, T data) {
		if (node == null) {
			return -1;
		}

		if (node.data.equals(data)) {
			return 0;
		} else {
			int rv = find(node.next, data);

			if (rv == -1) {
				return rv;
			} else {
				return rv + 1;
			}
		}
	}
}
