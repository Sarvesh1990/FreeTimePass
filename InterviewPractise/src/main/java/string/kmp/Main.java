package string.kmp;

/**
 * Created by sarvesh on 27/3/17.
 */
public class Main {
    public static void main(String[] args) {
        String str = "AABAACAADAABAABA";
        String pat = "AABA";
        findMatchingIndex(str, pat);
    }

    private static void findMatchingIndex(String str, String pat) {
        int[] lps = new int[pat.length()];

        lps[0] = 0;

        for(int i = 1; i < lps.length; i++) {
            int count = 0;
            int j = i;
            int k = j - 1;
            while(j > 0 && k >= 0) {
                while(pat.charAt(j) == pat.charAt(k)) {
                    j--;
                    k--;
                    count++;
                }
                if(j == 0) {
                    lps[i] = count;
                } else {
                    j = i;
                }
            }
        }

        for(int i = 0; i < lps.length; i++) {
            System.out.println(lps[i]);
        }
    }


}
