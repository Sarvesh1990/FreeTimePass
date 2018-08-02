package interview.palntir.telephone.one;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PalantirTelephoneOne {
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        PalantirTelephoneOne pt = new PalantirTelephoneOne();
        List<Integer[]> intList = pt.mergeIntervals(new ArrayList<Integer[]>(){
            {
                add(new Integer[] {2, 3});
                add(new Integer[] {1, 4});
                add(new Integer[] {5, 7});
            }
        });

        for(Integer[] value : intList) {
            System.out.println(value[0] + " " + value[1]);
        }

    }

    private List<Integer[]> mergeIntervals(ArrayList<Integer[]> unmergedList) {
        if(unmergedList == null || unmergedList.size() < 2) {
            return unmergedList;
        }

        Collections.sort(unmergedList, new Comparator<Integer[]>() {
            @Override
            public int compare(Integer[] o1, Integer[] o2) {
                return o1[0] - o2[0];
            }
        });

        ArrayList<Integer[]> mergedList = new ArrayList<>();
        Integer[] currentInterval = unmergedList.get(0);

        for(int i = 1; i < unmergedList.size(); i++) {
            if(currentInterval[1] >= unmergedList.get(i)[0]) {
                currentInterval[1] = Math.max(currentInterval[1], unmergedList.get(i)[1]);
            } else {
                mergedList.add(currentInterval);
                currentInterval = unmergedList.get(i);
            }
        }

        mergedList.add(currentInterval);
        return mergedList;

    }
}
