package arrays.max.subarray.less.k;

import static java.lang.Math.max;

/**
 * Created by sarvesh on 20/3/17.
 */
public class Main {
    public static void main(String[] args) {
        int[] array = new int[] {1, 4, 7};
        System.out.println(maxSubArray(array, 4));
    }

    private static Integer maxSubArray(int[] array, int sum) {
        int[][] maxSubArraySize = new int[array.length + 1][sum + 1];

        for(int i = 0; i <= array.length; i++) {
            for(int j = 0; j <= sum; j++) {
                if(i == 0 || j == 0) {
                    maxSubArraySize[i][j] = 0;
                } else {
                    int maxSize1 = (j - array[i - 1] >= 0) ? (1 +  maxSubArraySize[i - 1][j - array[i - 1]]) : 0;
                    int maxSize2 = maxSubArraySize[i - 1][j];
                    maxSubArraySize[i][j] = max(maxSize1, maxSize2);
                }
            }
        }
        return maxSubArraySize[array.length][sum];
    }
}
