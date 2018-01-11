package SegmentTree;

import java.util.Scanner;

public class SegmentTreeMin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int q = scn.nextInt();
		long[] arr = new long[n];
		for (int i = 0; i < n; i++) {
			arr[i] = scn.nextLong();
		}
		long[] tree = new long[4 * n];
		buildTree(arr, tree, 0, n - 1, 1);
		for(int i=0;i<q;i++){
			char type = scn.next().charAt(0);
			int left = scn.nextInt();
			int right = scn.nextInt();
			if(type=='q') {
				System.out.println(query(tree, 0, n - 1, 1, left-1, right-1));
			} else {
				updateTree(arr, tree, 0, n - 1, 1, left-1, right);
			}
		}
			

	}

	public static void buildTree(long[] arr, long[] tree, int start, int end, int treeNode) {
		if (start == end) {
			tree[treeNode] = arr[start];
			return;
		}
		int mid = (start + end) / 2;
		buildTree(arr, tree, start, mid, 2 * treeNode);
		buildTree(arr, tree, mid + 1, end, 2 * treeNode + 1);

		tree[treeNode] = tree[2 * treeNode] + tree[2 * treeNode + 1];
	}

	public static void updateTree(long[] arr, long[] tree, int start, int end, int treeNode, int idx, long val) {
		if (start == end) {
			arr[idx] = val;
			tree[treeNode] = val;
			return;
		}
		int mid = (start + end) / 2;
		if (idx > mid) {
			updateTree(arr, tree, mid + 1, end, 2 * treeNode + 1, idx, val);
		} else {
			updateTree(arr, tree, start, mid, 2 * treeNode, idx, val);
		}
		tree[treeNode] = Math.min(tree[2 * treeNode], tree[2 * treeNode + 1]);
	}

	public static long query(long[] tree, int start, int end, int treeNode, int left, int right) {
		if (start > right || end < left) {
			return Integer.MAX_VALUE;
		}
		if (start >= left && end <= right) {
			return tree[treeNode];
		}
		int mid = (start + end) / 2;
		long ans1 = query(tree, start, mid, 2 * treeNode, left, right);
		long ans2 = query(tree, mid + 1, end, 2 * treeNode + 1, left, right);
		return Math.min(ans1, ans2);
	}

}
