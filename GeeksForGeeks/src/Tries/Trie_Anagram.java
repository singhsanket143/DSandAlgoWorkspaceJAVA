package Tries;

import java.util.HashMap;
import java.util.*;
import java.util.Set;

public class Trie_Anagram {
	private class Node {
		Character data;
		boolean isTerminal;
		HashMap<Character, Node> Children;
		LinkedList<Integer> list;

		Node(Character data, boolean isTerminal) {
			this.data = data;
			this.isTerminal = isTerminal;
			this.Children = new HashMap<>();
			this.list = new LinkedList();
		}
	}

	private Node root;

	private int numwords;

	Trie_Anagram() {
		this.root = new Node('\0', false);
		this.numwords = 0;
	}

	public int numwords() {
		return this.numwords;
	}

	public boolean isEmpty() {
		return this.numwords == 0;
	}

	public void addword(String word, int n) {
		this.addword(this.root, word, n);
	}

	private void addword(Node Parent, String word, int n) {
		if (word.length() == 0) {
			if (Parent.isTerminal) {

			} else {
				Parent.isTerminal = true;
				this.numwords++;
				
			}
			Parent.list.addLast(n);
			return;
		}
		Character ch = word.charAt(0);
		String ros = word.substring(1);
		Node child = Parent.Children.get(ch);
		if (child == null) {
			child = new Node(ch, false);
			Parent.Children.put(ch, child);
		}
		this.addword(child, ros, n);

	}

	public void displayAnagram(String[] arr) {
		this.displayAnagram(this.root, "", arr);
	}

	private void displayAnagram(Node node, String osf, String[] arr) {
		if (node.isTerminal) {
			// String toPrint = osf.substring(1) + node.data;
			// System.out.println(toPrint);
			LinkedList<Integer> temp = new LinkedList();
			while (!node.list.isEmpty()) {
				int k = node.list.removeFirst();
				temp.addLast(k);
				System.out.println(arr[k]);
			}
			node.list=temp;
		}
		Node curr = node;

		for (int j = 0; j < 26; j++) {
			Node child = curr.Children.get((char) ('a' + j));
			if (child != null) {
				this.displayAnagram(child, osf + (char) ('a' + j), arr);
			}
		}

	}

	public boolean searchWord(String word) {
		return this.searchWord(this.root, word);
	}

	private boolean searchWord(Node parent, String word) {
		if (word.length() == 0) {
			if (parent.isTerminal) {
				return true;
			} else {
				return false;
			}
		}
		Character ch = word.charAt(0);
		String ros = word.substring(1);
		Node child = parent.Children.get(ch);
		if (child == null) {
			return false;
		}
		return this.searchWord(child, ros);
	}

	public String longestMatchingrefix(String pattern) {
		return this.longestMatchingrefix(this.root, pattern, "");
	}

	private String longestMatchingrefix(Node parent, String pattern, String result) {
		if (pattern.length() == 0) {
			return result;
		}
		Character ch = pattern.charAt(0);
		String ros = pattern.substring(1);
		Node child = parent.Children.get(ch);
		if (child == null) {
			return result;
		}
		return this.longestMatchingrefix(child, ros, result + ch);
	}

	public String longestCommonPrefix() {
		return this.longestCommonPrefix(this.root);
	}

	private String longestCommonPrefix(Node parent) {
		Node curr = parent;
		String result = "";
		while (curr.Children.size() == 1) {
			for (int i = 0; i < 26; i++) {
				Node temp = curr.Children.get((char) ('a' + i));
				if (temp == null) {
					continue;
				} else {
					curr = temp;
					result += curr.data;
					break;
				}
			}
		}
		return result;
	}

	public void palindromicPair(String[] arr) {
		for (int i = 0; i < arr.length; i++) {
			if (this.palindromicPair(this.root, arr[i], "")) {
				System.out.println(arr[i]);
				System.out.println("*****");
			} else {
				StringBuilder sb = new StringBuilder();
				for (int j = arr[i].length() - 1; j >= 0; j--) {
					sb.append(arr[i].charAt(j));
				}
				if (this.palindromicPair(this.root, sb.toString(), "")) {
					System.out.println(sb.toString());
					System.out.println("*****");
				}
			}
		}
	}

	private boolean palindromicPair(Node parent, String word, String result) {
		if (word.length() == 0) {
			if (parent.isTerminal) {
				System.out.println(result);
				return true;
			}
			return false;
		}
		Character ch = word.charAt(0);
		String ros = word.substring(1);
		Node child = parent.Children.get(ch);
		if (child == null) {
			return false;
		}
		if (child.isTerminal) {
			for (int j = 0; j < ros.length() / 2; j++) {
				if (ros.charAt(j) == ros.charAt(ros.length() - j - 1)) {
					System.out.println(result + ch);
					return true;
				}
			}
		}
		return this.palindromicPair(child, ros, result + ch);
	}

	public void remove(String word) {
		this.remove(this.root, word);
	}

	private void remove(Node parent, String word) {

		if (word.length() == 0) {
			if (parent.isTerminal) {
				parent.isTerminal = false;
				this.numwords--;
			}
			return;
		}
		Character ch = word.charAt(0);
		String ros = word.substring(1);
		Node child = parent.Children.get(ch);
		if (child == null) {
			return;
		}
		this.remove(child, ros);
		if (!child.isTerminal && child.Children.size() == 0) {
			parent.Children.remove(ch);
		}
	}

	public void displayAstree() {
		this.displayAstree(this.root);
	}

	private void displayAstree(Node node) {
		String str = "";
		str += node.data + "=>";
		Set<Map.Entry<Character, Node>> children = node.Children.entrySet();

		for (Map.Entry<Character, Node> child : children) {
			str += child.getKey() + ",";
		}
		str += "END";
		System.out.println(str);
		for (Map.Entry<Character, Node> child : children) {
			this.displayAstree(child.getValue());
		}
	}
}
