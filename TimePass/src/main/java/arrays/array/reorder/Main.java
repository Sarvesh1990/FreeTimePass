package arrays.array.reorder;

/**
 * Created by apple on 15/05/17.
 */
public class Main {
    public static void main(String[] args) {
        String[] array1 = new String[5];
        array1[0] = "B";
        array1[1] = "C";
        array1[2] = "E";
        array1[3] = "A";
        array1[4] = "D";

        int[] array2 = new int[] {3, 4, 4, 1};

//        reorderArray(array1, array2);

        System.out.println(isMonotonic(array2));

    }

    public static void reorderArray(Object[] array1, int[] index) {
        int length = array1.length;
        for(int i = 0; i < length; i++) {
            while(index[i] != i) {
                Object old = array1[index[i]];
                int oldInt = index[index[i]];

                array1[index[i]] = array1[i];
                index[index[i]] = index[i];

                index[i] = oldInt;
                array1[i] = old;
            }

        }

        for(int i = 0; i < array1.length; i++) {
            System.out.println(array1[i]);
        }
    }

    public static boolean isMonotonic (int[] array) {
        int monotonicPattern = 0;

        if(array.length <= 1) {
            return true;
        }

        for(int i = 1; i < array.length; i++) {
            if(array[i] != array[i - 1]) {
                if(monotonicPattern == 0) {
                    if(array[i] > array[i - 1]) {
                        monotonicPattern = 1;
                    } else {
                        monotonicPattern = 2;
                    }
                } else {
                    if(monotonicPattern == 1) {
                        if(array[i] < array[i - 1]) {
                            return false;
                        }
                    } else {
                        if(array[i] > array[i - 1]) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;

    }
}
