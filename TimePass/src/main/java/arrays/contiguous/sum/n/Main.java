package arrays.contiguous.sum.n;

/**
 * Created by apple on 19/02/17.
 */
public class Main {
    public static void main(String[] args) {
        int[] array = {1, 2, 4, 2, 3, 1, 6};
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
                    currentSum = 0;
                    movingIndex = i + 1;
                } else {
                    for(int j = movingIndex + 1; j <= i + 1; j++) {
                        currentSum = currentSum - array[j-1];
                        if(currentSum == sum) {
                            if(maxSize < i - j) {
                                maxSize = i - j;
                            }
                            currentSum = 0;
                            movingIndex = i + 1;
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
