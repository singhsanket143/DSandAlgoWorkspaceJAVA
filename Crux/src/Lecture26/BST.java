package Lecture26;

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
	private int counter;// for counting bst that lie in a range

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

	public void duplicate() {
		this.duplicate(this.root);
	}

	private void duplicate(Node node) {
		if (node.left == null || node.right == null) {
			Node temp = node.left;
			Node x = new Node(node.data, null, null);
			node.left = x;
			x.left = temp;
			return;
		}
		duplicate(node.left);
		Node temp = node.left;
		Node x = new Node(node.data, null, null);
		node.left = x;
		x.left = temp;
		duplicate(node.right);
		// Node temp1 = node.left;
		// Node x1 = new Node(node.data, null, null);
		// node.left = x1;
		// x1.left = temp1;

	}

	///////////////////// linear////////////////////////////////
	private class pair {
		Node head;
		Node tail;
	}

	public void linearbtr() {
		pair rp = this.linearbtr(this.root);
		this.root = rp.head;
	}

	private pair linearbtr(Node node) {
		if (node == null) {
			return null;
		}
		pair leftpair = this.linearbtr(node.left);
		pair rightpair = this.linearbtr(node.right);
		node.left = null;
		if (leftpair != null) {
			leftpair.tail.right = node;
		}
		if (rightpair != null) {
			node.right = rightpair.head;
		}
		pair pair = new pair();
		pair.head = leftpair == null ? node : leftpair.head;
		pair.tail = rightpair == null ? node : rightpair.tail;
		return pair;
	}

	//////////////////////////////////////////////////////////////////
	public void inrange(int lo, int hi) {
		this.inrange(this.root, lo, hi);
		System.out.println("END");
	}

	private void inrange(Node node, int lo, int hi) {
		if (node == null) {
			return;
		}
		if (node.data > hi) {
			this.inrange(node.left, lo, hi);
		} else if (node.data < lo) {
			this.inrange(node.right, lo, hi);
		} else {
			this.inrange(node.left, lo, hi);
			System.out.println(node.data);
			this.inrange(node.right, lo, hi);
		}

	}

	public void remove2(int data) {
		this.remove2(this.root, null, false, data);
	}

	private void remove2(Node node, Node parent, boolean ilc, int data) {
		if (node == null) {
			return;
		}
		if (data > node.data) {
			this.remove2(node.right, node, false, data);
		} else if (data < node.data) {
			this.remove2(node.left, node, true, data);
		} else {
			if (node.left != null && node.right != null) {
				int lmax = this.max(node.left);
				node.data = lmax;
				this.remove2(node.left, node, true, data);
			} else if (node.left != null) {
				if (ilc) {
					parent.left = node.left;
				} else {
					parent.right = node.left;
				}
			} else if (node.right != null) {
				if (ilc) {
					parent.left = node.right;
				} else {
					parent.right = node.right;
				}
			} else {
				if (ilc) {
					parent.left = null;
				} else {
					parent.right = null;
				}
			}
		}
	}

	public int size() {
		return this.size;
	}

	public boolean isempty() {
		return this.size == 0;
	}

	public void add(int data) {
		if (this.isempty()) {
			this.root = new Node(data, null, null);
			this.size++;
		} else {
			this.addnode(this.root, data);
		}
	}

	private void addnode(Node node, int data) {
		if (data > node.data) {
			if (node.right != null) {
				this.addnode(node.right, data);
			} else {
				node.right = new Node(data, null, null);
				this.size++;
			}
		} else if (data < node.data) {
			if (node.left != null) {
				this.addnode(node.left, data);
			} else {
				node.left = new Node(data, null, null);
				this.size++;
			}
		}

	}

	public void remove(int data) {
		this.remove(this.root, data);
	}

	private void remove(Node node, int data) {
		if (node.left != null && node.left.data == data && node.left.left == null && node.left.right == null) {
			node.left = null;
		} else if (node.right != null && node.right.data == data && node.right.left == null
				&& node.right.right == null) {
			node.right = null;
		} else if (node.right.data == data && node.right != null) {
			if (node.right.left != null && node.right.right == null) {
				node.right = node.right.left;
			} else if (node.right.left == null && node.right.right != null) {
				node.right = node.right.right;
			} else if (node.right.data == data && node.left != null && node.right != null) {
				Node temp = this.min2(node.right.left);
				temp.left = node.right.right;
				node.right = node.right.left;
			}

		} else if (node.left.data == data && node.left != null) {
			if (node.left.right == null && node.left.left != null) {
				node.left = node.left.right;
			} else if (node.left.right != null && node.left.left == null) {
				node.left = node.left.left;
			} else if (node.left.data == data && node.left != null && node.right != null) {
				Node temp = this.min2(node.left.right);
				temp.left = node.left.left;
				node.left = node.left.right;
			}
		} else {
			if (node.data >= data) {
				this.remove(node.left, data);
			} else
				this.remove(node.right, data);
		}
	}

	public void display() {
		this.display(this.root);
	}

	private void display(Node node) {
		if (node.left != null) {
			System.out.print(node.left.data + " =>");
		} else {
			System.out.print("END =>");
		}
		System.out.print(node.data + "<= ");
		if (node.right != null) {
			System.out.print(node.right.data);
		} else {
			System.out.print("END");
		}
		System.out.println();
		if (node.left != null) {
			this.display(node.left);
		}
		if (node.right != null) {
			this.display(node.right);
		}
	}

	public int size2() {
		return this.size2(this.root);
	}

	private int size2(Node node) {
		if (node == null) {
			return 0;
		}
		int rv = 0;
		int lsize = this.size2(node.left);
		int rsize = this.size2(node.right);
		rv = lsize + rsize + 1;
		return rv;
	}

	public int min() {
		return this.min(this.root);
	}

	private int min(Node node) {
		int rv = node.data;
		if (node.left != null) {
			rv = min(node.left);
		}
		return rv;
	}

	public Node min2() {
		return this.min2(this.root);
	}

	private Node min2(Node node) {
		Node rv = node;
		if (node.left != null) {
			rv = min2(node.left);
		}
		return rv;
	}

	public int max() {
		return this.max(this.root);
	}

	private int max(Node node) {
		int rv = node.data;
		if (node.right != null) {
			rv = max(node.right);
		}
		return rv;
	}

	public boolean find(int data) {
		return find(this.root, data);
	}

	private boolean find(Node node, int data) {
		if (node == null) {
			return false;
		}
		if (data < node.data) {
			return this.find(node.left, data);
		} else if (data > node.data) {
			return this.find(node.right, data);
		} else
			return true;
	}

	public void LeastCommonAncestor(int data1, int data2) {
		HashMap<Integer, Boolean> trackmap = new HashMap<>();
		this.LeastCommonAncestor(this.root, data1, trackmap);
		this.LeastCommonAncestor(this.root, data2, trackmap);
		Integer count = Integer.MAX_VALUE;
		Set<Map.Entry<Integer, Boolean>> allEntries = trackmap.entrySet();
		for (Map.Entry<Integer, Boolean> entry : allEntries) {
			if (entry.getValue()) {
				if (count > entry.getKey()) {
					count = entry.getKey();
				}
			}

		}
		if (count < Integer.MAX_VALUE)
			System.out.println(count);

	}

	private void LeastCommonAncestor(Node node, int data, HashMap<Integer, Boolean> trackmap) {
		if (this.isempty()) {
			return;
		}
		if (node == null) {
			return;
		}
		if (!find(data)) {
			System.out.println("inappropriate data");
			return;
		}
		if (trackmap.containsKey(node.data))
			trackmap.put(node.data, true);
		else
			trackmap.put(node.data, false);

		if (data < node.data) {
			LeastCommonAncestor(node.left, data, trackmap);
		} else if (data > node.data) {
			LeastCommonAncestor(node.right, data, trackmap);

		}
	}

	public int height() {
		return this.height(this.root);
	}

	private int height(Node node) {
		int maxheight = -1;
		if (node == null) {
			return -1;
		}
		int x = height(node.left);
		int y = height(node.right);

		maxheight = Math.max(x, y);
		maxheight += 1;
		return maxheight;
	}

	public void preorder() {
		this.preorder(this.root);
		System.out.println("END");
	}

	private void preorder(Node node) {
		if (node == null) {
			return;
		}
		System.out.print(node.data + " ");
		preorder(node.left);
		preorder(node.right);
	}

	public void postorder() {
		this.postorder(this.root);
		System.out.println("END");
	}

	private void postorder(Node node) {
		if (node == null) {
			return;
		}

		postorder(node.left);
		postorder(node.right);
		System.out.print(node.data + ",");
	}

	public void inorder() {
		this.inorder(this.root);
		System.out.println("END");
	}

	private void inorder(Node node) {
		if (node == null) {
			return;
		}

		inorder(node.left);
		System.out.print(node.data + " ");
		inorder(node.right);

	}

	public void levelorder() {
		LinkedList<Node> queue = new LinkedList<>();
		queue.addLast(this.root);
		while (!queue.isEmpty()) {
			Node temp = queue.removeFirst();
			System.out.print(temp.data + ",");
			if (temp.left != null) {
				queue.addLast(temp.left);
			}
			if (temp.right != null) {
				queue.addLast(temp.right);
			}
		}
		System.out.println("END");
	}

	public void levelorderzigzag() {
		LinkedList<Node> zig1 = new LinkedList<>();
		LinkedList<Node> zig2 = new LinkedList<>();
		zig1.addLast(this.root);
		int counter = 1, row = 0;
		while (!zig1.isEmpty() || !zig2.isEmpty()) {
			if (zig1.size() > zig2.size()) {
				row = zig1.size();
			} else {
				row = zig2.size();
			}
			while (row != 0) {
				if (counter % 2 != 0) {
					Node temp = zig1.removeFirst();
					System.out.println(temp.data + ",");
					if (temp.left != null) {
						zig2.addFirst(temp.left);
					}
					if (temp.right != null) {
						zig2.addFirst(temp.right);
					}

				} else if (counter % 2 == 0) {
					Node temp = zig2.removeFirst();
					System.out.println(temp.data + ",");
					if (temp.right != null) {
						zig1.addLast(temp.right);
					}
					if (temp.left != null) {
						zig1.addLast(temp.left);
					}

				}
				row--;
			}
			counter++;
		}

	}

	public void levelorderline() {
		LinkedList<Node> queue = new LinkedList<>();
		queue.addLast(this.root);

		while (!queue.isEmpty()) {
			int counter = queue.size();
			while (counter != 0) {
				Node temp = queue.removeFirst();
				System.out.print(temp.data + ",");

				if (temp.left != null) {
					queue.addLast(temp.left);
				}
				if (temp.right != null) {
					queue.addLast(temp.right);
				}
				counter--;
			}
			System.out.println();

		}
		System.out.println("END");
	}

	public void preorderitereative() {
		LinkedList<Node> stack = new LinkedList<>();
		stack.addFirst(this.root);// push
		while (!stack.isEmpty()) {
			Node temp = stack.removeFirst();// pop
			System.out.print(temp.data + ",");
			if (temp.right != null) {
				stack.addLast(temp.right);
			}
			if (temp.left != null) {
				stack.addLast(temp.left);
			}
		}
		System.out.println("END");
	}

	public int diameter() {
		return this.diameter(this.root);
	}

	private int diameter(Node node) {
		if (node == null) {
			return 0;
		}
		int lh = this.height(node.left);
		int rh = this.height(node.right);
		int ld = this.diameter(node.left);
		int rd = this.diameter(node.right);
		int f1 = ld, f2 = rd, f3 = lh + rh + 2;
		return Math.max(f1, Math.max(f2, f3));
	}

	private class DiaPair {
		int height;
		int diameter;
	}

	public int diameterbtr() {
		DiaPair rootpair = this.diameterbtr(this.root);
		return rootpair.diameter;
	}

	private DiaPair diameterbtr(Node node) {
		if (node == null) {
			DiaPair basepair = new DiaPair();
			basepair.height = -1;
			basepair.diameter = 0;
			return basepair;
		}
		DiaPair lpair = this.diameterbtr(node.left);
		DiaPair rpair = this.diameterbtr(node.right);
		DiaPair mypair = new DiaPair();
		mypair.height = Math.max(lpair.height, rpair.height) + 1;
		int f1 = lpair.diameter;
		int f2 = rpair.diameter;
		int f3 = lpair.height + rpair.height + 2;
		mypair.diameter = Math.max(f1, Math.max(f2, f3));
		return mypair;

	}

	public void printNodesSumToS(int s) {
		this.printNodesSumToS(this.root, s);
	}

	private int countNodes(Node root) {
		if (root == null) {
			return 0;
		}
		return countNodes(root.left) + countNodes(root.right) + 1;
	}

	private void printNodesSumToS(Node node, int s) {
		if (node == null) {
			return;
		}
		int totalCount = countNodes(root);
		int count = 0;
		Stack<Node> inorder = new Stack();
		Stack<Node> reorder = new Stack();
		Node temp = node;
		while (temp != null) {
			inorder.push(temp);
			temp = temp.left;
		}
		temp = node;
		while (temp != null) {
			reorder.push(temp);
			temp = temp.right;
		}
		while (count < totalCount - 1) {
			Node top1 = inorder.peek();
			Node top2 = reorder.peek();
			if (top1.data + top2.data == s) {
				System.out.println(top1.data + " " + top2.data);
				Node top = top1;
				inorder.pop();
				count++;
				if (top.right != null) {
					top = top.right;
					while (top != null) {
						inorder.push(top);
						top = top.left;
					}
				}
				top = top2;
				reorder.pop();
				count++;
				if (top.left != null) {
					top = top.left;
					while (top != null) {
						reorder.push(top);
						top = top.right;
					}
				}
			} else if (top1.data + top2.data > s) {
				Node top = top2;
				reorder.pop();
				count++;
				if (top.left != null) {
					top = top.left;
					while (top != null) {
						reorder.push(top);
						top = top.right;
					}
				}
			} else {
				Node top = top1;
				inorder.pop();
				count++;
				if (top.right != null) {
					top = top.right;
					while (top != null) {
						inorder.push(top);
						top = top.left;
					}
				}
			}
		}
	}

	public void modifyBST() {
		int[] arr = { 0 };
		this.modifyBSTwithgreaterelementssum(this.root, arr);
	}

	private void modifyBSTwithgreaterelementssum(Node node, int[] sum) {
		if (node == null)
			return;
		modifyBSTwithgreaterelementssum(node.right, sum);
		sum[0] += node.data;
		node.data = sum[0];
		modifyBSTwithgreaterelementssum(node.left, sum);
	}

	private void insertWithGettingInordersucc(Node node, int data, Node succ) {
		if (node == null) {
			node = new Node(data, null, null);
		}
		if (data < node.data) {
			succ = node;
			insertWithGettingInordersucc(node.left, data, succ);
		} else if (data > node.data) {
			insertWithGettingInordersucc(node.right, data, succ);
		}
	}

	public int findMedian() {
		return this.findMedian(this.root);
	}

	private void morrisInordertraversal(Node node) {
		Node current, pre;
		if (root == null) {
			return;
		}
		current = root;
		while (current != null) {
			if (current.left == null) {
				System.out.print(current.data + " ");
				current = current.right;
			} else {
				pre = current.left;
				while (pre.right != null && pre.right != current) {
					pre = pre.right;
				}
				if (pre.right == null) {
					pre.right = current;
					current = current.left;
				} else {
					pre.right = null;
					System.out.print(current.data + " ");
					current = current.right;
				}
			}
		}
	}

	private int countNodesUsingMorris(Node node) {
		Node current, pre;
		int count = 0;
		if (root == null) {
			return count;
		}
		current = root;
		while (current != null) {
			if (current.left == null) {
				count++;
				// System.out.print(current.data + " ");
				current = current.right;
			} else {
				pre = current.left;
				while (pre.right != null && pre.right != current) {
					pre = pre.right;
				}
				if (pre.right == null) {
					pre.right = current;
					current = current.left;
				} else {
					pre.right = null;
					// System.out.print(current.data + " ");
					count++;
					current = current.right;
				}
			}
		}
		return count;
	}

	private int findMedian(Node node) {
		Node current, pre, prev = new Node(0, null, null);
		if (root == null) {
			return 0;
		}
		int count = this.countNodes(node);
		int currCount = 0;
		current = root;
		while (current != null) {
			if (current.left == null) {
				// System.out.print(current.data + " ");
				currCount++;
				if (count % 2 != 0 && currCount == (count + 1) / 2) {
					return prev.data;
				} else if (count % 2 == 0 && currCount == ((count) / 2) + 1) {
					return (prev.data + current.data) / 2;
				}
				prev = current;
				current = current.right;
			} else {
				pre = current.left;
				while (pre.right != null && pre.right != current) {
					pre = pre.right;
				}
				if (pre.right == null) {
					pre.right = current;
					current = current.left;
				} else {
					pre.right = null;
					prev = pre;
					// System.out.print(current.data + " ");
					currCount++;
					if (count % 2 != 0 && currCount == (count + 1) / 2) {
						return current.data;
					} else if (count % 2 == 0 && currCount == ((count) / 2) + 1) {
						return (prev.data + current.data) / 2;
					}
					prev = current;
					current = current.right;
				}
			}
		}
		return -1;
	}

	public int findSubtrees(int min, int max) {
		findSubtrees(this.root, min, max);
		
		return counter;
	}

	private boolean findSubtrees(Node node, int min, int max) {
		if (node == null) {
			return true;
		}
		boolean l = (node.left!=null)?(findSubtrees(node.left, min, max)):true;
		boolean r = (node.right!=null)?(findSubtrees(node.right, min, max)):true;
		
		if(l & r & currentIsInRange(node.data, min, max)) {
			++counter;
			return true;
		}
		return false;
	}

	private boolean currentIsInRange(int key, int min, int max) {
		// TODO Auto-generated method stub
		return key >= min && key <= max;
	}

}
