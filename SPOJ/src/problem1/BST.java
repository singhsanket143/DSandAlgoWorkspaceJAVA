package problem1;

import java.util.*;

public class BST {
	private class Node {
		
		int data;
		Node left;
		Node right;

		Node(int data, Node left, Node right) {
			this.data = data;
			this.left = left;
			this.right = right;
		}
	}

	private Node root;
	private int size;
	private int counter;

	public BST(int... sa) {
		this.root = this.construct(sa, 0, sa.length - 1);
	}

	private Node construct(int[] sa, int lo, int hi) {
		if (lo > hi) {
			return null;
		}
		int mid = (lo + hi) / 2;
		Node rv = new Node(sa[mid], null, null);
		this.size++;
		rv.left = this.construct(sa, lo, mid - 1);
		rv.right = this.construct(sa, mid + 1, hi);
		return rv;
	}

	public int findSubtrees(int min, int max) {
		if (findSubtrees(this.root, min, max)) {
			counter += 1;
		}
		return counter;
	}

	private boolean findSubtrees(Node node, int min, int max) {
		if (node == null) {
			return true;
		}
		boolean l = findSubtrees(node.left, min, max);
		boolean r = findSubtrees(node.right, min, max);

		// If both fall within range and current node is in range, continue.
		if (l && r && currentIsInRange(node.data, min, max))
			return true;
		else if (l && r && !currentIsInRange(node.data, min, max) && node.left != null && node.right != null) {
			// System.out.println("Both left and right subtree fall within range but that
			// node doesnt.");
			counter += 2;
			return false;
		} else if ((l && node.left != null) || (r && node.right != null)) {
			// System.out.println("Has either left or right subtree that falls within
			// range");
			counter++;
			return false;
		}
		return false;
	}

	private boolean currentIsInRange(int key, int min, int max) {
		// TODO Auto-generated method stub
		return key >= min && key <= max;
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
			int[] arr = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = scn.nextInt();
			}
//			int s = scn.nextInt();
			BST b = new BST(arr);
			int l=scn.nextInt();
			int r=scn.nextInt();
			System.out.println(b.findSubtrees(l, r));
//		b.printNodesSumToS(s);
	}

}
