package SegmentTree;

import java.io.PrintWriter;
import java.util.Scanner;

public class vasyaVSRhezo {
	public static vasyaVSRhezo v = new vasyaVSRhezo();

	class Warriors {
		int a = Integer.MIN_VALUE;
		int b = Integer.MAX_VALUE;
		int index = -1;
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		PrintWriter pw = new PrintWriter(System.out);
		int n = scn.nextInt();

		Warriors[] arr = new Warriors[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = v.new Warriors();
			arr[i].index = i + 1;
		}
		for (int i = 0; i < arr.length; i++) {
			arr[i].a = scn.nextInt();
		}
		for (int i = 0; i < arr.length; i++) {
			arr[i].b = scn.nextInt();
		}
		Warriors[] tree = new Warriors[4 * n];
		for (int i = 0; i < tree.length; i++) {
			tree[i] = v.new Warriors();
		}
		buildTree(arr, tree, 0, n-1, 1);
		 int q = scn.nextInt();
		 while (q-- > 0) {
			 int left=scn.nextInt();
			 int right=scn.nextInt();
			 Warriors r=query(tree, 0, n-1, 1, left-1, right-1);
			 pw.println(r.index);
			 pw.flush();
		 }
		
//		for (int i = 0; i < tree.length; i++) {
//			System.out.println(tree[i].a + "," + tree[i].b + "," + tree[i].index);
//		}

	}

	public static void buildTree(Warriors[] arr, Warriors[] tree, int start, int end, int treeIndex) {
		if (start == end) {
			tree[treeIndex] = v.new Warriors();
			tree[treeIndex].a = arr[start].a;
			tree[treeIndex].b = arr[start].b;
			tree[treeIndex].index = start + 1;
			return;
		}
		int mid = (start + end) / 2;
		buildTree(arr, tree, start, mid, 2 * treeIndex);
		buildTree(arr, tree, mid + 1, end, 2 * treeIndex + 1);
		Warriors cand1 = tree[2 * treeIndex];
		Warriors cand2 = tree[2 * treeIndex + 1];
		if (cand1.a > cand2.a) {
			tree[treeIndex].a = cand1.a;
			tree[treeIndex].b = cand1.b;
			tree[treeIndex].index = cand1.index;
		} else if (cand1.a < cand2.a) {
			tree[treeIndex].a = cand2.a;
			tree[treeIndex].b = cand2.b;
			tree[treeIndex].index = cand2.index;
		} else {
			if (cand1.b < cand2.b) {
				tree[treeIndex].a = cand1.a;
				tree[treeIndex].b = cand1.b;
				tree[treeIndex].index = cand1.index;
			} else if (cand1.b > cand2.b) {
				tree[treeIndex].a = cand2.a;
				tree[treeIndex].b = cand2.b;
				tree[treeIndex].index = cand2.index;
			} else {
				if (cand1.index < cand2.index) {
					tree[treeIndex].a = cand1.a;
					tree[treeIndex].b = cand1.b;
					tree[treeIndex].index = cand1.index;
				} else {
					tree[treeIndex].a = cand2.a;
					tree[treeIndex].b = cand2.b;
					tree[treeIndex].index = cand2.index;
				}
			}
		}
	}

	public static Warriors query(Warriors[] tree, int start, int end, int treeIndex, int left, int right) {
		if (start > right || end < left) {
			Warriors w = v.new Warriors();
			return w;
		}
		if (start >= left && end <= right) {
			return tree[treeIndex];
		}

		int mid = (start + end) / 2;
		Warriors cand1 = query(tree, start, mid, 2*treeIndex, left, right);
		Warriors cand2 = query(tree, mid+1, end, 2*treeIndex+1, left, right);
		Warriors result = v.new Warriors();
		if (cand1.a > cand2.a) {
			result.a = cand1.a;
			result.b = cand1.b;
			result.index = cand1.index;
		} else if (cand1.a < cand2.a) {
			result.a = cand2.a;
			result.b = cand2.b;
			result.index = cand2.index;
		} else {
			if (cand1.b < cand2.b) {
				result.a = cand1.a;
				result.b = cand1.b;
				result.index = cand1.index;
			} else if (cand1.b > cand2.b) {
				result.a = cand2.a;
				result.b = cand2.b;
				result.index = cand2.index;
			} else {
				if (cand1.index < cand2.index) {
					result.a = cand1.a;
					result.b = cand1.b;
					result.index = cand1.index;
				} else {
					result.a = cand2.a;
					result.b = cand2.b;
					result.index = cand2.index;
				}
			}
		}
		return result;
	}

}
