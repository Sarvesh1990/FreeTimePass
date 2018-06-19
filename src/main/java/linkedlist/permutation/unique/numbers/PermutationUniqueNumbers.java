package linkedlist.permutation.unique.numbers;

import java.util.LinkedList;
import java.util.List;

/*
if start > end, return blank list.
if start == end, return single element list
Get start + 1 list. Permute all values. Add current number to all position of each list.
*/
public class PermutationUniqueNumbers {
    public static void main(String[] args) {
        PermutationUniqueNumbers pu = new PermutationUniqueNumbers();
        System.out.println(pu.permute(new int[] {1, 2, 3}));
    }

    public List<List<Integer>> permute(int[] nums) {
        return permuteHelper(nums, 0, nums.length - 1);
    }

    public List<List<Integer>> permuteHelper(int[] nums, int start, int end) {
        if(start > end) {
            return new LinkedList<>();
        }

        List<Integer> internalList = null;
        List<List<Integer>> externalList = null;

        if(start == end) {
            internalList = new LinkedList<>();
            internalList.add(nums[start]);
            externalList = new LinkedList<>();
            externalList.add(internalList);
            return externalList;
        }

        externalList = new LinkedList<>();

        for(List<Integer> tempList : permuteHelper(nums, start + 1, end)) {
            for(int i = 0; i <= tempList.size(); i++) {
                List<Integer> newList = new LinkedList<>(tempList);
                newList.add(i, nums[start]);
                externalList.add(newList);

            }
        }

        return externalList;
    }
}
