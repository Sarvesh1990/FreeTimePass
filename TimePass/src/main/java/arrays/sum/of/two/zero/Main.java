package arrays.sum.of.two.zero;

import java.util.*;

/**
 * Created by apple on 13/06/18.
 */

/* Sort the array as it is n^2 and sorting can be done in nLogn. Sorting will help us avoid duplicates very easily
    After sorting start with i==0, skip if number same as i-1 and call for sumTwo. In sumTwo remove both number and other number from map.
    Also check while traversing if map contains number.
 */
public class Main {
    public static void main(String[] args) {

        System.out.println(threeSum(new int[] {0, 0, 0}));

    }

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> triplets = new LinkedList<>();

        for(int i = 0; i < nums.length - 2; i++) {
            if(i == 0 || nums[i] != nums[i - 1]) {
                List<List<Integer>> duplets = sumOfTwo(nums, i + 1, nums[i]);
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
        Map<Integer, Integer> numPos = new HashMap<>();
        List<List<Integer>> duplets = new LinkedList<>();
        for(int i = arrayIndex; i < nums.length; i++) {
                numPos.put(nums[i], i);
        }

        for(int i = arrayIndex; i < nums.length; i++) {
            if(numPos.containsKey(nums[i]) && numPos.containsKey(-(sumValue) - nums[i]) && numPos.get(-(sumValue) - nums[i]) != i) {
                List<Integer> duplet = new LinkedList<>();
                duplet.add(nums[i]);
                duplet.add(-(sumValue) - nums[i]);
                duplets.add(duplet);
            }
            numPos.remove(nums[i]);
            if(nums[i] != -(sumValue) - nums[i]) {
                numPos.remove(-(sumValue) - nums[i]);
            }
        }
        return duplets;
    }
}
