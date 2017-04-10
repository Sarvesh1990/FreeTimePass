package arrays.skyline;


import java.util.*;

/**
 * Created by apple on 10/04/17.
 */
public class Main {
    public static void main(String[] args) {
        int[][] buildings = new int[2][3];
        buildings[0][0] = 2;
        buildings[0][1] = 4;
        buildings[0][2] = 7;
        buildings[1][0] = 2;
        buildings[1][1] = 4;
        buildings[1][2] = 5;
        /*buildings[2][0] = 5;
        buildings[2][1] = 12;
        buildings[2][2] = 12;
        buildings[3][0] = 15;
        buildings[3][1] = 20;
        buildings[3][2] = 10;
        buildings[4][0] = 19;
        buildings[4][1] = 24;
        buildings[4][2] = 8;
*/

        List<int[]> list = minMeetingRooms(buildings);

        for(int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i)[0] + " " + list.get(i)[1]);
        }
    }

    public static List<int[]> minMeetingRooms(int[][] buildings) {
        if(buildings == null || buildings.length == 0)
            return null;

        Interval[] intervals = new Interval[buildings.length];
        for(int i = 0; i < buildings.length; i++) {
            intervals[i] = new Interval(buildings[i][0], buildings[i][1], buildings[i][2]);
        }

        IntervalBreak[] intervalBreaks = new IntervalBreak[intervals.length * 2];

        for(int i = 0; i < intervals.length*2; i = i + 2) {
            intervalBreaks[i] = new IntervalBreak(intervals[i/2].start, intervals[i/2].height, true);
            intervalBreaks[i + 1] = new IntervalBreak(intervals[i/2].end, intervals[i/2].height, false);
        }

        Arrays.sort(intervalBreaks, new Comparator<IntervalBreak>(){
            public int compare(IntervalBreak ia, IntervalBreak ib){
                if(ia.value == ib.value) {
                    if((ia.isStart && ib.isStart))
                        return ib.height - ia.height;
                    else if ((!ia.isStart && !ib.isStart))
                        return ia.height - ib.height;
                    else {
                        if(ia.isStart) {
                            return -1;
                        } else {
                            return 1;
                        }
                    }
                }
                return ia.value - ib.value;
            }
        });

        PriorityQueue<Integer> heightQueue = new PriorityQueue<>(Collections.reverseOrder());
        heightQueue.add(intervalBreaks[0].height);

        List<int[]> list = new LinkedList<>();
        int currentValue = 0;

        for(int i = 1; i < intervals.length * 2; i++) {
            int height = (heightQueue.peek() != null ? heightQueue.peek() : 0);
            if(height != currentValue) {
                list.add(new int[] {intervalBreaks[i - 1].value, height});
                currentValue = height;
            }
            if(intervalBreaks[i].isStart) {
                heightQueue.add(intervalBreaks[i].height);
            } else {
                heightQueue.remove(intervalBreaks[i].height);
            }
        }
        list.add(new int[] {intervalBreaks[intervals.length * 2 - 1].value, 0});

        return list;

    }
}
