package janChallenge;

import java.util.Scanner;

public class KillingMonsters {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		for(int i = 0;i<arr.length;i++) {
			arr[i]=scn.nextInt();
		}
		int[] tree = new int[4* n];
		buildTree(arr, tree, 0, n - 1, 1);
		int q = scn.nextInt();
		while(q-- > 0) {
			int x = scn.nextInt();
			int y = scn.nextInt();
			monsters(arr, tree, x, y);
		}
	}
	
	public static void monsters(int[] arr,int[] tree, int x, int y) {
		int bits = brianKernighan(x);
		if(isPowerOftwo(x+1)) {
			int twopow=(int)Math.pow(2, bits);
			for(int i =0;i<twopow && i<arr.length;i++) {
				updateTree(arr, tree, 0, arr.length-1, 1, i, y);
			}
		} else {
			int p = (int)Math.pow(2,bits);
			updateTree(arr, tree, 0, arr.length-1, 1, p, y);
			if(x<arr.length && x!=p)
				updateTree(arr, tree, 0, arr.length-1, 1, x, y);
		}
//		if(x<arr.length) {
//			updateTree(arr, tree, 0, arr.length-1, 1, x, y);
//		}
		System.out.println(tree[1]);
	}
	
	public static int brianKernighan(int num) {
		int count = 0;
		while (num > 0) {
			num = num & (num - 1);
			count++;
		}
		return count;
	}
	
	public static boolean isPowerOftwo(int x) {
		int a = x;
		int b= (x & (x-1));
		if(b==0)
			return true;
		else
			return false;
	}
	
	public static void buildTree(int[] arr, int[] tree, int start, int end, int treeNode) {
		if (start == end) {
			tree[treeNode] = 1;
			return;
		}
		int mid = (start + end) / 2;
		buildTree(arr, tree, start, mid, 2 * treeNode);
		buildTree(arr, tree, mid + 1, end, 2 * treeNode + 1);

		tree[treeNode] = tree[2 * treeNode] + tree[2 * treeNode + 1];
	}

	public static void updateTree(int[] arr, int[] tree, int start, int end, int treeNode, int idx, int val) {
		if(arr[idx]<=0)
			return;
		if(idx>arr.length-1)
			return;
		if (start == end) {
			arr[idx] -= val;
			tree[treeNode] = (arr[idx]<=0)?0:1;
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

}
