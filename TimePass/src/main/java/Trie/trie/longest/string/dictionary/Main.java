package Trie.trie.longest.string.dictionary;

import Trie.trie.Trie;

/**
 * Created by apple on 19/03/17.
 */
public class Main {
    public static void main(String[] args) {
        Trie trie = new Trie();
        String[] dict = new String[4];
        dict[0] = "ale";
        dict[1] = "apple";
        dict[2] = "monkey";
        dict[3] = "pleads";

        for (int i = 0; i < dict.length; i++) {
            trie.insert(dict[i]);
        }

        System.out.println(findLongest("abpcpleadalklas", 0, trie));
    }

    private static String findLongest(String str, int startIndex, Trie trie) {
        if(trie.isLeaf) {
            return "";
        }

        if(startIndex == str.length()) {
            return "";
        }

        String str1 = "";
        for(int i = 0; i < trie.characters.length; i++) {
            if(trie.characters[str.charAt(startIndex) - 97] != null) {
                str1 = str.charAt(startIndex) + findLongest(str, startIndex + 1, trie.characters[str.charAt(startIndex) - 97]);
                break;
            }
        }

        String str2 = findLongest(str, startIndex + 1, trie);
        if(str1.length() >= str2.length()) {
            return str1;
        } else {
            return str2;
        }
    }
}

