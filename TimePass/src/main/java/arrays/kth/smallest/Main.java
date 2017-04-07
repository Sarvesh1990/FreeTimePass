package arrays.kth.smallest;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Created by apple on 26/02/17.
 */
public class Main {
    public static void main(String[] args) {
        findKthSmallest(new int[] {2, 3, 4, 7, 1, 8, 5, 11}, 6);
//        findKthLargest()
    }

    private static void findKthSmallest(int[] arrayNum, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < arrayNum.length; i++) {
            if (i < k) {
                queue.add(arrayNum[i]);
            } else {
                if (queue.peek() > arrayNum[i]) {
                    queue.poll();
                    queue.add(arrayNum[i]);
                }
            }
        }
        System.out.println(queue.peek());
    }
}
