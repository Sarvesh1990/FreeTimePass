package string.regex;

import java.util.ArrayList;

/**
 * Created by sarvesh on 6/4/17.
 */
public class Main {
    public static void main(String[] args) {
        String s1 = "aab";
        String s2 = "*a*b*";
        System.out.println(isMatch(s1, s2));
    }

    public static boolean isMatch(String s, String p) {
        //Check if currentChar is *
        //If yes : check if currentChar same as previous or previous is . yes i++ else while p[j + 1] == * || p[j] == prev j++
        //If no : Check if currentChar of s == currentChar of p || p == . move both else return false
        //if j != length return false;

        int i = 0;
        int j = 0;

        while(i < s.length() && j < p.length()) {
            if(j < p.length() - 1) {
                if(p.charAt(j + 1) == '*') {
                    if(s.charAt(i) == p.charAt(j) || p.charAt(j) == '.') {
                        return isMatch(s.substring(i + 1), p.substring(j)) || isMatch(s.substring(i), p.substring(j + 2));
                    } else {
                        return isMatch(s.substring(i), p.substring(j + 2));
                    }
                }
            }
            if(s.charAt(i) == p.charAt(j) || p.charAt(j) == '.') {
                i++;
                j++;
            } else {
                return false;
            }
        }
        if(i == s.length() && j == p.length()) {
            return true;
        }

        if(i == s.length()) {
            while(j < p.length()) {
                if(j < p.length() -1 && p.charAt(j + 1) == '*') {
                    j = j + 2;
                } else {
                    return false;
                }
            }
            return true;
        }

        return false;
    }
}
