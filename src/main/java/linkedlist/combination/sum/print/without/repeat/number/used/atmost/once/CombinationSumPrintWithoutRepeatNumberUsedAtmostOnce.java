package linkedlist.combination.sum.print.without.repeat.number.used.atmost.once;

import java.util.*;

/*
Simple recursive approach. In case of boundary if startIndex == candidate.length return single entry linkedlist if target ==0.
Use set to hold internal list. Sort internal list before adding.
 */

public class CombinationSumPrintWithoutRepeatNumberUsedAtmostOnce {
    public static void main(String[] args) {
        CombinationSumPrintWithoutRepeatNumberUsedAtmostOnce cc = new CombinationSumPrintWithoutRepeatNumberUsedAtmostOnce();
        System.out.println(cc.combinationSum(new int[] {10,1,2,7,6,1,5}, 8));
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        return combinationSumHelper(candidates, target, 0);
    }

    public List<List<Integer>> combinationSumHelper(int[] candidates, int target, int startIndex) {
        if(startIndex > candidates.length || target < 0) {
            return new LinkedList<>();
        }

        if(startIndex == candidates.length && target != 0) {
            return new LinkedList<>();
        }

        if(target == 0) {
            List<Integer> blankList = new LinkedList<>();
            List<List<Integer>> blankListOfList = new LinkedList<>();
            blankListOfList.add(blankList);
            return blankListOfList;
        }

        List<List<Integer>> includeCurrentIndex = combinationSumHelper(candidates, target - candidates[startIndex], startIndex + 1);
        List<List<Integer>> excludeCurrentIndex = combinationSumHelper(candidates, target, startIndex + 1);

        Set<List<Integer>> finalList = new HashSet<>();

        for(List<Integer> includedList : includeCurrentIndex) {
            includedList.add(candidates[startIndex]);
            Collections.sort(includedList);
            finalList.add(includedList);
        }

        for(List<Integer> excludedList : excludeCurrentIndex) {
            Collections.sort(excludedList);
            finalList.add(excludedList);
        }


        return new LinkedList<>(finalList);
    }
}
