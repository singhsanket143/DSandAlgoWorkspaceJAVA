package Lecture24;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class GenericTree {

	private class Node {
		int data;
		ArrayList<Node> children;

		public Node(int data) {
			this.data = data;
			this.children = new ArrayList<>();
		}
	}

	private Node root;
	private int size;

	public GenericTree() {
		Scanner scn = new Scanner(System.in);
		this.root = this.takeinput(scn, null, -1);
	}

	public int size() {
		return this.size;
	}

	public boolean isempty() {
		return this.size == 0;
	}

	private Node takeinput(Scanner scn, Node Parent, int i) {
		if (Parent == null) {
			System.out.println("Enter the data for root node");
		} else {
			System.out.println("Enter the data for " + i + "th" + "child of" + Parent.data);
		}
		int data = scn.nextInt();
		System.out.println("Enter the no. of children for" + data);
		int nc = scn.nextInt();
		Node child = new Node(data);
		for (i = 0; i < nc; i++) {
			Node grandchild = this.takeinput(scn, child, i);
			child.children.add(grandchild);
		}
		return child;

	}

	public void display() {
		this.display(this.root);
	}

	private void display(Node node) {
		System.out.print(node.data + "=>");
		for (int i = 0; i < node.children.size(); i++) {
			System.out.print(node.children.get(i).data + ",");
		}
		System.out.println("END");
		for (int i = 0; i < node.children.size(); i++) {
			this.display(node.children.get(i));
		}
	}

	/////// Code to get the size of the tree///////////
	public int size2() {
		return this.size2(this.root);
	}

	private int size2(Node node) {
		int rv = 0;
		for (int i = 0; i < node.children.size(); i++) {
			int childtreesize = this.size2(node.children.get(i));
			rv += childtreesize;
		}
		// for node itself
		rv += 1;
		return rv;
	}
	///////////////////////////////////////////////////////

	/////// Code to get the height of the tree///////////

	public int height() {
		return this.height(this.root);
	}

	private int height(Node node) {
		int maxchildheight = -1; // for leaf node if we dont do this then the
									// program will return height +1
		for (Node child : node.children) {
			int ch = this.height(child);
			if (ch > maxchildheight) {
				maxchildheight = ch;
			}
		}
		// for node itself
		maxchildheight += 1;
		return maxchildheight;
	}

	/////////////////////////////////////////////////////////////

	/////// Code to get the max of the tree///////////
	public int max() {
		return this.max(this.root);
	}

	private int max(Node node) {
		int rv = Integer.MIN_VALUE;// or int rv=node.data

		for (int i = 0; i < node.children.size(); i++) {
			int value = this.max(node.children.get(i));
			if (value > rv) {
				rv = value;
			}
		}
		if (rv < node.data) {
			return node.data;
		}
		return rv;
	}

	/////////////////////////////////////////////////////////
	/////// Code to get the find data in the tree///////////
	public boolean find(int data) {
		return this.find(data, this.root);
	}

	private boolean find(int data, Node node) {
		if (data == node.data) {
			return true;
		}
		for (int i = 0; i < node.children.size(); i++) {
			boolean value = this.find(data, node.children.get(i));
			if (value) {
				return true;
			}
		}

		return false;
	}

	/////////////////////////////////////////////////////
	public void mirror() {
		this.mirror(this.root);
	}

	private void mirror(Node node) {
		for (int i = 0; i < node.children.size(); i++) {
			this.mirror(node.children.get(i));
		}
		int left = 0, right = node.children.size() - 1;
		while (left <= right) {
			Node temp = node.children.get(left);
			node.children.set(left, node.children.get(right));
			node.children.set(right, temp);
			left++;
			right--;
		}
	}

	////////////////// Code to LINEARIZE///////////////////
	/*
	 * but this is code is quite inefficient as in the getTAIL code we are
	 * calculating the data of one node more than once that should be avoided in
	 * oreder to save the complexity
	 */
	public void linear() {
		this.linear(this.root);
	}

	private void linear(Node node) {

		for (int i = 0; i < node.children.size(); i++) {
			this.linear(node.children.get(i));
		}
		while (node.children.size() > 1) {
			Node removed = node.children.remove(1);
			Node zerokTail = this.getTail(node.children.get(0));
			zerokTail.children.add(removed);
		}

	}
	
	public int countLeafNode(){
		return this.countLeafNode(this.root);
	}
	private int countLeafNode(Node node){
		int rv=0;
		if(node.children.size()==0){
			return 1;
		} 
		
		for(int i=0;i<node.children.size();i++){
			rv+=countLeafNode(node.children.get(i));
			
		}
		return rv;
	}

	private Node getTail(Node node) {
		Node temp = node;
		while (temp.children.size() != 0) {
			temp = temp.children.get(0);
		}
		return temp;
	}

	///////////////////////// Better code///////////9i///////////////////////
	private class HeapMover1 {
		Node head;
		Node tail;

		HeapMover1(Node head, Node tail) {
			this.head = head;
			this.tail = tail;
		}
	}

	public void linearbtr() {
		this.linearbtr(this.root);

	}

	private HeapMover1 linearbtr(Node node) {
		if (node.children.size() == 0) {
			return new HeapMover1(node, node);
		}
		HeapMover1 prev = this.linearbtr(node.children.get(0));

		while (node.children.size() > 1) {
			// remove
			Node removed = node.children.remove(1);
			// linearize the removed one
			HeapMover1 curr = this.linearbtr(removed);
			// add
			prev.tail.children.add(removed);
			// update prev tail
			prev.tail = curr.tail;
		}
		// update prev head
		prev.head = node;
		return prev;
	}

	///////////////////////////////////////////////////////////
	public void print() {
		this.print(0, this.root);
	}

	private void print(int data, Node node) {
		data = node.data;
		for (int i = 0; i < node.children.size(); i++) {
			print(data, node.children.get(i));
			System.out.println(node.children.get(i).data);
		}
	}

	/////////////////////////////////////////////////
	////// TREE TRAVERSING///////////////////////////
	public void preorder() {
		this.preorder(this.root);
	}

	private void preorder(Node n) {
		System.out.println(n.data);
		for (Node child : n.children) {
			preorder(child);
		}
	}

	public void preorderitereative() {
		LinkedList<Node> stack = new LinkedList<>();
		stack.addFirst(this.root);// push
		while (!stack.isEmpty()) {
			Node temp = stack.removeFirst();// pop
			System.out.println(temp.data + ",");
			for (int i = temp.children.size() - 1; i >= 0; i--) {
				stack.addFirst(temp.children.get(i));
			}
		}
		System.out.println("END");
	}

	public void postorder() {
		this.postorder(this.root);
	}

	private void postorder(Node n) {

		for (Node child : n.children) {
			postorder(child);
		}
		System.out.println(n.data);
	}

	public void levelorder() {
		LinkedList<Node> queue = new LinkedList<>();
		queue.addLast(this.root);
		while (!queue.isEmpty()) {
			Node temp = queue.removeFirst();
			System.out.println(temp.data + ",");
			for (Node child : temp.children) {
				queue.addLast(child);
			}
		}
		System.out.println("END");
	}
	//////// TREE TRAVERSING/////////////////////////
	///////////////////////////////////////////////

	public Integer justLarger(int data) {
		Node jl = justLarger(this.root, data);

		if (jl != null) {
			return jl.data;
		} else {
			return null;
		}
	}

	private Node justLarger(Node node, int data) {
		Node rv = null;

		if (node.data > data) {
			rv = node;
		}

		for (int i = 0; i < node.children.size(); i++) {
			Node cjl = this.justLarger(node.children.get(i), data);

			if (cjl == null) {
				continue;
			} else {
				if (rv == null) {
					rv = cjl;
				} else {
					if (cjl.data < rv.data) {
						rv = cjl;
					}
				}
			}
		}

		return rv;
	}
	
	public Integer justSmaller(int data) {
		Node jl = justSmaller(this.root, data);

		if (jl != null) {
			return jl.data;
		} else {
			return null;
		}
	}

	private Node justSmaller(Node node, int data) {
		Node rv = null;

		if (node.data < data) {
			rv = node;
		}

		for (int i = 0; i < node.children.size(); i++) {
			Node cjl = this.justSmaller(node.children.get(i), data);

			if (cjl == null) {
				continue;
			} else {
				if (rv == null) {
					rv = cjl;
				} else {
					if (cjl.data > rv.data) {
						rv = cjl;
					}
				}
			}
		}

		return rv;
	}
	
	public int kthLargest(int k) {
		int rv = Integer.MAX_VALUE;

		int counter = 0;
		while (counter < k) {
			rv = justSmaller(this.root, rv).data;
			counter++;
		}

		return rv;
	}

	public int kthSmallest(int k) {
		int rv = Integer.MIN_VALUE;

		int counter = 0;
		while (counter < k) {
			rv = justLarger(this.root, rv).data;
			counter++;
		}

		return rv;
	}


	///// The SONC code//////////////////
	////////// SONC stands for sumof node and child////
	/*
	 * but this is code is quite inefficient as in the getSONC code we are
	 * calculating the data of one node more than once that should be avoided in
	 * oreder to save the complexity
	 */
	public int maxSONC() {
		return this.maxSONC(this.root).data;
	}

	private Node maxSONC(Node node) {

		Node rv = node;
		for (Node child : node.children) {
			Node cmax = maxSONC(child);
			int cmaxscore = getSONC(cmax);
			int rvscore = getSONC(rv);
			if (cmaxscore > rvscore) {
				rv = cmax;
			}
		}
		return rv;
	}

	private int getSONC(Node node) {

		int rv = node.data;
		for (Node child : node.children) {
			rv += child.data;
		}
		return rv;
	}

	////////////////////////// Now BETTER code///////////
	/*
	 * here a heapmover object is made once each tym when sonc of a node is
	 * calculated which will make the code run once for each node not like the
	 * above one in which every node's SONC is calculated more than once
	 */
	private class HeapMover {
		Node node;
		int SONCscore;

		HeapMover(Node node) {
			this.node = node;
			this.SONCscore = getSONC(node);
		}
	}

	public int maxSONC2() {
		HeapMover mover = this.maxSONC2(this.root);
		return mover.node.data;
	}

	private HeapMover maxSONC2(Node node) {

		HeapMover rv = new HeapMover(node);
		for (Node child : node.children) {
			HeapMover cmax = maxSONC2(child);

			if (cmax.SONCscore > rv.SONCscore) {
				rv = cmax;
			}
		}
		return rv;
	}
	///////////////////////////////////////////////////////////

	/////////// Code to find the RANGE///////////////////////////
	private class HeapMover2 {
		int min;
		int max;

		HeapMover2(Node node) {
			this.min = node.data;
			this.max = node.data;
		}

		// for range2
		public HeapMover2() {
			this.min = Integer.MAX_VALUE;
			this.max = Integer.MIN_VALUE;
		}
	}

	public int range() {
		HeapMover2 mover = this.range(this.root);
		return mover.max - mover.min;
	}

	private HeapMover2 range(Node node) {
		HeapMover2 rv = new HeapMover2(node);
		for (int i = 0; i < node.children.size(); i++) {
			HeapMover2 val = this.range(node.children.get(i));
			if (rv.min > val.min) {
				rv.min = val.min;

			}
			if (rv.max < val.max) {
				rv.max = val.max;
			}
		}
		return rv;
	}

	///////////////////////////////////////////////////////
	///////////////// Much better range//////////////////////

	public int range2() {
		HeapMover2 mover = new HeapMover2();
		this.range2(this.root, mover);
		return mover.max - mover.min;
	}

	private void range2(Node node, HeapMover2 n) {
		if (node.data < n.min) {
			n.min = node.data;
		}
		if (node.data > n.max) {
			n.max = node.data;
		}
		for (Node child : node.children) {
			range2(child, n);
		}
	}
}
