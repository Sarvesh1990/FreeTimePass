package arrays.sort.quick;

/**
 * Created by apple on 27/02/17.
 */
public class Main {
    public static void main(String[] args) {
        int[] array = new int[] {10, 80, 30, 90, 40, 50, 70};
        System.out.println(quickSelect(array, 0, array.length - 1, 1));
        /*quickSort(array, 0, array.length - 1);
        for(int i = 0; i < array.length; i++) {
            System.out.println(array[i] + " ");
        }*/
    }

    private static void quickSort(int[] array, int low, int high) {
        if(low < high) {
            int i = low - 1;
            int pivot = array[high];

            for(int j = low; j <= high - 1; j++) {
                if(array[j] < pivot) {
                    i++;
                    swap(array, j, i);
                }
            }
            swap(array, i + 1, high);
            quickSort(array, low, i);
            quickSort(array, i + 2, high);
        }

    }

    private static int quickSelect(int[] array, int low, int high, int n) {
        if (low < high) {
            int i = low - 1;
            int pivot = array[high];

            for (int j = low; j <= high - 1; j++) {
                if (array[j] < pivot) {
                    i++;
                    swap(array, j, i);
                }
            }
            swap(array, i + 1, high);

            if(i + 2 == n) {
                return pivot;
            } else if (i + 2 < n) {
                return quickSelect(array, i + 2, high, n);
            } else {
                return quickSelect(array, low, i, n);
            }
        } else {
            return array[low];
        }
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }


}
