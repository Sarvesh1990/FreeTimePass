package Trie.trie;

/**
 * Created by sarvesh on 12/3/17.
 */
public class Main {
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("a");
        /*trie.insert("there");
        trie.insert("a");
        trie.insert("answer");
        trie.insert("any");
        trie.insert("by");
        trie.insert("bye");
        trie.insert("their");*/

        System.out.println(trie.searchWithDot(".a"));
        System.out.println(trie.search(""));
        System.out.println(trie.search("b"));
    }
}
