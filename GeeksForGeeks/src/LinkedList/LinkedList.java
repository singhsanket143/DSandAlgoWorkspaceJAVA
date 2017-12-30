package LinkedList;

public class LinkedList {

	private class Node {
		int data;
		Node next;

		private Node(int data, Node next) {
			this.data = data;
			this.next = next;
		}

	}

	Node head;
	Node tail;
	int size;

	public LinkedList() {
		this.head = null;
		this.tail = null;
		this.size = 0;
	}

	public int size() {
		return this.size;
	}

	public boolean isEmpty() {
		return this.size == 0;
	}

	public void display() throws Exception {
		if (this.size == 0) {
			throw new Exception("List is empty");
		}
		Node temp = this.head;
		while (temp != null) {
			System.out.print(temp.data + ", ");
			temp = temp.next;
		}
	}

	public void addFirst(int data) {
		Node node = new Node(data, this.head);
		if (this.size == 0) {
			this.head = node;
			this.tail = node;
		} else {
			this.head = node;
		}
		this.size++;
	}

	public void addAt(int data, int idx) throws Exception {
		if (idx < 0 || idx > this.size) {
			throw new Exception("Index Out Of Bound");
		}
		if (this.isEmpty()) {
			this.addFirst(data);
		} else if (idx == this.size) {
			this.addLast(data);
		} else {
			Node nm1 = this.getNodeAt(idx - 1);
			Node rv = new Node(data, nm1.next);
			nm1.next = rv;
			this.size++;
		}

	}

