package string.regex;

import java.util.ArrayList;

/**
 * Created by sarvesh on 6/4/17.
 */
public class Main {
    public static void main(String[] args) {
        String s1 = "aaa";
        String s2 = "ab*a*c*a";
        System.out.println(isMatch(s1, s2));
    }

    private static boolean isMatch(String s1, String s2) {
        int i = 0;
        int j = 0;

        if(s1.charAt(0) == s2.charAt(0)) {
            if(s2.length() > 1) {
                if(s2.charAt(1) == '*') {
                    return isMatch(s1.substring(1, s1.length()), s2.substring(2, s2.length())) || isMatch(s1.substring(1, s1.length()), s2);
                } else {
                    return isMatch(s1.substring(1, s1.length()), s2.substring(1, s2.length()));
                }
            }
        }

        return false;
    }
}
