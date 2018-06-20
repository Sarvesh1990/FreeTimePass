package string.print.all.numbers;

import java.util.ArrayList;
import java.util.LinkedList;

import static java.lang.Math.pow;

/**
 * Created by apple on 06/03/17.
 */

/*
Call for currentIndex + 1. In that add currentElement in start and in multiplication
 */
public class PrintAllNumbers {
    public static void main(String[] args) {
        System.out.println(printAllNums("1234", 0));
    }

    private static LinkedList<LinkedList<Integer>> printAllNums(String s, int startIndex) {
        if(startIndex >= s.length()) {
            LinkedList<Integer> temp = new LinkedList<>();
            LinkedList<LinkedList<Integer>> tempList = new LinkedList<>();
            tempList.add(temp);
            return tempList;
        }

        LinkedList<LinkedList<Integer>> numberCombination = printAllNums(s, startIndex + 1);
        LinkedList<LinkedList<Integer>> numberCombinationNew = new LinkedList<>(numberCombination);

        for(LinkedList<Integer> integers : numberCombination) {
            if(integers.size() != 0) {
                LinkedList<Integer> newIntegers = new LinkedList<>(integers);
                int number = newIntegers.removeFirst();
                int count = countDigit(number);

                newIntegers.addFirst((int) (Integer.parseInt(String.valueOf(s.charAt(startIndex)))*(Math.pow(10, count)) + number));
                numberCombinationNew.add(newIntegers);
            }
            integers.addFirst(Integer.parseInt(String.valueOf(s.charAt(startIndex))));
        }

        return numberCombinationNew;
    }

    public static int countDigit(long n) {
        int count = 0;
        while (n != 0) {
            n = n / 10;
            ++count;
        }
        return count;
    }


}
