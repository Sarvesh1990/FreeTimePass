package arrays.subsets;

import java.util.*;

/**
 * Created by sarvesh on 6/4/17.
 */

public class Main {
    public static void main(String[] args) {
        int[] nums = new int[] {1, 2 , 2};
        System.out.println(subsets(nums));
    }

    private static List<List<Integer>> subsets(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> subsetList = subSetHelper(nums, nums.length);
        List<List<Integer>> subset = new LinkedList<>();
        subset.addAll(subsetList);
        return subset;
    }

    private static Set<List<Integer>> subSetHelper(int[] sums, int length) {
        Set<List<Integer>> subsetList = new HashSet<>();
        if(length == 1) {
            subsetList.add(new LinkedList<Integer>(){
                {
                    add(sums[0]);
                }
            });
            subsetList.add(new LinkedList<>());
            return subsetList;
        } else {
            subsetList = subSetHelper(sums, length - 1);
            List<List<Integer>> temporaryList = new LinkedList<>();
            temporaryList.addAll(subsetList);
            for (int i = 0; i < temporaryList.size(); i++) {
                List<Integer> subset = temporaryList.get(i);
                List<Integer> newList = new LinkedList<>();
                newList.addAll(subset);
                newList.add(sums[length - 1]);
                subsetList.add(newList);
            }
            return subsetList;
        }
    }
}
