package arrays.intervals.merge.count;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by apple on 29/03/17.
 */

/*
ConnectedComponentsCount of minimum intervals required to include both start and end;
Keep two variable - maxEnd till now (it will serve as currentStart once this series interval is taken) and currentStart.
if element is greater than both currentStart and maxEnd, increase count and make currentStart maxEnd.
Also check if element[1] is greater than maxEnd. If yes update maxEnd;
Return as soon as maxEnd > targetEnd.
 */

public class MinimumIntervalCountToIncludeAllElementsBetween {
    public static void main(String[] args) {
        ArrayList<Integer[]> intervalList = new ArrayList<>();
        intervalList.add(new Integer[] {-1, 8});
        intervalList.add(new Integer[] {0, 3});
        intervalList.add(new Integer[] {1, 8});
        intervalList.add(new Integer[] {1, 5});
        intervalList.add(new Integer[] {3, 8});
        intervalList.add(new Integer[] {9, 10});
        intervalList.add(new Integer[] {10, 16});

        int targetStart = 2;
        int targetEnd = 16;

        System.out.println(countInterval(intervalList, targetStart, targetEnd));
    }

    private static Integer countInterval(ArrayList<Integer[]> intervalList, int targetStart, int targetEnd) {
        Collections.sort(intervalList, new Comparator<Integer[]>() {
            @Override
            public int compare(Integer[] o1, Integer[] o2) {
                return o1[0].compareTo(o2[0]);
            }
        });

        int maxEnd = targetStart;
        int currentStart = targetStart;
        int count = 1;

        for(int i = 0; i < intervalList.size(); i++) {
            if (intervalList.get(i)[0] > currentStart && intervalList.get(i)[0] > maxEnd) {
                return -1;
            } else {
                if(intervalList.get(i)[0] > currentStart) {
                    currentStart = maxEnd;
                    count++;
                }
                if(intervalList.get(i)[1] > maxEnd){
                    maxEnd = intervalList.get(i)[1];
                    if(maxEnd >= targetEnd) {
                        return count;
                    }
                }
            }
        }
        return -1;
    }
}
