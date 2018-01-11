package SegmentTree;

import java.io.PrintWriter;
import java.util.Scanner;

import SegmentTree.SegmentTreeEvenOdd.OddEven;

public class SegmentTreeMaxSumPair {

	class node {
		int max=0;
		int smax=0;
		int sum=0;
	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		PrintWriter pw=new PrintWriter(System.out);
		SegmentTreeMaxSumPair s = new SegmentTreeMaxSumPair();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = scn.nextInt();
		}
		int q = scn.nextInt();
		node[] tree = new node[3 * n];
		for(int i=0;i<3*n;i++){
			tree[i] = s.new node();
		}
		buildTree(arr, tree, 1, 0, n-1);
		for(int i=0;i<q;i++){
			char type = scn.next().charAt(0);
			int left = scn.nextInt();
			int right = scn.nextInt();
			if(type=='Q') {
				SegmentTreeMaxSumPair st =new SegmentTreeMaxSumPair();
				node r=(query(tree, 0, n - 1, 1, left-1, right-1,st));
				pw.println(r.sum);
				pw.flush();
			} else {
				updateTree(arr, tree, 0, n - 1, 1, left-1, right);
			}
		}
		
	}
	
	public static void buildTree(int[] arr, node[] tree,int treeIndex, int start, int end) {
		
		if(start==end) {
			tree[treeIndex].max=arr[start];
			tree[treeIndex].smax=0;
			tree[treeIndex].sum=arr[start];
			return;
		}
		int mid =(start+end)/2;
		buildTree(arr, tree, 2*treeIndex, start, mid);
		buildTree(arr, tree, 2*treeIndex+1, mid+1, end);
		
		node left = tree[2*treeIndex];
		node right = tree[2*treeIndex+1];
		tree[treeIndex].max = Math.max(left.max, right.max);
		tree[treeIndex].smax = Math.min(Math.max(left.max, right.smax), Math.max(left.smax, right.max));
		tree[treeIndex].sum=tree[treeIndex].max+tree[treeIndex].smax;
		return;
	}
	
	public static void updateTree(int[] arr, node[] tree, int start, int end, int treeIndex, int idx, int val) {
		if (start == end) {
			arr[idx] = val;
			tree[treeIndex].max = val;
			tree[treeIndex].smax=0;
			tree[treeIndex].sum=val;
			return;
		}
		int mid = (start + end) / 2;
		if (idx > mid) {
			updateTree(arr, tree, mid + 1, end, 2 * treeIndex + 1, idx, val);
		} else {
			updateTree(arr, tree, start, mid, 2 * treeIndex, idx, val);
		}
		node left = tree[2*treeIndex];
		node right = tree[2*treeIndex+1];
		tree[treeIndex].max = Math.max(left.max, right.max);
		tree[treeIndex].smax = Math.min(Math.max(left.max, right.smax), Math.max(left.smax, right.max));
		tree[treeIndex].sum=tree[treeIndex].max+tree[treeIndex].smax;
	}

	public static node query(node[] tree, int start, int end, int treeNode, int left, int right,SegmentTreeMaxSumPair s) {
		if (start > right || end < left) {
			
			node n = s.new node();
			return n;
		}
		if (start >= left && end <= right) {
			return tree[treeNode];
		}
		int mid = (start + end) / 2;
		node ans1 = query(tree, start, mid, 2 * treeNode, left, right,s);
		node ans2 = query(tree, mid + 1, end, 2 * treeNode + 1, left, right,s);
		node r=s.new node();
		r.max=Math.max(ans1.max, ans2.max);
		r.smax=Math.min(Math.max(ans1.max, ans2.smax), Math.max(ans1.smax, ans2.max));
		r.sum=r.max+r.smax;
		return r;
	}

}
