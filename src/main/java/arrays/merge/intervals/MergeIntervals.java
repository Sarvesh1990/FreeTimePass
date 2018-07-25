package arrays.merge.intervals;

import concepts.Interface1;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class MergeIntervals {
    public static void main(String[] args) {
        MergeIntervals mergeIntervals = new MergeIntervals();
        List<Interval> list = mergeIntervals.merge(new LinkedList<Interval>() {
            {
                add(new Interval(1, 4));
                add(new Interval(3, 7));
                add(new Interval(4, 5));
                add(new Interval(2, 10));
                add(new Interval(15, 20));
            }
        });

        for(Interval interval : list) {
            System.out.println(interval.start + " " + interval.end);
        }
    }

    public List<Interval> merge(List<Interval> intervals) {
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });

        if(intervals.size() == 0) {
            return new LinkedList<>();
        }

        List<Interval> mergedList = new LinkedList<>();

        Interval currentInterval = intervals.get(0);

        for(Interval interval : intervals) {
            if(currentInterval.end >= interval.start) {
                currentInterval.end = (currentInterval.end > interval.end ? currentInterval.end : interval.end);
            } else {
                mergedList.add(currentInterval);
                currentInterval = interval;
            }
        }
        mergedList.add(currentInterval);

        return mergedList;
    }
}
