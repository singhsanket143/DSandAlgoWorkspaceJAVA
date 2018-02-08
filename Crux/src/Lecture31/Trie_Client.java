package Lecture31;

public class Trie_Client {

	public static void main(String[] args) {

		Trie trie = new Trie();
		// trie.addword("111");
		// trie.addword("011");
//		trie.addword("geeksforgeeks");
//		trie.addword("geeks");
//		trie.addword("geek");
//		trie.addword("geezer");
		// trie.addword("cater");
		// trie.addword("children");
		// trie.addword("basement");
		// trie.addword("bull");
//		trie.display();
		// System.out.println(trie.searchWord("art"));
		// trie.remove("art");
		// System.out.println(trie.searchWord("ee"));
//		System.out.println(trie.longestCommonPrefix());
		String[] arr = { "abc", "xyxcba", "geekst", "or","keeg", "bc"};
		for(int i=0;i<arr.length;i++) {
			StringBuilder sb = new StringBuilder();
			for(int j=arr[i].length()-1;j>=0;j--) {
				sb.append(arr[i].charAt(j));
			}
			trie.addword(sb.toString());
		}
		trie.palindromicPair(arr);
		// trie.displayAstree();
		// System.out.println(trie.longestMatchingrefix("mn"));
	}

}
