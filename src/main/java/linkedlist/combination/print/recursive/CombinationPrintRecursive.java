package linkedlist.combination.print.recursive;

import java.util.LinkedList;
import java.util.List;

public class CombinationPrintRecursive {
    public static void main(String[] args) {
        CombinationPrintRecursive cc = new CombinationPrintRecursive();
        System.out.println(cc.combine(5, 3));
    }

    public List<List<Integer>> combine(int n, int k) {
        if(k > n) {
            return new LinkedList<>();
        }

        if(k == 0) {
            List<Integer> innerList = new LinkedList<>();
            List<List<Integer>> outerList = new LinkedList<>();
            outerList.add(innerList);
            return outerList;
        }

        List<List<Integer>> finalList = new LinkedList<>();

        List<List<Integer>> includedList = combine(n - 1, k - 1);
        List<List<Integer>> excludedList = combine(n - 1, k);

        for(List<Integer> included : includedList) {
            included.add(n);
            finalList.add(included);
        }

        for(List<Integer> excluded : excludedList) {
            finalList.add(excluded);
        }

        return finalList;
    }
}
