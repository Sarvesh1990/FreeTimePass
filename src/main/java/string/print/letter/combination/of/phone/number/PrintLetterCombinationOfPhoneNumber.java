package string.print.letter.combination.of.phone.number;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/*
Add for i = 0;
Then for each element add all combination and keep creating new list;
 */

public class PrintLetterCombinationOfPhoneNumber {
    public static void main(String[] args) {
        letterCombinations("232");
    }

    public static void letterCombinations(String digits) {
        Map<Integer, ArrayList<Character>> digitMap = new HashMap<>();
        digitMap.put(0, new ArrayList<>());
        digitMap.put(1, new ArrayList<>());
        digitMap.put(2, new ArrayList<Character>(){
            {
                add('a');
                add('b');
                add('c');
            }
        });
        digitMap.put(3, new ArrayList<Character>(){
            {
                add('d');
                add('e');
                add('f');
            }
        });
        digitMap.put(4, new ArrayList<Character>(){
            {
                add('g');
                add('h');
                add('i');
            }
        });
        digitMap.put(5, new ArrayList<Character>(){
            {
                add('j');
                add('k');
                add('l');
            }
        });
        digitMap.put(6, new ArrayList<Character>(){
            {
                add('m');
                add('n');
                add('o');
            }
        });
        digitMap.put(7, new ArrayList<Character>(){
            {
                add('p');
                add('q');
                add('r');
                add('s');
            }
        });
        digitMap.put(8, new ArrayList<Character>(){
            {
                add('t');
                add('u');
                add('v');
            }
        });
        digitMap.put(9, new ArrayList<Character>(){
            {
                add('w');
                add('x');
                add('y');
                add('z');
            }
        });

        LinkedList<String> currentList = new LinkedList<>();
        LinkedList<String> temporaryList = new LinkedList<>();

        for(int i = 0; i < digits.length(); i++) {
            if(i == 0) {
                for(int j = 0; j < digitMap.get(Integer.parseInt(String.valueOf(digits.charAt(i)))).size(); j++) {
                    currentList.add(String.valueOf(digitMap.get(Integer.parseInt(String.valueOf(digits.charAt(i)))).get(j)));
                }
            } else {
                while (!currentList.isEmpty()) {
                    for(int j = 0; j < digitMap.get(Integer.parseInt(String.valueOf(digits.charAt(i)))).size(); j++) {
                        temporaryList.add(currentList.peek() + String.valueOf(digitMap.get(Integer.parseInt(String.valueOf(digits.charAt(i)))).get(j)));
                    }
                    currentList.pop();
                }
                currentList.addAll(temporaryList);
                temporaryList.clear();
            }
        }

        System.out.println(currentList);
    }

}
