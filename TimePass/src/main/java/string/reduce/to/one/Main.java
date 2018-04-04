package string.reduce.to.one;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String str = "ABACABB";
        LinkedList<Character> charList = new LinkedList<>();

        for(int i = 0; i < str.length(); i++) {
            charList.add(str.charAt(i));
        }

        System.out.println(reduceToOne(charList));
    }

    private static LinkedList<Character> reduceToOne(LinkedList<Character> charList) {
        if(charList.size() == 0) {
            return null;
        }

        while (charList.size() != 1) {
            Character first = charList.get(0);
            Character second = charList.get(1);

            Character reduced = findReduced(first, second);

            if(reduced != null){
                System.out.println(charList);
                charList.remove(0);
                charList.remove(0);
                charList.add(0, reduced);
            } else {
                System.out.println(charList);
                LinkedList<Character> tempList = charList;
                tempList.remove(0);
                LinkedList<Character> last = reduceToOne(tempList);

                reduced = findReduced(charList.get(0), last.get(0));
                if(reduced != null) {
                    last.remove(0);
                    last.add(0, reduced);
                    charList = last;
                } else {
                    last.add(0, charList.get(0));
                    return last;
                }
            }
        }

        return charList;

    }

    private static Character findReduced(Character first, Character second) {
        if(first == second) {
            return null;
        } else if((first == 'A' && second == 'B') || (first == 'B' && second == 'A')) {
            return 'C';
        } else if((first == 'A' && second == 'C') || (first == 'C' && second == 'A')) {
            return 'B';
        } else {
            return 'A';
        }
    }
}
