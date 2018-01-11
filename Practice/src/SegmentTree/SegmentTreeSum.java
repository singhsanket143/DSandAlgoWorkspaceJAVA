package SegmentTree;

import java.util.Scanner;

public class SegmentTreeSum {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = scn.nextInt();
		}
		int[] tree = new int[2 * n];
		buildTree(arr, tree, 0, n - 1, 1);

		updateTree(arr, tree, 0, n - 1, 1, 2, 10);
		for (int i = 1; i < tree.length; i++) {
			System.out.println(tree[i]);
		}
		System.out.println(query(tree, 0, n - 1, 1, 2, 4));

	}

	public static void buildTree(int[] arr, int[] tree, int start, int end, int treeNode) {
		if (start == end) {
			tree[treeNode] = arr[start];
			return;
		}
		int mid = (start + end) / 2;
		buildTree(arr, tree, start, mid, 2 * treeNode);
		buildTree(arr, tree, mid + 1, end, 2 * treeNode + 1);

		tree[treeNode] = tree[2 * treeNode] + tree[2 * treeNode + 1];
	}

	public static void updateTree(int[] arr, int[] tree, int start, int end, int treeNode, int idx, int val) {
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
		tree[treeNode] = tree[2 * treeNode] + tree[2 * treeNode + 1];
	}

	public static int query(int[] tree, int start, int end, int treeNode, int left, int right) {
		if (start > right || end < left) {
			return 0;
		}
		if (start >= left && end <= right) {
			return tree[treeNode];
		}
		int mid = (start + end) / 2;
		int ans1 = query(tree, start, mid, 2 * treeNode, left, right);
		int ans2 = query(tree, mid + 1, end, 2 * treeNode + 1, left, right);
		return ans1 + ans2;
	}

}
