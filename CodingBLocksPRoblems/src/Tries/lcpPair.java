package Tries;

import java.util.Scanner;

public class lcpPair {

	public static long[] solution = new long[100000];

	public static class Trie {
		int count;
		Trie[] child;

		Trie() {
			this.child = new Trie[26];
			this.count = 0;
		}
	}

	public static Trie root = new Trie();

	public static void addString(String str) {
		Trie ptr = root;
		for (int i = 0; i < str.length(); i++) {
			int ch = str.charAt(i) - 'a';
			if (ptr.child[ch] == null) {
				solution[i] += (long) ptr.count;
				ptr.child[ch] = new Trie();
			} else {
				long x = ptr.count - ptr.child[ch].count;
				solution[i] += (x);
				if (i == str.length() - 1) {
					solution[i + 1] += (long) ptr.child[ch].count;
				}
			}
			ptr.count++;
			ptr = ptr.child[ch];
		}
		ptr.count++;
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int max = Integer.MIN_VALUE;
		while (n-- > 0) {
			String str = scn.next();
			max = (max < str.length()) ? str.length() : max;
			addString(str);
		}
		Long ans = 0L;
		for (int i = 0; i <= max; i++) {
			ans += solution[i];
		}
		System.out.println(ans);
	}

}
