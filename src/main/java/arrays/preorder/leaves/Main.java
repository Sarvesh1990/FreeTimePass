package arrays.preorder.leaves;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by apple on 25/02/17.
 */
public class Main {
    public static void main(String[] args) {
        int[] preOrder = new int[] {5, 3, 2, 1, 4, 8, 7, 13, 12, 9, 11, 9};
        ArrayList<Integer> leaves = new ArrayList<Integer>();
        findLeaves(preOrder, 0, preOrder.length - 1, leaves);
    }

    //if size == 1 - then leaf
    //traverse full - if no element greater than root - last element is leaf
    //find greater element
    //traverse for root + 1 and greater - 1
    //traverse for greater end

    private static void findLeaves(int[] preOrder, int start, int end, ArrayList<Integer> leaves) {
        if(start > end) {
            return;
        }

        if(start == end) {
            leaves.add(preOrder[start]);
            return;
        }
        int root = preOrder[start];
        boolean greaterFound = false;
        int i;
        for(i = start + 1; i <= end; i++) {
            if(preOrder[i] > root) {
                greaterFound = true;
                break;
            }
        }
        if(greaterFound) {
            findLeaves(preOrder, start + 1, i - 1, leaves);
            findLeaves(preOrder, i, end, leaves);
        } else {
            leaves.add(preOrder[i - 1]);
        }
    }
}
