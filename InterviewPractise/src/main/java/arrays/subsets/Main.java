package arrays.subsets;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by sarvesh on 6/4/17.
 */

public class Main {
    public static void main(String[] args) {
        int[] nums = new int[] {1, 2 ,3, 4};
        System.out.println(subsets(nums));
    }

    private static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subsetList = subSetHelper(nums, nums.length);
        return subsetList;
    }

    private static List<List<Integer>> subSetHelper(int[] sums, int length) {
        List<List<Integer>> subsetList = new LinkedList<>();
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
