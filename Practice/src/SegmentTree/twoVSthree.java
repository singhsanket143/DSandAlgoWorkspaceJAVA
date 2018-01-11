package SegmentTree;

import java.io.PrintWriter;
import java.util.Scanner;


public class twoVSthree {
	public static twoVSthree t = new twoVSthree();
	class binarystring {
		int len = 0;
		long val = 0;
	}
	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		PrintWriter pw = new PrintWriter(System.out);
		int n = scn.nextInt();
		int[] arr = new int[n];
		String str = scn.next();
		for (int i = 0; i < n; i++) {
			arr[i] = str.charAt(i)-'0';
		}
		binarystring[] tree = new binarystring[6*n];
		for(int i=0;i<tree.length;i++){
			tree[i] = t.new binarystring();
		}
		buildTree(arr, tree, 0, n-1, 1);
		int q = scn.nextInt();
		while(q-- > 0){
			int type = scn.nextInt();
			if(type==0){
				int left=scn.nextInt();
				int right=scn.nextInt();
				pw.println(query(tree, 1, 0, n-1, left, right).val%3);
				pw.flush();
			} else {
				int idx = scn.nextInt();
				updateTree(arr, tree, 0, n-1, 1, idx);
			}
		}
//		for(int i=0;i<tree.length;i++){
//			pw.println(tree[i].val+","+tree[i].len);
//			pw.flush();
//		}
		
	}
	
	public static void buildTree(int[] arr, binarystring[] tree, int start, int end, int treeIndex){
		if(start==end){
			tree[treeIndex].len=1;
			if(arr[start]==1){
				tree[treeIndex].val=1;
			} else {
				tree[treeIndex].val=0;
			}
			return;
		}
		int mid = (start+end)/2;
		buildTree(arr, tree, start, mid, 2*treeIndex);
		buildTree(arr, tree, mid+1, end, 2*treeIndex+1);
		
		binarystring left = tree[2*treeIndex];
		binarystring right = tree[2*treeIndex+1];
		tree[treeIndex].len = left.len+right.len;
		tree[treeIndex].val = ((left.val*(modRecursive(2, right.len,3)))%3+(right.val)%3)%3;
		return;
	}
	
	public static void updateTree(int[] arr,binarystring[] tree, int start, int end,int treeIndex, int idx){
		if(start==end){
			if(arr[start]==0){
				arr[start]=1;
				tree[treeIndex].len=1;
				tree[treeIndex].val=1;
			}
			return;
		}
		int mid = (start + end) / 2;
		if (idx > mid) {
			updateTree(arr, tree, mid + 1, end, 2 * treeIndex + 1, idx);
		} else {
			updateTree(arr, tree, start, mid, 2 * treeIndex, idx);
		}
		binarystring left = tree[2*treeIndex];
		binarystring right = tree[2*treeIndex+1];
		tree[treeIndex].len = left.len+right.len;
		tree[treeIndex].val = ((left.val*(modRecursive(2, right.len,3)))%3+(right.val)%3)%3;
		return;
		
	}
	
	public static binarystring query(binarystring[] tree,int treeIndex, int start, int end, int left, int right){
		if (start > right || end < left) {
			binarystring w = t.new binarystring();
			return w;
		}
		if (start >= left && end <= right) {
			return tree[treeIndex];
		}
		int mid = (start+end)/2;
		binarystring l = query(tree, 2*treeIndex, start, mid, left, right);
		binarystring r = query(tree, 2*treeIndex+1, mid+1, end, left, right);
		binarystring result = t.new binarystring();
		result.len = l.len+r.len;
		result.val = ((l.val*(modRecursive(2, r.len,3)))%3+(r.val)%3)%3;
		return result;
	}
	
	public static long modRecursive(int a, int b, int c) {
		if (b == 0) {
			return 1;
		}
		if (b % 2 == 0) {
			return modRecursive((a * a) % c, b / 2, c);
		} else {
			return ((a % c) * (modRecursive((a * a) % c, b / 2, c))) % c;
		}
	}

}
