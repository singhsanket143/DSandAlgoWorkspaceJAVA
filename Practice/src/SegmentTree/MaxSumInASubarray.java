package SegmentTree;

import java.io.PrintWriter;
import java.util.Scanner;

public class MaxSumInASubarray {

	public static MaxSumInASubarray m = new MaxSumInASubarray();
	class Node{
		long sum;
		long maxSum;
		long bestPrefixSum;
		long bestSuffixSum;
		
		public Node() {
			this.sum = 0;
			this.maxSum = 0;
			this.bestPrefixSum = 0;
			this.bestSuffixSum = 0;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		PrintWriter pw= new PrintWriter(System.out);
		int n = scn.nextInt();
		int[] arr = new int[n];
		for(int i=0;i<n;i++) {
			arr[i] = scn.nextInt();
		}
		Node[] tree = new Node[4*n];
		for(int i=0;i<4*n;i++) {
			tree[i] =  m.new Node();
		}
		buildTree(arr, tree, 0, arr.length-1, 1);
//		for(int i=0;i<4*n;i++) {
//			System.out.println(tree[i].maxSum+","+tree[i].sum+","+tree[i].bestPrefixSum+","+tree[i].bestSuffixSum);
//		}
		int q=scn.nextInt();
		while(q-- > 0) {
			int left = scn.nextInt();
			int right = scn.nextInt();
			pw.println(query(tree, 0, arr.length-1, 1, left-1, right-1).maxSum);
			pw.flush();
		}

	}
	
	public static void buildTree(int[] arr, Node[] tree, int start, int end, int treenode) {
		if(start == end) {
			tree[treenode].sum = arr[start];
			tree[treenode].maxSum = arr[start];
			tree[treenode].bestPrefixSum = arr[start];
			tree[treenode].bestSuffixSum = arr[start];
			return;
		}
		int mid = (start  + end)/2;
		buildTree(arr, tree, start, mid, 2*treenode);
		buildTree(arr, tree, mid+1, end, 2*treenode+1);
		tree[treenode].sum = tree[2*treenode].sum+tree[2*treenode+1].sum;
		tree[treenode].bestPrefixSum=Math.max(tree[2*treenode].bestPrefixSum, tree[2*treenode].sum+tree[2*treenode+1].bestPrefixSum);
		tree[treenode].bestSuffixSum=Math.max(tree[2*treenode+1].bestSuffixSum, tree[2*treenode+1].sum+tree[2*treenode].bestSuffixSum);
		tree[treenode].maxSum = Math.max(tree[treenode].bestPrefixSum,Math.max(tree[treenode].bestSuffixSum,Math.max(Math.max(tree[2*treenode].maxSum,tree[2*treenode+1].maxSum),(tree[2*treenode].bestSuffixSum+tree[2*treenode+1].bestPrefixSum))));
	}
	
	public static Node query(Node[] tree, int start, int end, int treeNode, int left, int right) {
		Node n=m.new Node();
		n.bestPrefixSum = Integer.MIN_VALUE;
		n.bestSuffixSum = Integer.MIN_VALUE;
		if (start > right || end < left) {	
			return n;
		}
		if (start >= left && end <= right) {
			return tree[treeNode];
		}
		int mid = (start + end)/2;
		if(left> mid) {
			return query(tree, mid+1, end, 2*treeNode+1, left, right);
		}
		if(right<=mid) {
			return query(tree, start, mid, 2*treeNode, left, right);
		}
		Node ans1 = query(tree, start, mid, 2*treeNode, left, right);
		Node ans2 = query(tree, mid+1, end, 2*treeNode+1, left, right);
		Node result = m.new Node();
		result.sum = ans1.sum+ans2.sum;
		result.bestPrefixSum=Math.max(ans1.bestPrefixSum, ans1.sum+ans2.bestPrefixSum);
		result.bestSuffixSum=Math.max(ans2.bestSuffixSum, ans2.sum+ans1.bestSuffixSum);
		result.maxSum = Math.max(result.bestSuffixSum,Math.max(result.bestPrefixSum,Math.max(Math.max(ans1.maxSum,ans2.maxSum),(ans1.bestSuffixSum+ans2.bestPrefixSum))));
		return result;
	}

}
