package string.word.dict;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by sarvesh on 6/4/17.
 */
public class Main {
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
