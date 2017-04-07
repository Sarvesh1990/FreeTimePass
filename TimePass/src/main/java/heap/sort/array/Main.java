package heap.sort.array;

import heap.Heap;

/**
 * Created by apple on 27/02/17.
 */
public class Main {
    public static void main(String[] args) {
        int[] array = new int[] {2, 5, 1, 3, 4, 8, 3};
        Heap heap = new Heap(array.length);

        for(int i = 0; i < array.length; i++) {
            heap.add(array[i]);
        }

        while (!heap.isEmpty()) {
            System.out.println(heap.poll() + " ");
        }
    }
}
