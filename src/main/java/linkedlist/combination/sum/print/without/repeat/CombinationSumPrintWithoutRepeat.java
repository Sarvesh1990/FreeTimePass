package linkedlist.combination.sum.print.without.repeat;

import java.util.LinkedList;
import java.util.List;

/*
In this we include ReverseRecursive approach as we have to print values without repeat. DP won't work here.
 */

public class CombinationSumPrintWithoutRepeat {
    public static void main(String[] args) {
        CombinationSumPrintWithoutRepeat cs = new CombinationSumPrintWithoutRepeat();
        System.out.println(cs.combinationSum(new int[] {2, 3, 6, 7}, 7));
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        return combinationSumHelper(candidates, target, 0);
    }

    public List<List<Integer>> combinationSumHelper(int[] candidates, int target, int startIndex) {
        if(startIndex >= candidates.length || target < 0) {
            return new LinkedList<>();
        }

        if(target == 0) {
            List<Integer> blankList = new LinkedList<>();
            List<List<Integer>> blankListOfList = new LinkedList<>();
            blankListOfList.add(blankList);
            return blankListOfList;
        }

        List<List<Integer>> includeCurrentIndex = combinationSumHelper(candidates, target - candidates[startIndex], startIndex);
        List<List<Integer>> excludeCurrentIndex = combinationSumHelper(candidates, target, startIndex + 1);

        List<List<Integer>> finalList = new LinkedList<>();

        for(List<Integer> includedList : includeCurrentIndex) {
            includedList.add(candidates[startIndex]);
            finalList.add(includedList);
        }

        for(List<Integer> excludedList : excludeCurrentIndex) {
            finalList.add(excludedList);
        }


        return finalList;
    }
}
