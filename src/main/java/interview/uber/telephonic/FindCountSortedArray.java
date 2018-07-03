package interview.uber.telephonic;

public class FindCountSortedArray {
    public static void main(String args[] ) throws Exception {
        FindCountSortedArray ff = new FindCountSortedArray();
        System.out.println(ff.findCountSortedArray(new int[] {1, 2, 2, 3}, 9));
    }
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */

    public int findCountSortedArray (int[] sortedArray, int number) {
        int leftIndex = findLeftIndexSortedArrayHelper(sortedArray, number, 0, sortedArray.length - 1);

        if(leftIndex == -1)
            return 0;

        int rightIndex = findRightIndexSortedArrayHelper(sortedArray, number, 0, sortedArray.length - 1);

        return rightIndex - leftIndex + 1;
    }


    public int findLeftIndexSortedArrayHelper(int[] sortedArray, int number, int low, int high) {
        if(low > high) {
            return -1;
        }

        int mid = low + (high - low)/2;

        if(sortedArray[mid] < number) {
            return findLeftIndexSortedArrayHelper(sortedArray, number, mid + 1, high);
        } else if (sortedArray[mid] > number) {
            return findLeftIndexSortedArrayHelper(sortedArray, number, low, mid - 1);
        } else {
            if(mid == 0) {
                return 0;
            } else {
                if(sortedArray[mid - 1] != number) {
                    return mid;
                } else {
                    return findLeftIndexSortedArrayHelper(sortedArray, number, low, mid - 1);
                }
            }
        }
    }

    public int findRightIndexSortedArrayHelper(int[] sortedArray, int number, int low, int high) {
        if(low > high) {
            return -1;
        }

        int mid = low + (high - low)/2;

        if(sortedArray[mid] < number) {
            return findRightIndexSortedArrayHelper(sortedArray, number, mid + 1, high);
        } else if (sortedArray[mid] > number) {
            return findRightIndexSortedArrayHelper(sortedArray, number, low, mid - 1);
        } else {
            if(mid == sortedArray.length - 1) {
                return sortedArray.length - 1;
            } else {
                if(sortedArray[mid + 1] != number) {
                    return mid;
                } else {
                    return findRightIndexSortedArrayHelper(sortedArray, number, mid + 1, high);
                }
            }
        }
    }
}
