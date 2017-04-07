package string.multiply.numbers;

import java.util.ArrayList;

/**
 * Created by apple on 08/03/17.
 */
public class Main {
    public static void main(String[] args) {
        multiply("6789", "6788");
    }

    private static void multiply(String first, String second) {
        ArrayList<ArrayList<Integer>> arrayOfSums = new ArrayList<>();
        for(int i = first.length() - 1; i >= 0; i--) {
            ArrayList<Integer> array = new ArrayList<>();
            int carryForward = 0;
            int number1 = Integer.parseInt(String.valueOf(first.charAt(i)));
            for(int k = 1; k < (first.length() - i); k++) {
                array.add(0);
            }
            for(int j = second.length() - 1; j >= 0; j--) {
                int number2 = Integer.parseInt(String.valueOf(second.charAt(j)));
                int value = number2*number1 + carryForward;
                array.add(value % 10);
                carryForward = value/10;
            }
            if(carryForward > 0)
                array.add(carryForward);
            arrayOfSums.add(array);
        }
        System.out.println(arrayOfSums);
        ArrayList<Integer> finalArray = new ArrayList<>();
        int carryForward = 0;

        while(!arrayOfSums.isEmpty()) {
            int sum = 0;
            for(int i = 0; i < arrayOfSums.size(); i ++) {
                if(!arrayOfSums.get(i).isEmpty()) {
                    sum = sum + arrayOfSums.get(i).remove(0);
                } else {
                    arrayOfSums.remove(i);
                    i--;
                }
            }
            sum = sum + carryForward;
            finalArray.add(sum % 10);
            carryForward = sum / 10;
        }
        System.out.println(finalArray);
    }
}