	public void addLast(int data) {
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

	public int getFirst() throws Exception {
		if (this.size == 0) {
			throw new Exception("List is empty");
		}

		return this.head.data;
	}

	public int getlast() throws Exception {
		if (this.size == 0) {
			throw new Exception("List is empty");
		}

		return this.tail.data;
	}

	public int getAt(int idx) throws Exception {
		if (this.isEmpty()) {
			throw new Exception("List is Empty");
		}
		if (idx < 0 || idx >= this.size) {
			throw new Exception("Index out of bound");
		}

		Node node = getNodeAt(idx);
		return node.data;

	}

	public int removeFirst() throws Exception {
		if (this.size == 0) {
			throw new Exception("List is Empty");
		}
		int rv = this.head.data;
		if (this.size == 1) {
			this.head = null;
			this.tail = null;
		} else {
			this.head = this.head.next;
		}
		this.size--;
		return rv;
	}

	public int removeAt(int idx) throws Exception {
		if (this.isEmpty()) {
			throw new Exception("List is empty");
		}
		if (idx < 0 || idx >= this.size) {
			throw new Exception("Index Out of Bound");
		}
		if (idx == 0) {
			return this.removeFirst();
		} else if (idx == this.size - 1) {
			return this.removeLast();
		} else {
			Node prev = this.getNodeAt(idx - 1);
			Node curr = prev.next;
			Node next = curr.next;

			prev.next = next;
			this.size--;
			return curr.data;
		}
	}

	public int removeLast() throws Exception {
		if (this.isEmpty()) {
			throw new Exception("List is Empty");
		}
		int temp = this.tail.data;
		if (this.size == 1) {
			this.head = null;
			this.tail = null;
		} else {
			Node rv = this.getNodeAt(this.size - 2);
			rv.next = null;
			this.tail = rv;
		}
		this.size--;
		return temp;
	}

	public void reverseDI() {
		int left = 0, right = this.size - 1;
		while (left <= right) {
			Node node1 = this.getNodeAt(left);
			Node node2 = this.getNodeAt(right);

			int temp = node1.data;
			node1.data = node2.data;
			node2.data = temp;
			left++;
			right--;
		}
	}

	public void reversePI() {
		Node prev = null;
		Node curr = this.head;
		Node next = curr.next;

		while (next != null) {
			curr.next = prev;
			prev = curr;
			curr = next;
			next = next.next;
		}

		curr.next = prev;
		Node temp = this.head;
		this.head = this.tail;
		this.tail = temp;
	}

	public void reversePR() {
		this.reversePR(this.head);
		Node temp = this.head;
		this.head = this.tail;
		this.tail = temp;
		this.tail.next = null;
	}

	private void reversePR(Node right) {
		if (right == this.tail) {
			return;
		}
		reversePR(right.next);
		right.next.next = right;
	}

	public void reverseDR() {

		HeapMover mover = new HeapMover(this.head);
		this.reverseDR(mover, this.head, 0);
	}

	private void reverseDR(HeapMover left, Node right, int floor) {
		if (right == null) {
			return;
		}

		reverseDR(left, right.next, floor + 1);
		if (floor >= this.size / 2) {
			int temp = left.node.data;
			left.node.data = right.data;
			right.data = temp;

			left.node = left.node.next;
		}
	}

	public void fold() {

		HeapMover mover = new HeapMover(this.head);
		this.fold(mover, this.head, 0);
	}

	private void fold(HeapMover left, Node right, int floor) {
		if (right.next == null) {
			return;
		}

		fold(left, right.next, floor + 1);
		if (floor >= this.size / 2) {
			Node temp = right.next;
			right.next = null;
			Node temp2 = left.node.next;
			temp.next = temp2;
			left.node.next = temp;
			left.node = left.node.next.next;
			if (floor == this.size / 2)
				this.tail = right;
		}
	}

	public boolean isPalindrome() {
		HeapMover left = new HeapMover(this.head);

		return isPalindrome(left, this.head, 0);
	}

	private boolean isPalindrome(HeapMover left, Node right, int floor) {
		if (right == null)
			return true;

		boolean b = isPalindrome(left, right.next, floor + 1);

		if (b == true && floor >= size / 2) {
			if (left.node.data != right.data)
				return false;

			left.node = left.node.next;
		}

		return b;
	}

	public void rotate(int n) {
		Node node = this.getNodeAt(this.size - n - 1);
		this.tail.next = this.head;
		this.head = node.next;
		this.tail = node;
		this.tail.next = null;
	}

	public void kreverse(int k) {
		Node last = this.kreverse(this.head, k);
		Node temp = this.head;
		this.head = last;
		Node help = this.tail;
		while (help.next != null) {
			help = help.next;
		}
		this.tail = help;

	}

	private Node kreverse(Node node, int k) {
		Node prev = null;
		Node curr = node;
		Node next = null;
		int c = 0;
		while (c < k && curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
			c++;
		}
		if (next != null) {
			node.next = kreverse(next, k);
		} else if (next == null) {
			this.tail = prev;
		}
		return prev;

	}

	public void reverseDisplay() {
		this.reverseDsiplay(this.head);
	}

	private void reverseDsiplay(Node node) {
		if (node.next == null) {
			System.out.println(node.data);
			return;
		}
		reverseDsiplay(node.next);
		System.out.println(node.data);
	}

	public void append(int n) {
		Node slow = this.head, fast = this.head;
		int c = 0;
		while (c < n) {
			fast = fast.next;
			c++;
		}
		while (fast.next != null) {
			slow = slow.next;
			fast = fast.next;
		}
		Node temp = slow.next;
		slow.next = null;
		fast.next = this.head;
		this.head = temp;
	}

	public void appendLastN(int n) throws Exception {
		n=n%this.size;
		Node temp=this.getNodeAt(this.size-n+1);
		LinkedList result=new LinkedList();
		while(temp!=null){
			result.addLast(temp.data);
			temp=temp.next;
		}
		Node start=this.head;
		Node end=this.getNodeAt(this.size-n);
		while(start.next!=end){
			result.addLast(start.data);
			start=start.next;
		}
		this.head=result.head;
		this.tail=result.tail;
		

	}
	public void oddeven() {
		this.oddeven(this.head);
		Node temp = this.getNodeAt(this.size - 1);
		this.tail = temp;
		System.out.println(this.tail.data);
	}

	private void oddeven(Node node) {
		Node curr = node, next = node.next, prev = null;
		int i = 0;
		System.out.println(this.size);
		while (i < this.size) {
			if (prev != null) {
				if (curr.data % 2 != 0) {
					Node temp = curr;
					prev.next = curr.next;
					this.addLast(temp.data);
					this.size--;
					curr = prev.next;
					i++;
				} else {
					prev = curr;
					curr = curr.next;
					i++;
				}
			} else {
				if (curr.data % 2 != 0) {
					Node temp = curr;
					this.head = curr.next;
					this.addLast(temp.data);
					this.size--;
					curr = this.head;
					i++;
				} else {
					curr = curr.next;
					prev = this.head;
					i++;
				}
			}
		}

	}

	private class HeapMover {
		Node node;

		HeapMover(Node node) {
			this.node = node;
		}
	}

	public int kthItemfromLastIterative(int pos) throws Exception {
		if (pos <= 0 || pos > this.size) {
			throw new Exception("Invalid agrs");
		}
		Node slow = this.head;
		Node fast = this.head;
		for (int i = 0; i < pos; i++) {
			fast = fast.next;
		}
		while (fast != null) {
			slow = slow.next;
			fast = fast.next;
		}
		return slow.data;
	}

	public int kthItemFromLastRecursive(int pos) throws Exception {
		if (pos <= 0 || pos > this.size) {
			throw new Exception("Invalid args");
		}
		HMK mover = new HMK();
		mover.pos = pos;
		this.kthItemfromLastIterative(mover, this.head);
		return mover.data;
	}

	private void kthItemfromLastIterative(HMK mover, Node node) {
		if (node == null) {
			return;
		}

		kthItemfromLastIterative(mover, node.next);
		if (mover.pos > 0) {
			mover.pos--;
			if (mover.pos == 0) {
				mover.data = node.data;
			}
		}
	}

	public int mid() {
		return this.midnode().data;
	}

	private Node midnode() {
		Node slow = this.head, fast = this.head;
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}

	private class HMK {
		int pos;
		int data;
	}

	public void swap(int idx1, int idx2) {
		Node prev1 = this.getNodeAt(idx1 - 1);
		Node prev2 = this.getNodeAt(idx2 - 1);
		Node curr1 = prev1.next;
		Node curr2 = prev2.next;
		Node next1 = curr1.next;
		Node next2 = curr2.next;
		Node temp1 = curr1.next;
		curr1.next = next2;
		curr2.next = temp1;
		prev1.next = curr2;
		prev2.next = curr1;

	}

	public int countOccurence(int data) {
		int counter = 0;
		Node temp = this.head;
		while (temp != null) {
			if (temp.data == data) {
				counter++;
			}
			temp = temp.next;
		}
		return counter;
	}

	public void deleteLinkedList() {
		this.head = null;
		this.tail = null;
		this.size = 0;
	}

	public boolean cycleDeteection() throws Exception {
		Node slow = this.head, fast = this.head.next;
		while (true) {
			if (slow == null || fast == null) {
				System.out.println("no cycle");
				return false;
			} else if (slow == fast) {
				System.out.println("cycle detected");
				return true;
			}
			slow = slow.next;
			fast = fast.next.next;
		}
	}

	

	public void deleteNodeWithoutUsingHead(int idx) {
		this.deleteNodeWithoutUsingHead(this.getNodeAt(idx));
	}

	public void deleteNodeWithoutUsingHead(Node node) {
		Node temp = node.next;
		node.data = temp.data;
		node.next = temp.next;
	}

	public Node getNodeAt(int idx) {
		Node node = this.head;
		int counter = 0;
		while (counter < idx) {
			node = node.next;
			counter++;
		}
		return node;
	}
}
