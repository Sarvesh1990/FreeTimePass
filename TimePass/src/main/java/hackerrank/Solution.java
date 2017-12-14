package hackerrank;

import java.util.*;

/**
 * Created by apple on 16/10/17.
 */
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int uberCount = in.nextInt();
        int[] uberX = new int[uberCount];

        Map<Integer, Integer> uberCord = new HashMap<>();

        for (int i = 0; i < uberCount; i++) {
            uberX[i] = in.nextInt();
            int uberY = in.nextInt();
            if(uberCord.containsKey(uberX[i])) {
                if(uberY > uberCord.get(uberX[i])) {
                    uberCord.put(uberX[i], uberY);
                }
            } else {
                uberCord.put(uberX[i], uberY);
            }
        }

        Arrays.sort(uberX);

        int markersCount = 0;

        markersCount = uberCord.get(uberX[0]) - uberX[0] + 1;
        int currentMax = uberCord.get(uberX[0]);

        for(int i = 1; i < uberX.length; i++) {
            if(uberX[i] > currentMax) {
                markersCount = markersCount + uberCord.get(uberX[i]) - uberX[i] + 1;
                currentMax = uberCord.get(uberX[i]);
            } else {
                if(uberCord.get(uberX[i]) > currentMax) {
                    markersCount = markersCount + uberCord.get(uberX[i]) - currentMax ;
                    currentMax = uberCord.get(uberX[i]);
                }
            }
        }

        System.out.println(markersCount);
    }
}
