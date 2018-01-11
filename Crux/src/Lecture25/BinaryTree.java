package Lecture25;

import java.util.LinkedList;
import java.util.Scanner;

public class BinaryTree {

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

	public int size() {
		return this.size;
	}

	public boolean isempty() {
		return this.size == 0;
	}

	public BinaryTree() {
		Scanner scn = new Scanner(System.in);
		this.root = this.takeinput(scn, null, false);
	}

	private Node takeinput(Scanner scn, Node parent, boolean leftorright) {
		if (parent == null) {
			System.out.println("Enter the data for root");
		} else {
			if (leftorright) {
				System.out.println("Enter the data for left child of" + parent.data);
			} else {
				System.out.println("Enter the data for right child of" + parent.data);
			}
		}
		int cdata = scn.nextInt();
		Node child = new Node(cdata, null, null);
		this.size++;
		boolean choice = false;
		System.out.println("Do you want have left child for" + child.data);
		choice = scn.nextBoolean();
		if (choice) {
			child.left = this.takeinput(scn, child, true);
		}
		System.out.println("Do you have a right child");
		choice = scn.nextBoolean();
		if (choice) {
			child.right = this.takeinput(scn, child, false);
		}
		return child;
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
		if (node == null) {
			return Integer.MAX_VALUE;
		}
		int rv = node.data;
		int lmin = this.min(node.left);
		int rmin = this.min(node.right);
		rv = Math.min(rv, Math.min(lmin, rmin));
		return rv;
	}

	public int max() {
		return this.max(this.root);
	}

	private int max(Node node) {
		if (node == null) {
			return Integer.MIN_VALUE;
		}
		int rv = node.data;
		int lmax = this.max(node.left);
		int rmax = this.max(node.right);
		rv = Math.max(rv, Math.max(lmax, rmax));
		return rv;
	}

	public boolean find(int data) {
		return find(this.root, data);
	}

