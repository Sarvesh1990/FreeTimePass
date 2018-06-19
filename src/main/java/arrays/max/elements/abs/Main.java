package arrays.max.elements.abs;

import static java.lang.Math.abs;

/**
 * Created by sarvesh on 20/3/17.
 */
public class Main {
    public static void main(String[] args) {
        int[] array = {13, 6, 12, 4};
        System.out.println(printMaxElements(array));
    }

    private static Integer printMaxElements(int[] array) {
        int[] maxArray = new int[array.length];
        for(int i = 0; i < array.length; i++) {
            maxArray[i] = 1;
        }

        for(int i = 1; i < array.length; i++) {
            for(int j = 0; j < i; j++) {
                if(abs(array[i] - array[j]) <= abs(i - j)) {
                    int temp = maxArray[j] + 1;
                    if(temp > maxArray[i]) {
                        maxArray[i] = temp;
                    }
                }
            }
        }

        int max = 1;
        for(int i = 0; i < maxArray.length; i++) {
            if(maxArray[i] > max) {
                max = maxArray[i];
            }
        }
        return max;
    }

}
