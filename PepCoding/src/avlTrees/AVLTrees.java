package avlTrees;

public class AVLTrees {

	private class Node {
		int height;
		int data;
		Node left;
		Node right;

		Node(int data) {
			this.data = data;
			this.height = 1;
		}
	}

	private Node root;
	
	public void insert(int item) {
		this.root = insert(this.root, item);
	}

	private Node insert(Node node, int item) {
		if (node == null) {
			Node newNode = new Node(item);
			return newNode;
		}
		if (item > node.data) {
			node.right = insert(node.right, item);
		} else {
			node.left = insert(node.left, item);
		}
		node.height = Math.max(height(node.left), height(node.right)) + 1;
		int balancingfactor = this.balancingFactor(node);
		// LL case
		if (balancingfactor > 1 && item < node.left.data) {
			return this.rightRotate(node);
		}
		// RR case
		if (balancingfactor < -1 && item > node.right.data) {
			return this.leftRotate(node);
		}
		// LR case
		if (balancingfactor > 1 && item > node.left.data) {
			node.left = this.leftRotate(node.left);
			return this.rightRotate(node);
		}
		// RL case
		if (balancingfactor < -1 && item < node.right.data) {
			node.right = this.rightRotate(node.right);
			return this.leftRotate(node);
		}
		return node;
	}

	private int height(Node node) {
		if (node == null) {
			return 0;
		}
		return node.height;
	}

	private int balancingFactor(Node node) {
		if (node == null) {
			return 0;
		}
		return height(node.left) - height(node.right);
	}

	private Node rightRotate(Node C) {
		Node B = C.left;
		Node T3 = B.right;

		// Rotate
		B.right = C;
		C.left = T3;

		// Height Update
		C.height = Math.max(height(C.left), height(C.right)) + 1;
		B.height = Math.max(height(B.left), height(B.right)) + 1;
		return B;
	}

	private Node leftRotate(Node C) {
		Node B = C.right;
		Node T3 = B.left;

		// Rotate
		B.left = C;
		C.right = T3;

		// Height Update
		C.height = Math.max(height(C.left), height(C.right)) + 1;
		B.height = Math.max(height(B.left), height(B.right)) + 1;
		return B;
	}

	public void display() {
		display(this.root);
	}

	private void display(Node node) {
		if (node == null) {
			return;
		}
		String str = "";
		if (node.left == null) {
			str += ".";
		} else {
			str += node.left.data;
		}
		str += "=> " + node.data + " <=";
		if (node.right == null) {
			str += ".";
		} else {
			str += node.right.data;
		}
		System.out.println(str);
		display(node.left);
		display(node.right);
	}

}
