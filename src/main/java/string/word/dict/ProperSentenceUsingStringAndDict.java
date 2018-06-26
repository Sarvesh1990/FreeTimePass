package string.word.dict;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by sarvesh on 6/4/17.
 */

/*
Given a dictionary of words and a string, check if string can be broken into multiple words all of which are in dictionary
Done by DP.
Start with i = 1 to i = str.length, check if wb[i] = true. If yes, it means till i word can be formed. So in that case check for j = i + 1
till j = str.length and mark wb[j] = 1 for all possible words after i.
if wb[i] = false and substring from 0 till i is true, mark wb[i] = true;
O(n2)
 */
public class ProperSentenceUsingStringAndDict {
    public static void main(String[] args) {
        List<String> dict = new LinkedList<>();
        dict.add("leet");
        dict.add("code");
        dict.add("codec");

        String str = "leetcodec";

        System.out.println(wordBreak("leetcodec", dict));
    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        if(s.length() == 0) {
            return true;
        }
        boolean[] wb = new boolean[s.length() + 1];
        for(int i = 1; i <= s.length(); i++) {
            if(wb[i]  == false && wordDict.contains(s.substring(0, i))) {
                wb[i] = true;
            }
            if(wb[i]) {
                if(i == s.length()) {
                    return true;
                }

                for(int j = i + 1; j <= s.length(); j++) {
                    if(wb[j] == false && wordDict.contains(s.substring(i, j))) {
                        wb[j] = true;
                    }

                    if(j == s.length() && wb[j]) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

}
