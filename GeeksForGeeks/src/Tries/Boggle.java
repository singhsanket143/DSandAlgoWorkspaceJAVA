package Tries;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Boggle {

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
	public int M = 3;
	public int N = 3;

	Boggle() {
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

	public boolean isSafe(int i, int j, boolean[][] visited) {
		return (i >= 0 && j >= 0 && i < M && j < N && !visited[i][j]);
	}

	public void searchWord(char[][] boggle) {
		boolean[][] visited = new boolean[M][N];
		Node child = root;
		String str = "";
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (child.children.get(boggle[i][j]) != null) {
					str += boggle[i][j];
					this.searchWord(child.children.get(boggle[i][j]), boggle, i, j, visited, str);
					str = "";
				}
			}
		}

	}

	private void searchWord(Node Parent, char[][] boggle, int i, int j, boolean[][] visited, String word) {

		if (Parent.isTerminal) {
			System.out.println(word);
		}
		if (this.isSafe(i, j, visited)) {
			visited[i][j] = true;
			for (int k = 0; k < 26; k++) {
				if (Parent.children.get((char) ('A' + k)) != null) {
					char ch = (char) ('A' + k);
					if (this.isSafe(i + 1, j + 1, visited) && boggle[i + 1][j + 1] == ch) {
						this.searchWord(Parent.children.get((char) ('A' + k)), boggle, i + 1, j + 1, visited,
								word + ch);
					}
					if (this.isSafe(i, j + 1, visited) && boggle[i][j + 1] == ch) {
						this.searchWord(Parent.children.get((char) ('A' + k)), boggle, i, j + 1, visited, word + ch);
					}
					if (this.isSafe(i + 1, j, visited) && boggle[i + 1][j] == ch) {
						this.searchWord(Parent.children.get((char) ('A' + k)), boggle, i + 1, j, visited, word + ch);
					}
					if (this.isSafe(i - 1, j - 1, visited) && boggle[i - 1][j - 1] == ch) {
						this.searchWord(Parent.children.get((char) ('A' + k)), boggle, i - 1, j - 1, visited,
								word + ch);
					}
					if (this.isSafe(i - 1, j + 1, visited) && boggle[i - 1][j + 1] == ch) {
						this.searchWord(Parent.children.get((char) ('A' + k)), boggle, i - 1, j + 1, visited,
								word + ch);
					}
					if (this.isSafe(i - 1, j, visited) && boggle[i - 1][j] == ch) {
						this.searchWord(Parent.children.get((char) ('A' + k)), boggle, i - 1, j, visited, word + ch);
					}
					if (this.isSafe(i + 1, j - 1, visited) && boggle[i + 1][j - 1] == ch) {
						this.searchWord(Parent.children.get((char) ('A' + k)), boggle, i + 1, j - 1, visited,
								word + ch);
					}
					if (this.isSafe(i, j - 1, visited) && boggle[i][j - 1] == ch) {
						this.searchWord(Parent.children.get((char) ('A' + k)), boggle, i, j - 1, visited, word + ch);
					}
				}
			}
			visited[i][j] = false;
		}
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
