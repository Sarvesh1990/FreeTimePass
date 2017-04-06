package string.multiply.numbers;

import java.util.ArrayList;

/**
 * Created by apple on 31/03/17.
 */
public class Another {
    public static void main(String[] args) {
        multiply("123", "3");
    }

    public static String multiply(String first, String second) {
        ArrayList<ArrayList<Character>> arrayOfSums = new ArrayList<>();
        for(int i = first.length() - 1; i >= 0; i--) {
            ArrayList<Character> singleMulti = new ArrayList<>();
            int carryForward = 0;
            int number1 = Integer.parseInt(first.substring(i, i+1));
            for(int j = 1; j < (first.length() - i); j++) {
                singleMulti.add('0');
            }
            for(int k = second.length() - 1; k >= 0; k--) {
                int number2 = Integer.parseInt(second.substring(k, k+1));
                int multi = (number1 * number2) + carryForward;
                int value = (multi % 10);
                carryForward = multi / 10;
                singleMulti.add((char) ('0' + value));
            }
            if(carryForward > 0) {
                singleMulti.add((char) ('0' + carryForward));
            }
            arrayOfSums.add(singleMulti);
        }
        ArrayList<Character> finalSum = new ArrayList<>();
        int carryForwardSum = 0;
        while(!arrayOfSums.isEmpty()) {
            int sum = 0;
            for(int i = 0; i < arrayOfSums.size(); i++) {
                if(!arrayOfSums.get(i).isEmpty()){
                    //Do something
                    Character chara = arrayOfSums.get(i).remove(0);
                    int number = (int) (chara - '0');
                    sum = sum + number;
                } else {
                    arrayOfSums.remove(i);
                    i--;
                }
            }
            sum = sum + carryForwardSum;
            finalSum.add((char) ('0' + sum % 10));
            carryForwardSum = sum / 10;
        }

        if(carryForwardSum > 0)
            finalSum.add((char) ('0' + carryForwardSum));

        System.out.println(finalSum);
        return null;
    }



}
