package arrays.insert.interval;


import java.util.LinkedList;
import java.util.List;

public class InsertInterval {
    public static class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }

    public static void main(String[] args) {
        InsertInterval solution = new InsertInterval();
        List<Interval> list = new LinkedList<Interval>() {
            {
                add(new Interval(1, 5));
                add(new Interval(6, 8));
            }
        };

        for(Interval interval : solution.insert(list, new Interval(5, 6))) {
            System.out.println(interval.start + " " + interval.end);
        }
    }

    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        int smallerIntervalIndex = findIndex(intervals, newInterval.start, 0, intervals.size() - 1);
        System.out.println(smallerIntervalIndex);
        if (smallerIntervalIndex == -1) {
            intervals.add(newInterval);
        } else {
            Interval smallerInterval = intervals.get(smallerIntervalIndex);

            if(smallerInterval.start > newInterval.end) {
                intervals.add(smallerIntervalIndex, newInterval);
                return intervals;
            }

            if(smallerInterval.start >= newInterval.start) {
                smallerInterval.start = newInterval.start;
            }

            if(smallerInterval.end >= newInterval.end) {
                return intervals;
            }

            int currentEnd = newInterval.end;

            for (int i = smallerIntervalIndex + 1; i < intervals.size(); i++) {
                Interval interval = intervals.get(i);
                if (interval.start <= currentEnd) {
                    currentEnd = (currentEnd > interval.end) ? currentEnd : interval.end;
                    intervals.remove(i);
                    i--;
                } else {
                    break;
                }
            }
            smallerInterval.end = currentEnd;
        }
        return intervals;
    }

    public int findIndex (List < Interval > intervals,int startNew, int low, int high){
        if (low > high) {
            return -1;
        }

        int mid = low + (high - low) / 2;
        Interval value = intervals.get(mid);

        if (value.end < startNew) {
            return findIndex(intervals, startNew, mid + 1, high);
        } else {
            if (mid == 0) {
                return mid;
            } else {
                if (intervals.get(mid - 1).end >= startNew) {
                    return findIndex(intervals, startNew, low, mid - 1);
                } else {
                    return mid;
                }
            }
        }
    }
}
