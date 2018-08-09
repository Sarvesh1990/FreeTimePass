package string.regex;

import java.util.HashMap;
import java.util.Map;

public class RegexMatchingWithStarAndQuestion {
    Map<String, Boolean> isMatchMap = new HashMap<>();

    public static void main(String[] args) {
        System.out.println(new RegexMatchingWithStarAndQuestion().isMatch("acdcb", "a*c?b"));
    }

    public boolean isMatch(String s, String p) {
        if(isMatchMap.containsKey(s + "|" + p)) {
            return isMatchMap.get(s + "|" + p);
        }

        System.out.println("S is : " + s + ", p is : " + p);
        if(p.length() == 0) {
            isMatchMap.put((s + "|" + p), s.length() == 0);
            return s.length() == 0;
        }

        if(s.length() == 0) {
            for(int i = 0; i < p.length(); i++) {
                if(p.charAt(i) != '*') {
                    isMatchMap.put((s + "|" + p), false);
                    return false;
                }
            }
            isMatchMap.put((s + "|" + p), true);
            return true;
        }

        if(s.charAt(0) == p.charAt(0) || p.charAt(0) == '?') {
            Boolean isCorrect = isMatch(s.substring(1), p.substring(1));
            isMatchMap.put((s + "|" + p), isCorrect);
            return isCorrect;
        } else if (p.charAt(0) == '*'){
            Boolean isCorrect = isMatch(s, p.substring(1)) || isMatch(s.substring(1), p);
            isMatchMap.put((s + "|" + p), isCorrect);
            return isCorrect;
        }

        isMatchMap.put((s + "|" + p), false);
        return false;
    }
}
