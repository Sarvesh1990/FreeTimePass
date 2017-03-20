package arrays.maximum.k.elements;

import java.util.LinkedList;

/**
 * Created by sarvesh on 20/3/17.
 */
public class Main {
    public static void main(String[] args) {
        int[] array = new int[] {8, 5, 10, 7, 9, 4, 15, 12, 90, 13};
        printMax(array, 3);
    }

    private static void printMax(int[] array, int k ){
        if(k == 0) {
            return;
        }
        LinkedList<Integer> maxList = new LinkedList<Integer>();
        for(int i = 0; i < array.length; i++) {
            if(maxList.size() >= k) {
                maxList.removeFirst();
            }

            if(maxList.isEmpty()) {
                maxList.addFirst(array[i]);
            } else {
                if(array[i] >= maxList.peekFirst()) {
                    maxList.clear();
                    maxList.addFirst(array[i]);
                } else if(array[i] >= maxList.peekLast()) {
                    while(maxList.peekLast() <= array[i]) {
                        maxList.removeLast();
                    }
                    maxList.addLast(array[i]);
                } else {
                    maxList.addLast(array[i]);
                }
            }

            if(i >= k -1) {
                System.out.println(maxList.peekFirst());
            }
        }
    }
}
