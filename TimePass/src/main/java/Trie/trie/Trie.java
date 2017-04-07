package Trie.trie;

/**
 * Created by sarvesh on 12/3/17.
 */
public class Trie {
    public boolean isLeaf;
    public Trie[] characters = new Trie[26];

    public Trie() {
    }

    public void insert(String word) {
        Trie[] tempChar = characters;
        for(int i = 0; i < word.length(); i++) {
            if(tempChar[word.charAt(i) - 97] != null) {
                tempChar = tempChar[word.charAt(i) - 97].characters;
            } else {
                Trie trie = new Trie();
                tempChar[word.charAt(i) - 97] = trie;
                tempChar = trie.characters;
                if(i == word.length() - 1) {
                    trie.isLeaf = true;
                }
            }

        }
    }

    public boolean search(String word) {
        Trie[] tempChar = characters;
        for(int i = 0; i < word.length(); i++) {
            if(tempChar[word.charAt(i) - 97] == null) {
                return false;
            }
            tempChar = tempChar[word.charAt(i) - 97].characters;
        }
        return true;
    }
}
