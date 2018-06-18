package arrays.combination.difference.k;

/**
 * Created by sarvesh on 7/3/17.
 */
public class PrintNumbersWhichDiffByK {
    public static void main(String[] args) {
        int[] array = new int[] {1, 2, 4, 4, 6, 8, 10, 12, 13};
        printCombination(array, 2);
    }

    private static void printCombination(int[] array, int k) {
        int j = 0;
        for(int i = 0; i < array.length; i++) {
            if(array[i] - array[j] < k);
            else if (array[i] - array[j] == k) {
                System.out.println(array[i] + " " + array[j]);
            } else {
                while(array[i] - array[j] > k) {
                    j++;
                }
                if(array[i] - array[j] == k) {
                    System.out.println(array[i] + " " + array[j]);
                }
            }
        }
    }
}
