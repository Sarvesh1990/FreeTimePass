package arrays.combination.sum;

import java.util.ArrayList;

/**
 * Created by apple on 11/04/17.
 */

/*
Do by dynamic programming. Keep int[target + 1][array.length + 1];
Initialise int[target][0] and int[0][array.length] = 0;
Do DP
 */
public class CountOfSubArraysWithSumTarget {
    public static void main(String[] args) {
        int[] nums = new int[] {1, 2, 3};
        System.out.println(combinationSum4(nums, 4));
    }

    public static int combinationSum4(int[] nums, int target) {
        int[][]sums = new int[target + 1][nums.length + 1];
        for(int i = 0; i <= nums.length; i++) {
            sums[0][i] = 0;
        }
        for(int i = 1; i <= target; i++) {
            sums[i][0] = 0;
        }

        for(int i = 1; i <= target; i++) {
            for(int j = 1; j <= nums.length; j++) {
                sums[i][j] = (nums[j - 1] <= i) ? (nums[j - 1] == i) ? (sums[i - nums[j - 1]][j] + 1 + sums[i][j - 1]) : (sums[i - nums[j - 1]][j] + sums[i][j - 1]) : sums[i][j - 1];
            }
        }
        return sums[target][nums.length];
    }
}
