package string.substring;

import java.util.*;

/**
 * Created by apple on 25/02/17.
 */
public class Main {
    public static String minWindow(String s, String t) {
        Map<Character, Integer> patternMap = new HashMap<>();
        Map<Character, Integer> fixedPatternMap = new HashMap<>();
        for(int i = 0; i < t.length(); i++) {
            if(patternMap.containsKey(t.charAt(i))) {
                patternMap.put(t.charAt(i), patternMap.get(t.charAt(i)) + 1);
                fixedPatternMap.put(t.charAt(i), fixedPatternMap.get(t.charAt(i)) + 1);
            } else {
                patternMap.put(t.charAt(i), 1);
                fixedPatternMap.put(t.charAt(i), 1);
            }
        }

        LinkedList<Integer> secondStringCharIndex = new LinkedList<>();
        Map<Character, Integer> foundTillNow  = new HashMap<>();

        int startIndex = 0;
        int endIndex = 0;
        int length = Integer.MAX_VALUE;
        boolean found = false;
        for(int i = 0; i < s.length(); i++) {
            Character character = s.charAt(i);
            if(fixedPatternMap.containsKey(character)) {
                secondStringCharIndex.add(i);
                if(foundTillNow.containsKey(character)) {
                    foundTillNow.put(character, foundTillNow.get(character) + 1);
                } else {
                    foundTillNow.put(character, 1);
                }
                if(patternMap.containsKey(character)) {
                    if(patternMap.get(character) == 1) {
                        patternMap.remove(character);
                    } else {
                        patternMap.put(character, patternMap.get(character) - 1);
                    }
                }
                while(patternMap.isEmpty()) {
                    found = true;
                    if((secondStringCharIndex.getLast() - secondStringCharIndex.getFirst() + 1 ) < length) {
                        length = secondStringCharIndex.getLast() - secondStringCharIndex.getFirst() + 1;
                        startIndex = secondStringCharIndex.getFirst();
                        endIndex = secondStringCharIndex.getLast();
                    }
                    Character character1 = s.charAt(secondStringCharIndex.removeFirst());
                    if(foundTillNow.get(character1) == 1) {
                        foundTillNow.remove(character1);
                        patternMap.put(character1, 1);
                    } else {
                        foundTillNow.put(character1, foundTillNow.get(character1) - 1);
                        if(foundTillNow.get(character1) < fixedPatternMap.get(character1)) {
                            patternMap.put(character1, 1);
                        }
                    }
                }
            }
        }
        if(found) {
            return s.substring(startIndex, endIndex + 1);
        } else {
            return "";
        }
    }
    public static void main(String[] args) {
        System.out.println(minWindow("a", "a"));
    }
}