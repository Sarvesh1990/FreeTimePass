package arrays.rearrange.positive.negative;

/**
 * Created by apple on 25/02/17.
 */
public class Main {
    public static void main(String[] args) {
        int[] numArray = new int[] {12, 11, -13, -5, 6, -7, 5, -3, -6};

        reArrange(numArray, 0, numArray.length - 1);

        for(int i = 0; i < numArray.length; i++) {
            System.out.println(numArray[i] + ", ");
        }

    }

    private static void reArrange(int[] numArray, int low, int high) {
        if(low == high){
            return;
        }
        if(low == high - 1) {
            swap(numArray, low, high);
            return;
        }
        int mid = low + (high - low)/2;
        reArrange(numArray, low, mid);
        reArrange(numArray, mid + 1, high);

        swap(numArray, low, high);
    }

    private static void swap(int[] numArray, int low, int high) {
        if(low == high - 1) {
            if(low > 0 && high < 0) {
                int temp = numArray[low];
                numArray[low] = numArray[high];
                numArray[high] = temp;
            }
            return;
        }

        int mid = low + (high - low)/2;

        int firstArrayPositiveStart = -1;
        int secondArrayPositiveStart = high + 1;


        if(numArray[mid] < 0 || numArray[mid + 1] > 0) {
            return;
        }

        for(int i = low; i <= mid; i++) {
            if(numArray[i] > 0) {
                firstArrayPositiveStart = i;
                break;
            }
        }

        for(int j = mid + 1; j <= high; j++) {
            if(numArray[j] > 0) {
                secondArrayPositiveStart = j;
                break;
            }
        }

        reverse(numArray, firstArrayPositiveStart, mid);
        reverse(numArray, mid + 1, secondArrayPositiveStart - 1);
        reverse(numArray, firstArrayPositiveStart, secondArrayPositiveStart - 1);

        return;
    }

    private static void reverse(int[] numArray, int start, int end) {
        while(start != end && start != end - 1) {
            int temp = numArray[start];
            numArray[start] = numArray[end];
            numArray[end] = temp;
            start++;
            end--;
        }

        if(start == end) {
            return;
        }

        if(start == end -1) {
            int temp = numArray[start];
            numArray[start] = numArray[end];
            numArray[end] = temp;
            return;
        }
    }
}
