package Tries;

public class Client {

	public static void main(String[] args) {
		Tries trie = new Tries();
		trie.addWord("art");
		trie.addWord("arts");
		trie.addWord("stock");
		trie.addWord("stop");
		trie.addWord("see");
		trie.addWord("sea");
		trie.addWord("buy");
		trie.addWord("bull");
		trie.addWord("up");
		trie.displayAsWords();
		System.out.println(trie.searchWord("bull"));
		trie.remove("bull");
		trie.displayAsWords();
		System.out.println(trie.searchWord("buy"));
		trie.remove("buy");
		trie.displayAsTree();
	}

}
