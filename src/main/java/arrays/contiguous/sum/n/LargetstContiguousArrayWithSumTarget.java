package arrays.contiguous.sum.n;

/**
 * Created by apple on 19/02/17.
 */

/*
Keep increasing i. If sum == target, check for maxSize. Increase movingIndex by 1 and decrease sum by array[movingIndex].
If Sum > target, move j. if sum == target, check maxSize, break. If < target, break. Set movingIndex = j
 */
public class LargetstContiguousArrayWithSumTarget {
    public static void main(String[] args) {
        int[] array = {1, 2, 4, 3, 2, 1, 1, 2, 6};
        System.out.println(printIndex(array, 6));
    }

    public static Integer printIndex(int[] array, int sum) {
        int currentSum = 0;
        int movingIndex = 0;

        int maxSize = 0;

        for(int i = 0; i < array.length; i++) {
            currentSum = currentSum + array[i];
            if(currentSum >= sum) {
                if(currentSum == sum) {
                    if(maxSize < i - movingIndex) {
                        maxSize = i - movingIndex;
                    }
                    currentSum = currentSum - array[movingIndex];
                    movingIndex++;
                } else {
                    for(int j = movingIndex + 1; j <= i + 1; j++) {
                        currentSum = currentSum - array[j-1];
                        if(currentSum == sum) {
                            if(maxSize < i - j) {
                                maxSize = i - j;
                            }
                            movingIndex = j;
                            break;
                        } else if (currentSum < sum) {
                            movingIndex = j;
                            break;
                        } else {
                            movingIndex = j;
                        }
                    }
                }
            }
        }
        return maxSize + 1;
    }
}
