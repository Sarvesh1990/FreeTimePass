package interview.apple;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Created by apple on 08/06/18.
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(findScore(new int[]{6, 18, 8, 14, 10, 12, 18, 9}, 8, 3));
    }

    static Long findScore(int[] currentEmployeeScore, int teamSize, int segmentSize) {
        PriorityQueue<Integer> leftQueue = new PriorityQueue(segmentSize, Collections.reverseOrder());
        PriorityQueue<Integer> rightQueue = new PriorityQueue(segmentSize, Collections.reverseOrder());

        Long newTeamScore = 0l;

        int currentEmployeeSize = currentEmployeeScore.length;

        if(currentEmployeeSize > segmentSize) {
            for(int i = 0; i < segmentSize; i++) {
                leftQueue.add(currentEmployeeScore[i]);
                rightQueue.add(currentEmployeeScore[currentEmployeeSize - i - 1]);
            }
        }

        int leftIndex = segmentSize;
        int rightIndex = currentEmployeeSize - segmentSize - 1;

        for(int i = 0; i < teamSize; i++) {
            if(currentEmployeeSize > segmentSize) {
                int max;
                if(leftQueue.peek() >= rightQueue.peek()) {
                    max = leftQueue.poll();
                    leftQueue.add(currentEmployeeScore[leftIndex]);
                    leftIndex++;
                } else {
                   max = rightQueue.poll();
                    rightQueue.add(currentEmployeeScore[rightIndex]);
                    rightIndex--;
                }
                newTeamScore = newTeamScore + max;
                currentEmployeeSize--;
            } else {
                newTeamScore = newTeamScore + leftQueue.poll();
            }
        }

        return newTeamScore;
    }
}
