package arrays.move.zeroes.to.end;

/**
 * Created by apple on 02/03/17.
 */
public class Main {
    public static void main(String[] args) {
        int[] array = new int[] {1, 2, 3, 8, 0, 2, 2, 0, 10};
        moveZeroesToEnd(array);

        for(int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

    private static void moveZeroesToEnd(int[] array) {
        int i = -1;
        for(int j = 0; j < array.length; j++) {
            if(array[j] == 0) {
                if(i == -1) {
                    i = j;
                }
            } else {
                if(i != -1) {
                    swap(array, i, j);
                    i++;
                }
            }
        }
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
