package bst.non.matching.leaf;

import bst.BST;

import java.util.ArrayList;

/**
 * Created by apple on 27/02/17.
 */
public class Main {
    public static void main(String[] args) {
        int[] preOrder1 = new int[] {5, 4, 9};
        int[] preOrder2 = new int[] {8, 7, 3, 2, 4, 9};

        findNonMatchingLeaves(preOrder1, preOrder2);
    }

    private static void findNonMatchingLeaves(int[] preOrder1, int[] preOrder2) {
        ArrayList<Integer> leaves1 = new ArrayList<Integer>();
        ArrayList<Integer> leaves2 = new ArrayList<Integer>();
        findLeaves(preOrder1, 0, preOrder1.length - 1, leaves1);
        findLeaves(preOrder2, 0, preOrder2.length - 1, leaves2);

        int length1 = leaves1.size();
        int length2 = leaves2.size();

        if(length1 < length2) {
            int i;
            for (i = 0; i < length1; i++ ) {
                if(leaves1.get(i) != leaves2.get(i)) {
                    System.out.println(leaves1.get(i) + " " + leaves2.get(i));
                    return;
                }
            }
            System.out.println(" " + ", " + leaves2.get(i));
        } else if (length1 > length2){
            int i;
            for (i = 0; i < length2; i++ ) {
                if(leaves1.get(i) != leaves2.get(i)) {
                    System.out.println(leaves1.get(i) + ", " + leaves2.get(i));
                    return;
                }
            }
            System.out.println(leaves1.get(i) + ", " + " ");
        } else {
            int i;
            for (i = 0; i < length2; i++ ) {
                if(leaves1.get(i) != leaves2.get(i)) {
                    System.out.println(leaves1.get(i) + ", " + leaves2.get(i));
                    return;
                }
            }
        }
    }

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
