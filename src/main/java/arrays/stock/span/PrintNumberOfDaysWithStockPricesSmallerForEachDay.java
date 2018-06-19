package arrays.stock.span;

import java.util.Stack;

/**
 * Created by apple on 24/04/17.
 */

/*
For each day, print how many days stock prices were smaller than today
Loop for each day. Make j = i - 1. While (j >= 0), if(array[j] < array[i]) -> increase span by span[j], make j = j - span[j]
 */
public class PrintNumberOfDaysWithStockPricesSmallerForEachDay {
    public static void main(String[] args) {
        int[] array = new int[] {10, 4, 5, 90, 120, 80, 125};
        stockSpan(array);
    }

    private static void stockSpan(int[] array) {
        int[] span = new int[array.length];
        for(int i = 0; i < array.length; i++) {
            int j = i - 1;
            int count = 1;
            while (j >= 0) {
                if (array[j] < array[i]) {
                    count = count + span[j];
                    j = j - span[j];
                } else {
                    break;
                }
            }
            span[i] = count;
        }

        for(int i = 0; i < array.length; i++) {
            System.out.println(span[i]);
        }
    }
}
