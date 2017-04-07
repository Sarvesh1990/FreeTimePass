package arrays.search.rotated.array;

/**
 * Created by apple on 06/03/17.
 */
public class Main {
    public static void main(String[] args) {
        int[] array = {5, 6, 7, 1, 3, 4, 5};
        System.out.println(search(array, 5, 0, array.length - 1));
    }

    private static int search(int[] array, int i, int low, int high) {
        System.out.println("Low " + low + ", high " + high);
        if(low > high) {
            return -1;
        }

        int mid = low + (high - low) / 2;
        if(array[mid] == i) {
            return mid;
        }

        if(array[low] >= array[mid] && array[high] >= array[mid]) {
            if(i <= array[high] && i > array[mid]) {
                return search(array, i, mid+1, high);
            } else {
                return search(array, i, low, mid - 1);
            }
        } else if (array[low] <= array[mid] && array[high] <= array[mid]) {
            if(i >= array[low] && i < array[mid]) {
                return search(array, i, low, mid - 1);
            } else {
                return search(array, i, mid+1, high);
            }
        } else {
            if(i >= array[low] && i < array[mid]) {
                return search(array, i, low, mid - 1);
            } else {
                return search(array, i, mid+1, high);
            }
        }
    }
}
