package arrays.contiguous.sum.n;

/**
 * Created by apple on 19/02/17.
 */
public class Main {
    public static void main(String[] args) {
        int[] array = {1, 2, 4, 2, 5, 2, 3};
        printIndex(array, 5);
    }

    public static void printIndex(int[] array, int sum) {
        int currentSum = 0;
        int movingIndex = 0;

        for(int i = 0; i < array.length; i++) {
            currentSum = currentSum + array[i];
            if(currentSum >= sum) {
                if(currentSum == sum) {
                    System.out.println("Index is : " + movingIndex + " to " + i);
                    return;
                } else {
                    for(int j = movingIndex + 1; j <= i + 1; j++) {
                        currentSum = currentSum - array[j-1];
                        if(currentSum == sum) {
                            System.out.println("Index is : " + j + " to " + i);
                            return;
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
        System.out.println("No index found");
    }
}
