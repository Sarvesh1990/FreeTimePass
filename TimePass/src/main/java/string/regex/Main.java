package string.regex;

import java.util.ArrayList;

/**
 * Created by sarvesh on 6/4/17.
 */
public class Main {
    public static void main(String[] args) {
        String s1 = "aab";
        String s2 = "a*aab*bc*d";
        System.out.println(isMatch(s1, s2));
    }

    public static boolean isMatch(String s, String p) {
        //Check if currentChar is *
        //If yes : check if currentChar same as previous or previous is . yes i++ else while p[j + 1] == * || p[j] == prev j++
        //If no : Check if currentChar of s == currentChar of p || p == . move both else return false
        //if j != length return false;

        int i = 0;
        int j = 0;

        while(i < s.length()) {
            if (j > p.length() - 1) {
                System.out.println("return");
                return false;
            }

            if (j < p.length() - 1) {
                if (p.charAt(j + 1) != '*') {
                    if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.') {
                        i++;
                        j++;
                    } else {
                        System.out.println("Return false " + i + " " + j);
                        return false;
                    }
                } else {
                    if(s.charAt(i) != p.charAt(j) && p.charAt(j) != '.') {
                        j = j + 2;
                    } else {
                        System.out.println(" " + i + " " + j);
                        int countS = 0;
                        int countP = 0;
                        int k = i;
                        int m = j + 1;
                        while(k < s.length()) {
                            if (s.charAt(k) == s.charAt(i)) {
                                countS++;
                                k++;
                            } else {
                                break;
                            }
                        }
                        for (m = j + 2; m < p.length(); m++) {
                            if (p.charAt(m) == p.charAt(j)) {
                                countP++;
                            } else if (p.charAt(m) == '*') {
                                countP--;
                            } else {
                                break;
                            }
                        }

                        if (countS < countP) {
                            System.out.println("returing false ");
                            return false;
                        } else {
                            i = k;
                            j = m;
                        }
                    }
                }
            } else {
                if(s.charAt(i) == p.charAt(j) || p.charAt(j) == '.') {
                    i++;
                    j++;
                } else {
                    return false;
                }
            }
        }

        while(j <= p.length() - 1) {
            System.out.println("Inside while ");
            if(j < p.length() - 1) {
                if(p.charAt(j + 1) == '*') {
                    j = j + 2;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }

        return true;
    }
}
