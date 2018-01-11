package Tries;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Tries {

	private class Node {
		Character ch;
		boolean isTerminal;
		HashMap<Character, Node> children;

		Node(Character ch, boolean isTerminal) {
			this.ch = ch;
			this.isTerminal = isTerminal;
			children = new HashMap<>();
		}
	}

	private Node root;
	private int numWords;

	Tries() {
		this.root = new Node('\0', false);
		this.numWords = 0;
	}

	public int numWords() {
		return this.numWords;
	}

	public boolean isEmpty() {
		return this.numWords == 0;
	}

	public void addWord(String word) {
		this.addWord(this.root, word);
	}

	private void addWord(Node Parent, String word) {

		if (word.length() == 0) {
			if (!Parent.isTerminal) {
				Parent.isTerminal = true;
				this.numWords++;
			}
			return;
		}
		Character ch = word.charAt(0);
		String ros = word.substring(1);
		Node child = Parent.children.get(ch);
		if (child == null) {
			child = new Node(ch, false);
			Parent.children.put(ch, child);
		}
		this.addWord(child, ros);
	}

	public void displayAsWords() {
		this.displayAsWords(this.root, "");
	}

	private void displayAsWords(Node node, String osf) {
		if (node.isTerminal) {
			String toPrint = osf.substring(1) + node.ch;
			System.out.println(toPrint);
		}
		Set<Map.Entry<Character, Node>> children = node.children.entrySet();
		for (Map.Entry<Character, Node> child : children) {
			this.displayAsWords(child.getValue(), osf + node.ch);
		}
	}

	public boolean searchWord(String word) {
		return this.searchWord(this.root, word);

	}

	private boolean searchWord(Node Parent, String word) {

		if (word.length() == 0) {
			if (Parent.isTerminal) {
				return true;
			} else {
				return false;
			}
		}
		Character ch = word.charAt(0);
		String ros = word.substring(1);
		Node child = Parent.children.get(ch);
		if (child == null) {
			return false;
		}

		return this.searchWord(child, ros);
	}

	public void remove(String word) {
		this.remove(this.root, word);
	}

	private void remove(Node Parent, String word) {
		if (word.length() == 0) {
			if (Parent.isTerminal) {
				Parent.isTerminal = false;
				this.numWords--;
			}
			return;
		}
		Character ch = word.charAt(0);
		String ros = word.substring(1);
		Node child = Parent.children.get(ch);
		if (child == null) {
			return;
		}

		this.remove(child, ros);

		if (!child.isTerminal && child.children.size() == 0) {
			Parent.children.remove(ch);
		}
	}

	public void displayAsTree() {
		this.displayAsTree(this.root);
	}

	private void displayAsTree(Node node) {
		String str = "";
		if (node.ch == '\0') {
			str += "ROOT" + "=>";
		} else {
			str += node.ch + "=>";
		}
		Set<Map.Entry<Character, Node>> children = node.children.entrySet();
		for (Map.Entry<Character, Node> child : children) {
			str += child.getKey() + ", ";
		}
		str += "END";
		System.out.println(str);

		for (Map.Entry<Character, Node> child : children) {
			this.displayAsTree(child.getValue());
		}
	}
}
