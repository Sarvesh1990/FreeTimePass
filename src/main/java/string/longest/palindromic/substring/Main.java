package string.longest.palindromic.substring;

/**
 * Created by apple on 06/06/18.
 */

/* Consider each character as centre of palindrome and check for maximum palindrome.
    For cases where even palindrome is there like abba -> consider blank space as centre of palindrome.
    Time complexity - n^2
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("cbbd"));
    }

    public static  String longestPalindrome(String s) {
        int longestSubStrLen = 0;
        String longestSubStr = "";

        for(int i = 0; i < s.length(); i++) {
            int middleLeft = i - 1;
            int middleRight = i + 1;
            int currentSubStrLen = 1;
            while(middleLeft >= 0 && middleRight < s.length() && s.charAt(middleLeft) == s.charAt(middleRight)) {
                currentSubStrLen = currentSubStrLen + 2;
                middleLeft--;
                middleRight++;
            }
            if(currentSubStrLen > longestSubStrLen) {
                longestSubStrLen = currentSubStrLen;
                longestSubStr = s.substring(middleLeft + 1, middleRight);
            }

            middleLeft = i;
            middleRight = i + 1;
            currentSubStrLen = 0;
            while(middleLeft >= 0 && middleRight < s.length() && s.charAt(middleLeft) == s.charAt(middleRight)) {
                currentSubStrLen = currentSubStrLen + 2;
                middleLeft--;
                middleRight++;
            }
            if(currentSubStrLen > longestSubStrLen) {
                longestSubStrLen = currentSubStrLen;
                longestSubStr = s.substring(middleLeft + 1, middleRight);
            }
        }

        return longestSubStr;
    }
}