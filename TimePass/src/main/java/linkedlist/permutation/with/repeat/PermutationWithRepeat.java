package linkedlist.permutation.with.repeat;

import linkedlist.permutation.unique.numbers.PermutationUniqueNumbers;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/*
if start > end, return blank list.
if start == end, return single element list
Get start + 1 list. Permute all values. Add current number to all position of each list.

Just use set in this case in the end to avoid repeat list;
 */

public class PermutationWithRepeat {
    public static void main(String[] args) {
        PermutationWithRepeat pu = new PermutationWithRepeat();
        System.out.println(pu.permute(new int[] {1, 1, 2}));
    }

    public List<List<Integer>> permute(int[] nums) {
        return new LinkedList<>(permuteHelper(nums, 0, nums.length - 1));
    }

    public Set<List<Integer>> permuteHelper(int[] nums, int start, int end) {
        if(start > end) {
            return new HashSet<>();
        }

        List<Integer> internalList = null;
        Set<List<Integer>> externalList = null;

        if(start == end) {
            internalList = new LinkedList<>();
            internalList.add(nums[start]);
            externalList = new HashSet<>();
            externalList.add(internalList);
            return externalList;
        }

        externalList = new HashSet<>();

        for(List<Integer> tempList : permuteHelper(nums, start + 1, end)) {
            for(int i = 0; i <= tempList.size(); i++) {
                List<Integer> newList = new LinkedList<>(tempList);
                newList.add(i, nums[start]);
                externalList.add(newList);
                System.out.println(externalList);
            }
        }

        return externalList;
    }
}
