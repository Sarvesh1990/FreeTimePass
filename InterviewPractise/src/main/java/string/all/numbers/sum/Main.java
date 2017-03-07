package string.all.numbers.sum;

import java.util.ArrayList;
import java.util.LinkedList;

import static java.lang.Math.pow;

/**
 * Created by apple on 06/03/17.
 */
public class Main {
    public static void main(String[] args) {
        printAllNums("12" +
                "");
    }

    private static void printAllNums(String s) {
        LinkedList<LinkedList<String>> numberCombination = new LinkedList<>();
        numberCombination.add(new LinkedList<String>(){
            {
                add(String.valueOf(s.charAt(0)));
            }
        });

        for(int i = 1; i < s.length(); i++) {
            for(int j = 0; j < pow(2, (i-1)); j++) {
                LinkedList<String> numbers = numberCombination.removeFirst();
                LinkedList<String> temp = new LinkedList<>();
                temp.addAll(numbers);
                temp.add(String.valueOf(s.charAt(i)));
                numberCombination.add(temp);
                LinkedList<String> temp1 = new LinkedList<>();
                temp1.addAll(numbers);
                String lastChar = temp1.removeLast();
                temp1.add(lastChar + s.charAt(i));
                numberCombination.add(temp1);
            }
        }

        for(int i = 0; i < numberCombination.size(); i++) {
            System.out.println(numberCombination.get(i));
        }
    }
}
