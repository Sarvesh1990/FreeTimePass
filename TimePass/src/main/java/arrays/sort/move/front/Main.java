package arrays.sort.move.front;

import java.util.Arrays;

/**
 * Created by apple on 26/02/17.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(numStepsSort(new int[] {3, 5, 7, 9, 8}));
    }

    private static Integer numStepsSort(int[] ints) {

        int[] sortedArray = Arrays.copyOf(ints, ints.length);
        Arrays.sort(sortedArray);

        int i = ints.length - 1;
        int j = ints.length - 1;

        int count = 0;
        while(i >= 0) {
            if(ints[i] == sortedArray[j]) {
                i--;
                j--;
            } else {
                while(i >= 0 && ints[i] != sortedArray[j]) {
                    i--;
                    count++;
                }
                if(i >= 0) {
                    i--;
                    j--;
                }
            }
        }
        return count;
    }


}
