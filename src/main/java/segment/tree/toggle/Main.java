package segment.tree.toggle;

import java.util.Arrays;

/**
 * Created by apple on 08/03/17.
 */
public class Main {
    public static void main(String[] args) {
        int n = 5;

        int STSize = getSizeST(n);
        int[] segmentTree = new int[STSize];
        for(int i = 0; i < segmentTree.length; i++) {
            segmentTree[i] = 0;
        }

        System.out.println(Arrays.toString(segmentTree));
        updateValue(segmentTree, 0, n - 1,1, 2, 0);
        System.out.println(Arrays.toString(segmentTree));
        updateValue(segmentTree, 0, n - 1,2, 4, 0);
        System.out.println(Arrays.toString(segmentTree));
        System.out.println(countInRange(segmentTree, 0, n - 1, 2, 3, 0));
        updateValue(segmentTree, 0, n - 1,2, 4, 0);
        updateValue(segmentTree, 0, n - 1,3, 4, 0);
        System.out.println(countInRange(segmentTree, 0, n - 1, 1, 5, 0));
        System.out.println(Arrays.toString(segmentTree));
        updateValue(segmentTree, 0, n - 1,0, 4, 0);
        System.out.println(countInRange(segmentTree, 0, n - 1, 0, 4, 0));


    }

    private static int getSizeST(int length) {
        int count = (int) Math.ceil(Math.log(length) / Math.log(2));

        return (int) (2 * Math.pow(2, count) - 1);
    }

    private static Integer countInRange (int[] segmentTree, int low, int high, int start, int end, int position) {
        if((start < low && end < low) || (start > high && end > high)) {
            return 0;
        }

        if(low >= start && high <= end) {
            return segmentTree[position];
        }

        int mid = low + (high - low)/2;
        int sum1 = countInRange(segmentTree, low, mid, start, end, 2 * position + 1);
        int sum2 = countInRange(segmentTree, mid + 1, high, start, end, 2 * position + 2);

        return sum1 + sum2;
    }

    private static void updateValue(int[] segmentTree, int low, int high, int start, int end, int position) {
        if((start < low && end < low) || (start > high && end > high)) {
            return;
        }

        if(low == high) {
            if(segmentTree[position] == 0) {
                segmentTree[position] = 1;
            } else {
                segmentTree[position] = 0;
            }
            return;
        }

        int mid = low + (high - low)/2;
        updateValue(segmentTree, low, mid, start, end, 2 * position + 1);
        updateValue(segmentTree, mid + 1, high, start, end, 2 * position + 2);

        segmentTree[position] = segmentTree[2*position + 1] + segmentTree[2*position + 2];
    }
}
