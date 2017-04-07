package heap;

import static java.lang.Math.max;

/**
 * Created by apple on 26/02/17.
 */
public class Heap {
    private static int[] heapArray;
    private static int elementsInHeap = 0;

    public Heap(int size) {
        this.heapArray = new int[size];
    }

    public Heap(int[] array) {
        this.heapArray = array;
        elementsInHeap = array.length;
    }

    public static void buildValidHeap() {
        if(elementsInHeap <= 1) {
            return;
        }

        for(int i = (elementsInHeap - 2/2); i >= 0; i--) {
            shiftDown(i);
        }
    }

    public static void add(int number) {
        if(heapArray.length == 0) {
            System.out.println("Can't insert in empty heap");
            return;
        }

        if(elementsInHeap == heapArray.length) {
            System.out.println("Heap is full, can't insert");
            return;
        }

        heapArray[elementsInHeap] = number;
        shiftUp(elementsInHeap);
        elementsInHeap ++;
    }

    public static void shiftUp(int element) {
        if(element < 0) {
            System.out.println("Can't shiftUp since no elements in heap");
            return;
        }
        if(element == 0) {
            return;
        }
        while(heapArray[(element - 1)/2] > heapArray[element]) {
            swap((element - 1)/2, element);
            element = (element - 1)/2;
        }
    }

    public static void swap(int num1, int num2) {
        int temp = heapArray[num1];
        heapArray[num1] = heapArray[num2];
        heapArray[num2] = temp;
    }

    public static int peek() {
        return heapArray[0];
    }

    public static int poll() {
        int elementToReturn = heapArray[0];
        heapArray[0] = heapArray[elementsInHeap - 1];
        elementsInHeap--;
        shiftDown(0);
        return elementToReturn;
    }

    public static void shiftDown(int element) {
        int currentElement = element;
        while(elementsInHeap > 2 * currentElement + 1) {
            if(elementsInHeap > 2*currentElement + 2) {
                if((heapArray[currentElement] > heapArray[2 * currentElement + 1]
                        || heapArray[currentElement] > heapArray[2*currentElement + 2])) {
                    if (heapArray[2 * currentElement + 1] <= heapArray[2 * currentElement + 2]) {
                        swap(2* currentElement + 1, currentElement);
                        currentElement = 2 * currentElement + 1;
                    } else {
                        swap(2* currentElement + 2, currentElement);
                        currentElement = 2 * currentElement + 2;
                    }
                } else {
                    break;
                }
            } else {
                if(heapArray[currentElement] > heapArray[2 * currentElement + 1]) {
                    swap(2 * currentElement + 1, currentElement);
                    currentElement = 2 * currentElement + 1;
                } else {
                    break;
                }
            }
        }
    }

    public boolean isEmpty() {
        return elementsInHeap == 0;
    }
}

