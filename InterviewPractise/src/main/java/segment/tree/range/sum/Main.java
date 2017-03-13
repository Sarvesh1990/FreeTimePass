package segment.tree.range.sum;

import java.util.ArrayList;

import static java.lang.Math.log;
import static java.lang.Math.pow;

/**
 * Created by apple on 08/03/17.
 */
public class Main {
    public static void main(String[] args) {
        int[] array = new int[] {1, 3, 5, 7, 9, 11};
        int STSize = getSizeST(array.length);
        int[] segmentTree = new int[STSize];
        createSegmentTree(array, segmentTree, 0, array.length - 1, 0);
        System.out.println(findSum(segmentTree, 0, 5, 3, 4, 0));
        updateValue(segmentTree, 0, 5,4, 11, 0);
        updateValue(segmentTree, 0, 5,3, 5, 0);
        updateValue(segmentTree, 0, 5,2, 3, 0);
        System.out.println(findSum(segmentTree, 0, 5, 2, 4, 0));
    }

    private static int getSizeST(int length) {
        int count = (int) Math.ceil(Math.log(length) / Math.log(2));

        return (int) (2 * Math.pow(2, count) - 1);
    }

    private static Integer createSegmentTree(int[] array, int[] segmentTree, int l, int r, int position) {
        if(l == r) {
            segmentTree[position] = array[l];
            return array[l];
        }
        int mid = l + (r - l)/2;
        int left = createSegmentTree(array, segmentTree, l, mid, 2*position + 1);
        int right = createSegmentTree(array, segmentTree, mid + 1, r, 2*position + 2);
        segmentTree[position] =  left + right;
        return (left + right);
    }

    private static Integer findSum (int[] segmentTree, int low, int high, int start, int end, int position) {
        if((start < low && end < low) || (start > high && end > high)) {
            return 0;
        }
        if(low >= start && high <= end) {
            return segmentTree[position];
        }

        int mid = low + (high - low)/2;
        int sum1 = findSum(segmentTree, low, mid, start, end, 2 * position + 1);
        int sum2 = findSum(segmentTree, mid + 1, high, start, end, 2 * position + 2);

        return sum1 + sum2;
    }

    private static void updateValue(int[] segmentTree, int low, int high, int index, int value, int position) {
        if(low == high) {
            int temp = segmentTree[position];
            segmentTree[position] = value;
            int diff = value - temp;
            while((position - 1)/2 >= 0 && position != 0) {
                segmentTree[(position - 1)/2] = segmentTree[(position - 1)/2] + diff;
                position = (position - 1)/2;
            }
            return;
        }

        int mid = low + (high - low)/2;
        if(index <= mid) {
            updateValue(segmentTree, low, mid, index, value, 2 * position + 1);
        } else {
            updateValue(segmentTree, mid + 1, high, index, value, 2 * position + 2);
        }
    }
}
