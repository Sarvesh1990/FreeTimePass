package string.kmp;

/**
 * Created by sarvesh on 27/3/17.
 */

/*
Preprocess pattern, for every index find length of largest prefix which is also suffix.
Now traverse the string and match pattern. When the character doesn't match, skip the prefix count number of characters as they
were also suffix.
 */
public class PatternSearchKMP {
    public static void main(String[] args) {
        String str = "AABAACAADAAAABA";
        String pat = "AABA";
//        findMatchingIndex(str, pat);
    }

    private static void findMatchingIndex(String str, String pat) {
        int[] lps = new int[pat.length()];

        lps[0] = 0;

        int len = 0;

        for(int i = 1; i < pat.length(); i++) {
            if(pat.charAt(len) == pat.charAt(i)) {
                len++;
                lps[i] = len;
            } else {
                while (len > 0) {
                    if(pat.charAt(len) == pat.charAt(i)) {
                        len++;
                        break;
                    } else {
                        len = lps[len - 1];
                    }
                }
                lps[i] = len;
            }
        }

        int j = 0;
        int i = 0;

        while(i < str.length()) {
            if(str.charAt(i) == pat.charAt(j)) {
                i++;
                j++;
                if(j == pat.length()) {
                    System.out.println("Pattern found at " + (i - j));
                    j = lps[j - 1];
                }
            } else {
                if(j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }
    }


}
