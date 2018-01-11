package Lecture31;

import java.util.HashMap;
import java.util.*;
import java.util.Set;

public class Trie {
	private class Node {
		Character data;
		boolean isTerminal;
		HashMap<Character, Node> Children;

		Node(Character data, boolean isTerminal) {
			this.data = data;
			this.isTerminal = isTerminal;
			this.Children = new HashMap<>();
		}
	}

	private Node root;

	private int numwords;

	Trie() {
		this.root = new Node('\0', false);
		this.numwords = 0;
	}

	public int numwords() {
		return this.numwords;
	}

	public boolean isEmpty() {
		return this.numwords == 0;
	}

	public void addword(String word) {
		this.addword(this.root, word);
	}

	private void addword(Node Parent, String word) {
		if (word.length() == 0) {
			if (Parent.isTerminal) {

			} else {
				Parent.isTerminal = true;
				this.numwords++;
			}
			return;
		}
		Character ch = word.charAt(0);
		String ros = word.substring(1);
		Node child = Parent.Children.get(ch);
		if (child == null) {
			child = new Node(ch, false);
			Parent.Children.put(ch, child);
		}
		this.addword(child, ros);

	}

	public void display() {
		this.display(this.root, "");
	}

	private void display(Node node, String osf) {
		if (node.isTerminal) {
			String toPrint = osf.substring(1) + node.data;
			System.out.println(toPrint);
		}
		Set<Map.Entry<Character, Node>> children = node.Children.entrySet();
		for (Map.Entry<Character, Node> child : children) {
			this.display(child.getValue(), osf + node.data);
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
