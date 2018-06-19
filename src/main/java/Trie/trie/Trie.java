package Trie.trie;

/**
 * Created by sarvesh on 12/3/17.
 */
public class Trie {
    public boolean isLeaf;
    public Trie[] characters = new Trie[26];

    public Trie() {
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        Trie[] tempChar = characters;
        for(int i = 0; i < word.length(); i++) {
            if(tempChar[word.charAt(i) - 97] != null) {
                if(i == word.length() - 1) {
                    tempChar[word.charAt(i) - 97].isLeaf = true;
                }
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

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Trie tempChar = this;
        for(int i = 0; i < word.length(); i++) {
            if(tempChar.characters[word.charAt(i) - 97] == null) {
                return false;
            }
            tempChar = tempChar.characters[word.charAt(i) - 97];

        }
        return tempChar.isLeaf;
    }

    /** Returns if the word is in the trie. */
    public boolean searchWithDot(String word) {
        Trie tempChar = this;
        for(int i = 0; i < word.length(); i++) {
            if(word.charAt(i) != '.') {
                if(tempChar.characters[word.charAt(i) - 97] == null) {
                    return false;
                }
                tempChar = tempChar.characters[word.charAt(i) - 97];
            } else {
                for(int j = 0; j < 26; j++) {
                    if(tempChar.characters[j] != null) {
                        if(tempChar.characters[j].searchWithDot(word.substring(i+1, word.length()))) {
                            return true;
                        }
                    }
                }
                return false;
            }

        }
        return tempChar.isLeaf;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Trie tempChar = this;
        for(int i = 0; i < prefix.length(); i++) {
            if(tempChar.characters[prefix.charAt(i) - 97] == null) {
                return false;
            }
            tempChar = tempChar.characters[prefix.charAt(i) - 97];
        }
        return true;
    }
}
