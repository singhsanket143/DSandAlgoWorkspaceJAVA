package SegmentTree;

import java.util.Scanner;

public class SegmentTreeEvenOdd {
	public class OddEven{
		int odd;
		int even;
		OddEven() {
			this.odd=0;
			this.even = 0;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		OddEven[] tree = new OddEven[3 * n];
		SegmentTreeEvenOdd s=new SegmentTreeEvenOdd();
		long[] arr = new long[n];
		for (int i = 0; i < n; i++) {
			arr[i] = scn.nextLong();
		}
		for(int i=0;i<3*n;i++){
			tree[i] = s.new OddEven();
		}
		int q = scn.nextInt();
		buildTree(arr, tree, 0, n - 1, 1);
		for (int i = 0; i < q; i++) {
			int type = scn.nextInt();
			int left = scn.nextInt();
			int right = scn.nextInt();
			if (type == 1) {
				queryEven(tree, 1, n , 1, left , right );
			} else if (type == 0) {
				updateTree(arr, tree, 0, n - 1, 1, left-1, right);
				for (int j = 1; j < tree.length; i++) {
					System.out.println(tree[j].odd+","+tree[j].even);
				}
				System.out.println("***");
			} else {
				queryOdd(tree, 1, n, 1, left , right );
			}
		}
	}

	public static void buildTree(long[] arr, OddEven[] tree, int start, int end, int treeNode) {
		if (start == end) {	
			
			if(arr[start]%2==0){
				tree[treeNode].even=1;
				tree[treeNode].odd=0;
			} else {
				tree[treeNode].odd=1;
				tree[treeNode].even=0;
			}
			return;
		}
		int mid = (start + end) / 2;
		buildTree(arr, tree, start, mid, 2 * treeNode);
		buildTree(arr, tree, mid + 1, end, 2 * treeNode + 1);

		tree[treeNode].even = tree[2 * treeNode].even+tree[2 * treeNode + 1].even;
		tree[treeNode].odd = tree[2 * treeNode].odd+tree[2 * treeNode + 1].odd;
	}


	public static void updateTree(long[] arr, OddEven[] tree, int start, int end, int treeNode, int idx, long val) {
		if (start == end) {
			arr[idx]=val;
			if(val%2==0){
				tree[treeNode].even=1;
			} else {
				tree[treeNode].odd=1;
			}
			return;
		}
		int mid = (start + end) / 2;
		if (idx > mid) {
			updateTree(arr, tree, mid + 1, end, 2 * treeNode + 1, idx, val);
		} else {
			updateTree(arr, tree, start, mid, 2 * treeNode, idx, val);
		}
		tree[treeNode].even = tree[2 * treeNode].even + tree[2 * treeNode + 1].even;
		tree[treeNode].odd = tree[2 * treeNode].odd + tree[2 * treeNode + 1].odd;
	}


	public static long queryOdd(OddEven[] tree, int start, int end, int treeNode, int left, int right) {
		if (start > right || end < left) {
			return 0;
		}
		if (start >= left && end <= right) {
			return tree[treeNode].odd;
		}
		int mid = (start + end) / 2;
		long ans1 = queryOdd(tree, start, mid, 2 * treeNode, left, right);
		long ans2 = queryOdd(tree, mid + 1, end, 2 * treeNode + 1, left, right);
		return ans1 + ans2;
	}

	public static long queryEven(OddEven[] tree, int start, int end, int treeNode, int left, int right) {
		if (start > right || end < left) {
			return 0;
		}
		if (start >= left && end <= right) {
			return tree[treeNode].even;
		}
		int mid = (start + end) / 2;
		long ans1 = queryEven(tree, start, mid, 2 * treeNode, left, right);
		long ans2 = queryEven(tree, mid + 1, end, 2 * treeNode + 1, left, right);
		return ans1 + ans2;
	}

}
