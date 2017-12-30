package Lecture31;


public class Trie_Client {

	public static void main(String[] args) {

		Trie trie = new Trie();
		trie.addword("art");
		trie.addword("arts");
		trie.addword("as");
		trie.addword("stock");
		trie.addword("stop");
		trie.addword("sell");
		trie.addword("see");
		trie.addword("sea");
		trie.addword("buy");
		trie.addword("bull");
		trie.display();
		System.out.println(trie.searchWord("art"));
		trie.remove("art");
		System.out.println(trie.searchWord("st"));
		trie.displayAstree();
	}

}
