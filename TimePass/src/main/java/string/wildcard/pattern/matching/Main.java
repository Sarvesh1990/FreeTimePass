package string.wildcard.pattern.matching;

/**
 * Created by sarvesh on 10/4/17.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(isMatch("aa", "a"));
        System.out.println(isMatch("aa", "aa"));
        System.out.println(isMatch("aa", "*"));
        System.out.println(isMatch("aa", "a*"));
        System.out.println(isMatch("ab", "?*"));
        System.out.println(isMatch("aab", "c*a*b*"));
        System.out.println(isMatch("ho", "ho**"));
    }

    public static boolean isMatch(String s, String p) {
        boolean[][] isMatching = new boolean[s.length() + 1][p.length() + 1];
        isMatching[s.length()][p.length()] = true;
        for(int i = 0; i < s.length(); i++) {
            isMatching[i][p.length()] = false;
        }

        boolean charFound = false;
        for(int j = p.length() - 1; j >= 0; j-- ) {
            if(charFound) {
                isMatching[s.length()][j] = false;
            } else {
                if(p.charAt(j) != '*') {
                    charFound = true;
                    isMatching[s.length()][j] = false;
                } else {
                    isMatching[s.length()][j] = true;
                }
            }
        }

        for(int i = s.length() - 1; i >=0 ; i--) {
            for(int j = p.length() - 1; j >= 0; j--) {
                if(p.charAt(j) != '*') {
                    if(p.charAt(j) == '?') {
                        isMatching[i][j] = isMatching[i + 1][j + 1];
                    } else {
                        if (s.charAt(i) == p.charAt(j)) {
                            isMatching[i][j] = isMatching[i + 1][j + 1];
                        } else {
                            isMatching[i][j] = false;
                        }
                    }
                } else {
                    isMatching[i][j] = isMatching[i][j + 1] || isMatching[i + 1][j];
                }
            }
        }

        return isMatching[0][0];
    }
}
