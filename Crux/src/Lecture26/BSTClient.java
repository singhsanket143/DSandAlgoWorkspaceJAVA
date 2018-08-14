package Lecture26;

import java.util.Scanner;


public class BSTClient {

	public static void main(String[] args) {
//		BST bst = new BST();
//		 bst.add(12);
//		 bst.add(17);
//		 bst.add(22);
//		 bst.add(85);
//		 bst.add(20);
//		 bst.add(74);
//		 bst.add(38);
//		 bst.add(99);
//		 bst.add(64);
//		 bst.add(46);
//		 bst.add(51);
//		 bst.add(87);
//		 bst.add(23);
//		 bst.add(10);
//		 bst.add(65);
//		 bst.add(74);
//		bst.display();
//		bst.levelorder();
//		System.out.println("******");
//		bst.postorder();
//		bst.inorder();
//		bst.preorder();
//		System.out.println(bst.diameter());
//		System.out.println(bst.height());
//		bst.preorder();
//		bst.LeastCommonAncestor(51, 85);
//		System.out.println("****");
//		bst.inrange(31, 64);
//		bst.remove(75);
//		bst.display();
//		bst.LeastCommonAncestor(62,75);
//		System.out.println("**************************");
//		bst.duplicate();
//		bst.display();
		// bst.levelorderline();
	Scanner scn = new Scanner(System.in);
	int n = scn.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = scn.nextInt();
		}
//		int s = scn.nextInt();
		BST b = new BST(arr);
		int l=scn.nextInt();
		int r=scn.nextInt();
//		b.preorder();
		System.out.println(b.findSubtrees(l, r));
//		b.findMedian();
//		b.preorder();
//		
		
	}
	

}
