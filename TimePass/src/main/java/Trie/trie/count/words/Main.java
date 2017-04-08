package Trie.trie.count.words;

import Trie.trie.Trie;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by sarvesh on 12/3/17.
 */
public class Main {
    public static void main(String[] args) {
        Trie trie = new Trie();
        String[] dict = new String[4];
        dict[0] = "aca";
        dict[1] = "cat";
        dict[2] = "hell";
        dict[3] = "world";

        for(int i = 0; i < dict.length; i++) {
            trie.insert(dict[i]);
        }

        Map<String, Integer> count = new HashMap<>();

        for(int i= 0; i < dict.length; i++) {
            count.put(dict[i], 0);
        }

        String stream = "acacatbcatghhellworldmvnsdb";

        for(int i = 0; i < stream.length(); i++) {
            Trie tempTrie = trie;
            Trie[] tempChar = tempTrie.characters;
            int j = i;
            while(tempChar[stream.charAt(j) - 97] != null) {
                tempTrie = tempChar[stream.charAt(j) - 97];
                tempChar = tempTrie.characters;
                j++;
                if(tempTrie.isLeaf) {
                    count.put(stream.substring(i, j), count.get(stream.substring(i, j)) + 1);
                }
            }
        }

        System.out.println(count);
    }
}
