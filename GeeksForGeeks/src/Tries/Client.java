package Tries;

import java.util.Arrays;

public class Client {

	public static void main(String[] args) {
		// Tries trie = new Tries();
		// trie.addWord("art");
		// trie.addWord("arts");
		// trie.addWord("stock");
		// trie.addWord("stop");
		// trie.addWord("see");
		// trie.addWord("sea");
		// trie.addWord("buy");
		// trie.addWord("bull");
		// trie.addWord("up");
		// trie.displayAsWords();
		// System.out.println(trie.searchWord("bull"));
		// trie.remove("bull");
		// trie.displayAsWords();
		// System.out.println(trie.searchWord("buy"));
		// trie.remove("buy");
		// trie.displayAsTree();
		// Trie_Anagram trie = new Trie_Anagram();
		// String[] arr = {"cat", "dog", "tac", "god", "act"};
		// String[] temp = new String[arr.length];
		// for(int i=0;i<arr.length;i++) {
		// char[] a = arr[i].toCharArray();
		// Arrays.sort(a);
		// trie.addword(new String(a), i);
		// }
		// trie.displayAnagram(arr);
		Boggle trie = new Boggle();
		char boggle[][] = { { 'G', 'I', 'Z' }, { 'U', 'E', 'K' }, { 'Q', 'S', 'E' } };
		trie.addWord("FOR");
		trie.addWord("GEE");
		trie.addWord("GEEKS");
		trie.addWord("QUIZ");
		trie.searchWord(boggle);
	}

}
