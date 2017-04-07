package arrays.sum.of.three.zero;

import java.util.Arrays;

/**
 * Created by apple on 28/03/17.
 */
public class Main {
    public static void main (String[] args) {
        int[] array = {2, 1, -1, -4, 3, 4};
        System.out.println(findIfSumZeroPossible(array));
    }

    private static boolean findIfSumZeroPossible(int[] array) {
        Arrays.sort(array);
        for(int i = 0; i < array.length - 2; i++) {
            int firstNumber = array[i];
            int sumToBeFound = 0 - firstNumber;
            int start = i + 1;
            int end = array.length - 1;
            while(end > start) {
                if(array[start] + array[end] == sumToBeFound) {
                    return true;
                } else if (array[start] + array[end] > sumToBeFound) {
                    end--;
                } else {
                    start++;
                }
            }
        }
        return false;
    }
}
