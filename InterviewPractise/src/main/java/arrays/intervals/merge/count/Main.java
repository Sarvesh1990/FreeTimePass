package arrays.intervals.merge.count;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by apple on 29/03/17.
 */
public class Main {
    public static void main(String[] args) {
        ArrayList<Integer[]> intervalList = new ArrayList<>();
        intervalList.add(new Integer[] {-1, 9});
        intervalList.add(new Integer[] {1, 10});
        intervalList.add(new Integer[] {0, 3});
        intervalList.add(new Integer[] {9, 10});
        intervalList.add(new Integer[] {3, 14});
        intervalList.add(new Integer[] {2, 9});
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

        int currentEnd = 0;
        int count = 0;

        for(int i = 0; i < intervalList.size(); i++) {
            if (intervalList.get(i)[0] <= targetStart) {
                if (currentEnd < intervalList.get(i)[1]) {
                    currentEnd = intervalList.get(i)[1];
                }
                if (i == intervalList.size() - 1) {
                    if (currentEnd < targetEnd) {
                        return -1;
                    } else {
                        count++;
                        return count;
                    }
                }
            } else {
                if (i == intervalList.size() - 1) {
                    System.out.println(i + " " + currentEnd);
                    if (currentEnd < targetEnd) {
                        return -1;
                    } else {
                        count++;
                        return count;
                    }
                } else {
                    System.out.println(i + " " + currentEnd);
                    count++;
                    i--;
                    targetStart = currentEnd;
                }
            }
        }
        return count;
    }
}
