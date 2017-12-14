import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution2 {
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        Scanner in = new Scanner(System.in);
        int tripsCount = in.nextInt();
        int cabsCount = in.nextInt();

        int[] cabsTime = new int[cabsCount];

        for(int i = 0; i < cabsCount; i++) {
            cabsTime[i] = in.nextInt();
        }

        Arrays.sort(cabsTime);

        int maxTime = cabsTime[0];
        int doneTrips = 0;

        while(doneTrips < tripsCount) {
            for(int i = 0; i < cabsCount; i++) {
                if(cabsTime[i] <= maxTime) {
                    if(maxTime % cabsTime[i] == 0) {
                        doneTrips++;
                    }
                } else {
                    break;
                }
            }
            if(doneTrips < tripsCount) {
                maxTime++;
            }
        }

        System.out.println(maxTime);
    }
}