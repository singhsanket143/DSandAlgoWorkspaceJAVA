package Tries;

import java.util.HashMap;
import java.util.Scanner;

public class costOfData {
	public static class Node {
		Character data;
		boolean isTerminal;
		HashMap<Character, Node> Children;

		Node(Character data, boolean isTerminal) {
			this.data = data;
			this.isTerminal = isTerminal;
			this.Children = new HashMap<>();
		}
	}

	Node root;
	static int numwords;
	
	public static void addword(Node Parent, String word) {
		if (word.length() == 0) {
			if (Parent.isTerminal) {

			} else {
				Parent.isTerminal = true;
				
			}
			return;
		}
		Character ch = word.charAt(0);
		String ros = word.substring(1);
		Node child = Parent.Children.get(ch);
		if (child == null) {
			child = new Node(ch, false);
			numwords++;
			Parent.Children.put(ch, child);
		}
		addword(child, ros);

	}
	
	costOfData() {
		this.root = new Node('\0', false);
		numwords = 0;
	}
	
	public static int numNodes() {
		return numwords;
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		costOfData c = new costOfData();
		int t = scn.nextInt();
		while(t-- > 0) {
			addword(c.root,scn.next());
		}
		System.out.println(numNodes() + 1);
	}

}
