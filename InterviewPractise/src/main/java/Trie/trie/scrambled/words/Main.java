package Trie.trie.scrambled.words;

import Trie.trie.Trie;

import java.util.ArrayList;

/**
 * Created by sarvesh on 20/3/17.
 */
public class Main {
    public static void main(String[] args) {
        Trie trie = new Trie();
        String[] dict = new String[4];
        dict[0] = "hello";
        dict[1] = "to";
        dict[2] = "the";
        dict[3] = "worl";
//        dict[3] = "world";

        for(int i = 0; i < dict.length; i++) {
            trie.insert(dict[i]);
        }

        System.out.println(origStr("elhloothtedrowld", 0, trie));
    }

    private static String origStr(String str, int startIndex, Trie trie) {
        if(startIndex == str.length()) {
            return "";
        }

        Trie tempTrie = trie;
        ArrayList<Integer> indexFound = new ArrayList<>();
        int currentLength = 0;
        int maxLength = 1;
        int secondStartIndex = startIndex;

        for(int i = startIndex; i < str.length(); i++) {
            for(int j = 0; j < tempTrie.characters.length; j++) {
                if(!indexFound.contains(i)) {
                    if (tempTrie.characters[str.charAt(i) - 97] != null) {
                        System.out.println(str.charAt(i));
                        if (maxLength < i + 1 - startIndex) {
                            maxLength = i + 1 - startIndex;
                        }
                        currentLength++;
                        indexFound.add(i);
                        if (currentLength == maxLength && tempTrie.characters[str.charAt(i) - 97].isLeaf) {
                            String further = origStr(str, maxLength + startIndex, trie);
                            if (!further.equals("-1")) {
                                return str.substring(startIndex, maxLength + startIndex) + " " + further;
                            }
                        }
                        tempTrie = tempTrie.characters[str.charAt(i) - 97];
                        i = startIndex - 1;
                        break;
                    }
                }
            }
            if(i == str.length() - 1 && secondStartIndex != str.length() - 1) {
                secondStartIndex = secondStartIndex  + 1;
                i  = secondStartIndex - 1;
                currentLength = 0;
                maxLength = 1;
                indexFound.clear();
                tempTrie = trie;
            }
        }

        return "-1";
    }
}
