package string.count.palindromes;

import javax.xml.stream.events.Characters;
import java.util.*;

/**
 * Created by apple on 30/03/17.
 */

/*
For palindromes always try to consider current index as mid of palindrome
 */
public class CountNumberOfPalindromesInString {
    public static void main(String[] args) {
        System.out.println(countPalindromes("bbcaacbb"));
    }

    private static Integer countPalindromes(String str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            int j = i - 1;
            int k = i + 1;
            while (j >= 0 && k < str.length()) {
                if (str.charAt(j) == str.charAt(k)) {
                    count++;
                    j--;
                    k++;
                } else {
                    break;
                }
            }
        }

        for (int i = 0; i < str.length() - 1; i++) {
            int j = i - 1;
            int k = i + 2;
            if (str.charAt(i) == str.charAt(i + 1)) {
                count++;
                while (j >= 0 && k < str.length()) {
                    if (str.charAt(j) == str.charAt(k)) {
                        count++;
                        j--;
                        k++;
                    } else {
                        break;
                    }
                }
            }
        }
        return count;
    }
}
