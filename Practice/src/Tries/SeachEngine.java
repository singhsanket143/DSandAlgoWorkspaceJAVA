package Tries;

import java.util.Scanner;

public class SeachEngine {

	public static class trieNode {
		int weight;
		Character data;
		trieNode[] children;

		trieNode() {
			this.weight = 0;
			this.data=null;
			this.children = new trieNode[26];
			for (int i = 0; i < 26; i++) {
				this.children[i] = null;
			}
		}
	}

	public static void insert(String s, int w, trieNode root) {
		if (s.length() == 0) {
			return;
		}
		trieNode child;
		int idx = s.charAt(0) - 'a';
		if (root.children[idx] != null) {
			child = root.children[idx];
		} else {
			child = new trieNode();
			root.children[idx] = child;
		}
		if (root.weight < w) {
			root.weight = w;
		}
		insert(s.substring(1), w, child);
	}

	public static int searchBest(String s, trieNode root) {
		trieNode current = root;
		int bestWeight = -1;
		for (int i = 0; i < s.length(); i++) {
			int idx = s.charAt(i) - 'a';
			trieNode child = current.children[idx];
			if (child != null) {
				current = child;
				bestWeight = child.weight;
			} else {
				return -1;
			}
		}
		return bestWeight;
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		trieNode root = new trieNode();
		int n = scn.nextInt();
		int q = scn.nextInt();
		for(int i=0;i<n;i++) {
			String str = scn.next();
			int w = scn.nextInt();
			insert(str, w, root);
		}
		while(q-- > 0) {
			String pre = scn.next();
			System.out.println(searchBest(pre, root));
		}
	}

}
