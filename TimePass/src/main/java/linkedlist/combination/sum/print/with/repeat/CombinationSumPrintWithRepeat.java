package linkedlist.combination.sum.print.with.repeat;


import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/*
This method gives all the sums but not unique. For unique recursion is needed. In this case we use DP. We start from n = 1 and go till n = target
 */

public class CombinationSumPrintWithRepeat {
    public static void main(String[] args) {
        System.out.println(combinationSum(new int[] {2, 3, 5}, 8));
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        Map<Integer, List<List<Integer>>> combinationMap = new HashMap<>();
        for (int i = 1; i <= target; i++) {
            for (int j = 0; j < candidates.length; j++) {
                if (i - (candidates[j]) == 0) {
                    List<Integer> combination = new LinkedList<>();
                    List<List<Integer>> combinationList;
                    combination.add(candidates[j]);
                    if (combinationMap.containsKey(i)) {
                        combinationList = combinationMap.get(i);
                        combinationList.add(combination);
                    } else {
                        combinationList = new LinkedList<>();
                        combinationList.add(combination);
                        combinationMap.put(i, combinationList);
                    }
                } else if ((i - candidates[j]) > 0) {
                    if (combinationMap.containsKey(i - candidates[j])) {
                        List<List<Integer>> combinationList = combinationMap.get(i - candidates[j]);
                        List<List<Integer>> currentCombinationList;
                        if(!combinationMap.containsKey(i)) {
                            currentCombinationList = new LinkedList<>();
                            for (List<Integer> combination : combinationList) {
                                List<Integer> currentCombination = new LinkedList<>(combination);
                                currentCombination.add(candidates[j]);
                                currentCombinationList.add(currentCombination);
                            }
                            combinationMap.put(i, currentCombinationList);
                        } else {
                            currentCombinationList = combinationMap.get(i);
                            for (List<Integer> combination : combinationList) {
                                List<Integer> currentCombination = new LinkedList<>(combination);
                                currentCombination.add(candidates[j]);
                                currentCombinationList.add(currentCombination);
                            }
                            combinationMap.put(i, currentCombinationList);
                        }
                    }
                }
                System.out.println(combinationMap);

            }
        }
        return combinationMap.get(target);
    }
}
