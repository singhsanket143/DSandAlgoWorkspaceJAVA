package Tries;

import java.util.Scanner;

public class maxXorSubarray {

	public static class trieNode {
		trieNode left;
		trieNode right;
		int value;
	}

	public static void insert(int n, trieNode head) {
		trieNode curr = head;
		for (int i = 31; i >= 0; i--) {
			int bit = (n >> i) & 1;
			if (bit == 0) {
				if (curr.left == null) {
					curr.left = new trieNode();
				}
				curr = curr.left;
			} else {
				if (curr.right == null) {
					curr.right = new trieNode();
				}
				curr = curr.right;
			}
		}
		curr.value = n;
	}

	public static int query(trieNode head, int value, int n) {
		int max_xor = Integer.MIN_VALUE;
		trieNode curr = head;
		int curr_xor = 0;
		for (int j = 31; j >= 0; j--) {
			int b = (value >> j) & 1;
			if (b == 0) {
				if (curr.right != null) {
					curr = curr.right;
				} else {
					curr = curr.left;
				}
			} else {
				if (curr.left != null) {
					curr = curr.left;
				} else {
					curr = curr.right;
				}
			}
		}
		return value^curr.value;
	}

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
		}
		int pre_xor = 0;
		int result = Integer.MIN_VALUE;
		trieNode head = new trieNode();
		for (int i = 0; i < arr.length; i++) {
			pre_xor ^= arr[i];
			insert(pre_xor, head);
			result = Math.max(result, query(head, pre_xor, n));
		}
		System.out.println(result);
	}

}
