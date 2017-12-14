package hackerrank;

import java.util.*;
import java.util.jar.Pack200;

/**
 * Created by apple on 12/12/17.
 */
public class Solution1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int tripsCount = in.nextInt();
        int cabsCount = in.nextInt();

        int[] cabsTime = new int[cabsCount];
        int maxCabTime = Integer.MIN_VALUE;

        for(int i = 0; i < cabsCount; i++) {
            cabsTime[i] = in.nextInt();
            if(maxCabTime < cabsTime[i]) {
                maxCabTime = cabsTime[i];
            }
        }

        int maxTime = maxCabTime * tripsCount;
        Map<Integer, Integer> tripsPerTime = new HashMap<>();

        for(int i = 0; i < cabsCount; i++) {
            int cabTime = cabsTime[i];
            int j = 1;
            while(cabTime*j <= maxTime) {
                if(tripsPerTime.containsKey(cabTime*j)) {
                    tripsPerTime.put(cabTime * j, tripsPerTime.get(cabTime*j) + j);
                } else {
                    tripsPerTime.put(cabTime * j, j);
                }
                j++;
            }
        }

        for(Integer time : tripsPerTime.keySet()) {
            System.out.println(time + " " + tripsPerTime.get(time));
            if(tripsPerTime.get(time) == tripsCount) {
                System.out.println(tripsPerTime.get(time));
                if(time < maxTime) {
                    maxTime = time;
                }
            }
        }

        System.out.println(maxTime);

    }
}
