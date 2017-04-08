package Trie.trie;

/**
 * Created by sarvesh on 12/3/17.
 */
public class Main {
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("abc");
        System.out.println(trie.search("abc"));
        System.out.println(trie.search("ab"));
        trie.insert("ab");
        System.out.println(trie.search("ab"));
        trie.insert("ab");
        System.out.println(trie.search("ab"));

    }
}
