package Trie.trie;

/**
 * Created by sarvesh on 12/3/17.
 */
public class Main {
    public static void main(String[] args) {
        Trie trie = new Trie();
<<<<<<< HEAD:InterviewPractise/src/main/java/Trie/trie/Main.java
        trie.insert("abc");
        System.out.println(trie.search("abc"));
        System.out.println(trie.search("ab"));
        trie.insert("ab");
        System.out.println(trie.search("ab"));
        trie.insert("ab");
        System.out.println(trie.search("ab"));

=======
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
>>>>>>> d944d000e8a6479fa26a216827e1a27a432b7e9d:TimePass/src/main/java/Trie/trie/Main.java
    }
}
