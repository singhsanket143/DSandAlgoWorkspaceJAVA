
import java.util.ArrayList;
import java.util.Collections;
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

	/////////////////// New Constructor//////////

	public BinaryTree(int[] pre, int[] in) {
		// this.root = this.construct(pre, 0, pre.length - 1, in, 0, in.length -
		// 1);//for preorder
		this.root = this.construct(pre, in, 0, in.length - 1);// for
																// postorder

	}

	private static int preIndex = 0;

	private Node construct(int[] pre, int[] in, int isi, int iei) {
		if (isi > iei) {
			return null;
		}
		Node tNode = new Node(pre[preIndex++], null, null);

		if (isi == iei) {
			return tNode;
		}
		
		int inIndex = search(in, isi, iei, tNode.data);
		tNode.left = construct(pre, in, isi, inIndex-1);
		tNode.right = construct(pre, in, inIndex+1, iei);
		return tNode;

	}

	private int search(int[] arr, int si, int ei, int data) {
		for (int i = si; i <= ei; i++) {
			if (arr[i] == data)
				return i;
		}
		return -1;
	}

	private void printKDistanceNodedown(Node node, int k,ArrayList<Integer> arr) {
		if(node == null || k<0) {
			return ;
		}
		if(k==0) {
//			System.out.println(node.data);
			arr.add(node.data);
			return;
		}
		printKDistanceNodedown(node.left, k-1, arr);
		printKDistanceNodedown(node.right, k-1, arr);
		
	}
	
	private int printkNodeDistance(Node node, int target,int k,ArrayList<Integer> arr) {
		if(node == null) {
			return -1;
		}
		if(node.data == target) {
			printKDistanceNodedown(node, k,arr);
			return 0;
		}
		int dl = printkNodeDistance(node.left, target, k, arr);
		if(dl!=-1) {
			if(dl+1==k) {
//				System.out.println(node.data);
				arr.add(node.data);
			}
			else {
				printKDistanceNodedown(node.right, k - dl - 2,arr);
			}
			return 1+dl;
		}
		int dr = printkNodeDistance(node.right, target, k, arr);
		if(dr!=-1) {
			if(dr+1 == k) {
//				System.out.println(node.data);
				arr.add(node.data);
				
			} else {
				printKDistanceNodedown(node.left, k - dr - 2,arr);
			}
			return 1+dr;
		}
		return -1;
	}
	
	public ArrayList<Integer> printkNodeDistance(int target, int k) {
		ArrayList<Integer> arr = new ArrayList<>();
		printkNodeDistance(this.root, target, k, arr);
		Collections.sort(arr);
		return arr;
	}
	

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] pre = new int[n];
		int[] in = new int[n];
		for (int i = 0; i < n; i++) {
			pre[i]=scn.nextInt();
		}
		for (int i = 0; i < n; i++) {
			in[i]=scn.nextInt();
		}
		
		BinaryTree bt = new BinaryTree(pre, in);
//		bt.display();
		int t=scn.nextInt();
		while(t-- > 0) {
			int tar = scn.nextInt();
			int k=scn.nextInt();
			ArrayList<Integer> a= bt.printkNodeDistance(tar, k);
			for(int i:a) {
				System.out.print(i+" ");
			}
			if(a.size()==0) {
				System.out.print(0);
			}
			System.out.println();
		}
		
	}
}
