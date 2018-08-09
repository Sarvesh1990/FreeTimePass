package string.regex;

import java.util.HashMap;
import java.util.Map;

public class RegexMatchingWithStarAfterCharAndDot {
    Map<String, Boolean> isMatchMap = new HashMap<>();

    public static void main(String[] args) {
        System.out.println(new RegexMatchingWithStarAfterCharAndDot().isMatch("aaa", "a*c*a"));
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
            if(p.length() % 2 != 0) {
                isMatchMap.put((s + "|" + p), false);
                return false;
            }

            int i = 1;

            while(i < p.length()) {
                if(p.charAt(i) != '*') {
                    isMatchMap.put((s + "|" + p), false);
                    return false;
                }
                i = i + 2;
            }
            isMatchMap.put((s + "|" + p), true);
            return true;
        }

        if(s.charAt(0) == p.charAt(0) || p.charAt(0) == '.') {
            if(p.length() > 1) {
                if(p.charAt(1) == '*') {
                    Boolean isCorrect = isMatch(s.substring(1, s.length()), p) || isMatch(s, p.substring(2, p.length()));
                    isMatchMap.put((s + "|" + p), isCorrect);
                    return isCorrect;
                }
            }
            Boolean isCorrect = isMatch(s.substring(1, s.length()), p.substring(1, p.length()));
            isMatchMap.put((s + "|" + p), isCorrect);
            return isCorrect;
        } else {
            if(p.length() > 1) {
                if(p.charAt(1) == '*') {
                    Boolean isCorrect = isMatch(s, p.substring(2, p.length()));
                    isMatchMap.put((s + "|" + p), isCorrect);
                    return isCorrect;
                }
            }
        }

        isMatchMap.put((s + "|" + p), false);
        return false;
    }
}
