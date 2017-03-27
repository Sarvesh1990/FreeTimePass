package string.pattern.matching;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by apple on 21/03/17.
 */
public class Main {
    public static void main(String[] args) {
        String[] strList = {"abab", "aba", "xyz", "xyx"};
        matchPattern(strList, "aba");
    }

    private static void matchPattern (String[] strList, String pattern) {
        for (int i = 0; i < strList.length; i++) {
            Map<Character, Character> patternMap = new HashMap<>();
            ArrayList<Character> visitedChars = new ArrayList<>();
            String str = strList[i];
            if (str.length() == pattern.length()) {
                int j;
                for (j = 0; j < pattern.length(); j++) {
                    if (patternMap.containsKey(pattern.charAt(j))) {
                        if (str.charAt(j) != patternMap.get(pattern.charAt(j))) {
                            break;
                        }
                    } else {
                        if (visitedChars.contains(str.charAt(j))) {
                            break;
                        } else {
                            patternMap.put(pattern.charAt(j), str.charAt(j));
                            visitedChars.add(str.charAt(j));
                        }
                    }
                }
                if (j == pattern.length()) {
                    System.out.println(str);
                }
            }
        }
    }
}
