package arrays.median.sorted.samesize;

/**
 * Created by apple on 27/02/17.
 */
public class Main {
    public static void main(String[] args) {
        int[] array1 = new int[] {1, 12, 15, 26, 38};
        int[] array2 = new int[] {2, 13, 17, 30, 45};

        System.out.println(findMedianSorted(array1, array2, 0, array1.length - 1, 0, array2.length - 1));
    }

    private static double findMedianSorted(int[] array1, int[] array2, int array1Start, int array1End, int array2Start, int array2End) {
        if(array1Start == array1End) {
            return ((array1[array1Start] + array2[array2Start])/2.0);
        }

        int array1Mid = array1Start + (array1End - array1Start)/2;
        int array2Mid = array2Start + (array2End - array2Start)/2;

        if((array1End - array1Start+ 1) % 2 == 0) {
            double medianArray1 = (array1[array1Mid] + array1[array1Mid + 1])/2.0;
            double medianArray2 = (array2[array2Mid] + array2[array2Mid + 1])/2.0;

            if(medianArray1 > medianArray2) {
                return findMedianSorted(array1, array2, array1Start, array1Mid, array2Mid + 1, array2End);
            } else if(medianArray1 < medianArray2){
                return findMedianSorted(array1, array2, array1Mid + 1, array1End, array2Start, array2Mid);
            } else {
                return medianArray1;
            }
        } else {
            int medianArray1 = array1[array1Mid];
            int medianArray2 = array2[array2Mid];

            if(medianArray1 > medianArray2) {
                return findMedianSorted(array1, array2, array1Start, array1Mid, array2Mid, array2End);
            } else if(medianArray1 < medianArray2){
                return findMedianSorted(array1, array2, array1Mid, array1End, array2Start, array2Mid);
            } else {
                return medianArray1;
            }
        }
    }
}
