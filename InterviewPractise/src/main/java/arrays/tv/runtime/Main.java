package arrays.tv.runtime;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 * Created by apple on 25/02/17.
 */
public class Main {
    public static void main(String[] args) {
        ArrayList<TV> timeList = new ArrayList<>();
        timeList.add(new TV(1, 2));
        timeList.add(new TV(4, 7));
        timeList.add(new TV(2, 3));

        Collections.sort(timeList);

        int sum = 0;
        int currEnd = 0;
        for(int i = 0; i < timeList.size(); i++) {
            if(i == 0) {
                sum = sum + timeList.get(i).getEnd() - timeList.get(i).getStart();
                currEnd = timeList.get(i).getEnd();
            } else {
                if (timeList.get(i).getStart() > currEnd) {
                    sum = sum + timeList.get(i).getEnd() - timeList.get(i).getStart();
                    currEnd = timeList.get(i).getEnd();
                } else {
                    if(timeList.get(i).getEnd() > currEnd) {
                        sum = sum + timeList.get(i).getEnd() - currEnd;
                        currEnd = timeList.get(i).getEnd();
                    }
                }
            }
        }

        System.out.println(sum);

    }
}
