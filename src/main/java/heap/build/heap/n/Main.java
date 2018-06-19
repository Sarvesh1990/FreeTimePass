package heap.build.heap.n;

import heap.Heap;

/**
 * Created by apple on 27/02/17.
 */
public class Main {
    public static void main(String[] args) {
        int[] array = new int[] {5, 2, 3, 1};
        Heap heap = new Heap(array);

        heap.buildValidHeap();

        while (!heap.isEmpty()) {
            System.out.println(heap.poll() + " ");
        }
    }
}