	private boolean find(Node node, int data) {
		if (node == null) {
			return false;
		}
		if (node.data == data) {
			return true;
		} else if (this.find(node.left, data) == true) {
			return true;
		} else if (this.find(node.right, data) == true) {
			return true;
		} else {
			return false;
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

	public void mirror() {
		this.mirror(this.root);
	}

	private void mirror(Node node) {
		if (node == null) {
			return;
		}
		mirror(node.left);
		mirror(node.right);
		Node temp = node.left;
		node.left = node.right;
		node.right = temp;
	}

	public void preorder() {
		this.preorder(this.root);
		System.out.println("END");
	}

	private void preorder(Node node) {
		if (node == null) {
			return;
		}
		System.out.print(node.data + ",");
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
		System.out.print(node.data + ",");
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

	private class HeapMover {
		Node pred;
		Node succ;
		Node item;
	}

	public Integer postorderpred(int data) {
		HeapMover mover = new HeapMover();
		this.postorderpredsucc(data, this.root, mover);
		return mover.pred == null ? null : mover.pred.data;
	}

	public Integer postordersucc(int data) {
		HeapMover mover = new HeapMover();
		this.postorderpredsucc(data, this.root, mover);
		return mover.succ == null ? null : mover.succ.data;
	}

	private void postorderpredsucc(int data, Node node, HeapMover mover) {
		if (node == null) {
			return;
		}

		postorderpredsucc(data, node.left, mover);
		postorderpredsucc(data, node.right, mover);
		if (mover.item == null) {
			if (node.data == data) {
				mover.item = node;
			} else {
				mover.pred = node;
			}
		} else {
			if (mover.succ == null) {
				mover.succ = node;
			}
		}
	}

	////////////////////////////// MultiCalculator///////////////////////////
	private void multiCalculator(Node node, HeapMoverMulti multi, int level) {
		if (node == null) {
			return;
		}

		// work area

		multi.size += 1;
		multi.sum += node.data;

		if (level > multi.level) {
			multi.level = level;
		}

		if (node.data < multi.min) {
			multi.min = node.data;
		}

		if (node.data > multi.max) {
			multi.max = node.data;
		}

		multiCalculator(node.left, multi, level + 1);
		multiCalculator(node.right, multi, level + 1);
	}

	public void multiCalculator() {
		HeapMoverMulti multi = new HeapMoverMulti();

		multi.max = Integer.MIN_VALUE;
		multi.min = Integer.MAX_VALUE;

		this.multiCalculator(this.root, multi, 0);

		System.out.println(multi.size);
		System.out.println(multi.level);
		System.out.println(multi.min);
		System.out.println(multi.max);
		System.out.println(multi.sum);
	}

	private class HeapMoverMulti {
		int size;
		int sum;
		int min;
		int max;
		int level;

	}

	/////////////////// New Constructor//////////

	public BinaryTree(int[] pre, int[] in) {
		// this.root = this.construct(pre, 0, pre.length - 1, in, 0, in.length -
		// 1);//for preorder
		this.root = this.construct1(pre, 0, pre.length - 1, in, 0, in.length - 1, true);// for
																						// postorder

	}

	private Node construct(int[] pre, int psi, int pei, int[] in, int isi, int iei) {
		if (psi > pei || isi > iei) {
			return null;
		}
		Node rv = new Node(pre[psi], null, null);
		this.size++;
		int si = -1;
		for (int i = isi; i <= iei; i++) {
			if (in[i] == pre[psi]) {
				si = i;
				break;
			}
		}
		int numitems = si - isi;
		rv.left = this.construct(pre, psi + 1, psi + numitems, in, isi, si - 1);
		rv.right = this.construct(pre, psi + numitems + 1, pei, in, si + 1, iei);
		return rv;
	}

	private Node construct1(int[] post, int psi, int pei, int[] in, int isi, int iei, boolean kill) {
		if (psi > pei || isi > iei) {
			return null;
		}
		Node rv = new Node(post[pei], null, null);
		this.size++;
		int si = -1;
		for (int i = isi; i <= iei; i++) {
			if (in[i] == post[pei]) {
				si = i;
				break;
			}
		}
		int numitems = si - isi;
		rv.left = this.construct1(post, psi, psi + numitems - 1, in, isi, si - 1, true);
		rv.right = this.construct1(post, psi + numitems, pei - 1, in, si + 1, iei, true);
		return rv;
	}
	
	// private class sizer{
	// int size;
	// }
	// public int largestbstsize(){
	//
	// }
	// private int largestbstsize(Node node){
	// int lsize=this.largestbstsize(node.left);
	// int rsize=this.largestbstsize(node.right);
	//
	// }

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

	public boolean isbst() {
		return this.isbst(this.root);
	}

	private boolean isbst(Node node) {
		if (node == null) {
			return true;
		}
		int lmax = this.max(node.left);
		int rmin = this.min(node.right);
		if (node.data < lmax) {
			return false;
		}
		if (node.data > rmin) {
			return false;
		}
		boolean isleftbst = this.isbst(node.left);
		boolean isrightbst = this.isbst(node.right);
		return isleftbst && isrightbst;
	}

	private class bsttriplet {
		boolean isbst;
		int max;
		int min;
		// public bsttriplet(boolean isbst,int leftmax,int rightmin){
		// this.isbst=isbst;
		// this.leftmax=leftmax;
		// this.rightmin=rightmin;
		// }
	}

	public boolean isbstbtr() {
		bsttriplet bst = new bsttriplet();
		bst = this.isbstbtr(this.root);
		return bst.isbst;
	}

	private bsttriplet isbstbtr(Node node) {
		if (node == null) {
			bsttriplet bt = new bsttriplet();
			bt.isbst = true;
			bt.max = Integer.MIN_VALUE;
			bt.min = Integer.MAX_VALUE;
			return bt;
		}
		bsttriplet lt = this.isbstbtr(node.left);
		bsttriplet rt = this.isbstbtr(node.right);
		bsttriplet mt = new bsttriplet();
		if (!lt.isbst || !rt.isbst || lt.max > node.data || rt.min < node.data) {
			mt.isbst = false;
		} else {
			mt.isbst = true;
		}
		mt.max = Math.max(node.data, Math.max(lt.max, rt.max));
		mt.min = Math.min(node.data, Math.min(lt.min, rt.min));
		return mt;
	}

	public boolean isbstbtr2() {
		return this.isbstbtr2(this.root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	private boolean isbstbtr2(Node node, int min, int max) {
		if (node == null)
			return true;
		if (node.data <= min || node.data >= max)
			return false;
		boolean isleftfine = this.isbstbtr2(node.left, min, node.data);
		boolean isrightfine = this.isbstbtr2(node.right, node.data, max);
		return isleftfine && isrightfine;
	}
}
