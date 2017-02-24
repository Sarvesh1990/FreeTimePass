package dynamic.planning.dot.array;

import static java.lang.Math.max;

/**
 * Created by apple on 23/02/17.
 */
public class Main {
    public static void main(String[] args) {
        int[] array1 = new int[] {1, 2, 3, 6, 1, 4};
        int[] array2 = new int[] {4, 5, 1};

        System.out.println(findDot(array1, array2));
    }

    private static int findDot(int[] array1, int[] array2) {
        int[][] dot = new int[array1.length + 1][array2.length + 1];
        for(int i = 0; i <= array1.length; i ++) {
            dot[i][0] = 0;
        }
        for (int j = 0; j <= array2.length; j++) {
            dot[0][j] = 0;
        }

        for(int i = 1; i <= array1.length; i++) {
            for (int j = 1; j <= array2.length; j++) {
                dot[i][j] = max((array1[i-1]*array2[j-1] + dot[i-1][j-1]), dot[i - 1][j]);
            }
        }
        return dot[array1.length][array2.length];
    }
}
