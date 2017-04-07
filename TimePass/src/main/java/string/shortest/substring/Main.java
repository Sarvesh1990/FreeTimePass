package string.shortest.substring;

import java.util.HashMap;
import java.util.Map;

import static java.lang.Math.min;
import static sun.swing.MenuItemLayoutHelper.max;

/**
 * Created by apple on 25/02/17.
 */
public class Main {
    public static void main(String[] args) {
        shortestSubstring("a", "abc");
    }

    private static void shortestSubstring(String mainStr, String smallStr) {
        String shortestSubString = mainStr;
        String currentString = "";
        int startIndex = 0;
        boolean shortestFound = false;
        Map<Character, Integer> alphabetCount = new HashMap<>();

        for(int i = 0; i < smallStr.length(); i++) {
            alphabetCount.put(smallStr.charAt(i), 0);
        }

        for(int i = 0; i < mainStr.length(); i++) {
            if(alphabetCount.containsKey(mainStr.charAt(i))) {
                alphabetCount.put(mainStr.charAt(i), alphabetCount.get(mainStr.charAt(i)) + 1);
            }

            boolean allCharPresent = true;
            for(Character key : alphabetCount.keySet()) {
                if(alphabetCount.get(key) == 0) {
                    allCharPresent = false;
                    break;
                }
            }

            if(allCharPresent) {
                currentString = mainStr.substring(startIndex, i + 1);
                if(currentString.length() < shortestSubString.length()) {
                    shortestFound = true;
                    shortestSubString = currentString;
                }
                for(int j = startIndex; j <= i; j++) {
                    startIndex++;
                    if(alphabetCount.containsKey(mainStr.charAt(j))) {
                        alphabetCount.put(mainStr.charAt(j), alphabetCount.get(mainStr.charAt(j)) - 1);
                        for(Character key : alphabetCount.keySet()) {
                            if(alphabetCount.get(key) == 0) {
                                allCharPresent = false;
                                break;
                            }
                        }
                        if(allCharPresent) {
                            currentString = currentString.substring(1, currentString.length());
                        }
                    } else {
                        currentString = currentString.substring(1, currentString.length());
                    }
                    if(!allCharPresent) {
                        if(currentString.length() < shortestSubString.length()) {
                            shortestSubString = currentString;
                        }
                        break;
                    }
                }
            }
        }
        if(shortestFound)
            System.out.println(shortestSubString);
        else
            System.out.println("No shortest substr");
    }


}
