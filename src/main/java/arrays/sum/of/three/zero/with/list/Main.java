package arrays.sum.of.three.zero.with.list;

import java.util.*;

/**
 * Created by apple on 13/06/18.
 */

/* Sort the array as it is n^2 and sorting can be done in nLogn. Sorting will help us avoid duplicates very easily
    After sorting start with i==0, skip if number same as i-1 and call for sumTwo.
    SumTwo starts with i = arrayIndex and end = nums.length - 1 and keep checking sum. Depending on sum value with needed target to you
    move start or end. Since we need to avoid duplicates keep moving till you find same
 */
public class Main {
    public static void main(String[] args) {

        System.out.println(threeSum(new int[] {1, 2, 2, -4, 7}));

    }

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> triplets = new LinkedList<>();

        for(int i = 0; i < nums.length - 2; i++) {
            if(i == 0 || nums[i] != nums[i - 1]) {
                List<List<Integer>> duplets = sumOfTwo(nums, i + 1, 0 - nums[i]);
                if(duplets.size() > 0) {
                    for(List<Integer> duplet : duplets) {
                        duplet.add(nums[i]);
                        triplets.add(duplet);
                    }
                }
            }
        }
        return triplets;
    }

    private static List<List<Integer>> sumOfTwo(int[] nums, int arrayIndex, int sumValue) {
        int start = arrayIndex;
        int end = nums.length - 1;

        List<List<Integer>> duplets = new LinkedList<>();

        while(end > start) {
            if(nums[start] + nums[end] == sumValue) {
                List<Integer> duplet = new LinkedList<>();
                duplet.add(nums[start]);
                duplet.add(nums[end]);
                duplets.add(duplet);
                while(start < nums.length - 1 && nums[start + 1] == nums[start]) {
                    start++;
                }
                start++;

                while(end > 0 && nums[end - 1] == nums[end]) {
                    end--;
                }
                end--;
            } else if (nums[start] + nums[end] > sumValue) {
                while(end > 0 && nums[end - 1] == nums[end]) {
                    end--;
                }
                end--;
            } else {
                while(start < nums.length - 1 && nums[start + 1] == nums[start]) {
                    start++;
                }
                start++;
            }
        }

        return duplets;
    }
}
