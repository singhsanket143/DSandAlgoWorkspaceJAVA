package GenericTree;

import java.util.ArrayList;
import java.util.Scanner;

public class GenericTree {

	private class Node {
		int data;
		ArrayList<Node> Children;

		public Node(int data) {
			this.data = data;
			this.Children = new ArrayList<>();
		}
	}

	Node root;
	int size;

	public GenericTree() {

		Scanner scn = new Scanner(System.in);
		this.root = this.takeInput(scn, null, -1);
	}

	private Node takeInput(Scanner scn, Node Parent, int i) {
		if (Parent == null) {
			System.out.println("Enter the data for Root node");
		} else {
			System.out.println("Enter the data for " + i + "th child of " + Parent.data);
		}

		int data = scn.nextInt();
		System.out.println("Enter the number of children for " + data);
		int nc = scn.nextInt();
		Node child = new Node(data);
		this.size++;
		for (int k = 0; k < nc; k++) {
			Node grandChild = this.takeInput(scn, child, k);
			child.Children.add(grandChild);
		}

		return child;
	}

	public int size() {
		return this.size;
	}

	public boolean isEmpty() {
		return this.size == 0;
	}

	public void display() {
		this.display(this.root);
	}

	private void display(Node node) {
		System.out.print(node.data + "=>");
		for (int i = 0; i < node.Children.size(); i++) {
			System.out.print(node.Children.get(i).data + ", ");
		}
		System.out.println("END");
		for (int i = 0; i < node.Children.size(); i++) {
			this.display(node.Children.get(i));
		}
	}
}
