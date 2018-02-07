package Tries;

import java.util.Scanner;

public class XorMaxPair {

	public static class trieNode {
		trieNode left;
		trieNode right;
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
	}

	public static int findMaxXorPair(trieNode head, int[] arr, int n) {
		int max_xor = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			trieNode curr = head;
			int value = arr[i];
			int curr_xor = 0;
			for (int j = 31; j >= 0; j--) {
				int b = (value >> j) & 1;
				if (b == 0) {
					if (curr.right != null) {
						curr = curr.right;
						curr_xor += (int)Math.pow(2, j);
					} else {
						curr = curr.left;
					}
				} else {
					if (curr.left != null) {
						curr = curr.left;
						curr_xor += (int)Math.pow(2, j);
					} else {
						curr = curr.right;
					}
				}
			}
			if (curr_xor > max_xor) {
				max_xor = curr_xor;
			}
		}
		return max_xor;
	}

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
		}
		trieNode head = new trieNode();
		for (int i = 0; i < arr.length; i++) {
			insert(arr[i], head);
		}
		System.out.println(findMaxXorPair(head, arr, n));
	}

}
