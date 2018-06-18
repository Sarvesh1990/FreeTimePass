package arrays.intersection;

/**
 * Created by apple on 12/03/17.
 */
/*
Sort array
 */

public class FindUnionIntersectionTwoArrays {
    public static void main(String[] args) {
        int[] array1 = new int[] {1, 3, 4, 5, 7};
        int[] array2 = new int[] {0, 9};

        findIntersection(array1, array2);
    }

    private static void findIntersection(int[] array1, int[] array2) {
        int i = 0;
        int j = 0;

        while(i < array1.length && j < array2.length) {
            if(array1[i] == array2[j]) {
                System.out.println(array1[i]);
                i++;
                j++;
            } else if(array1[i] < array2[j]) {
                i++;
            } else {
                j++;
            }
         }
    }

    private static void findUnion(int[] array1, int[] array2) {
        int i = 0;
        int j = 0;

        while(i < array1.length || j < array2.length) {
            if(i < array1.length && j < array2.length) {
                if (array1[i] == array2[j]) {
                    System.out.println(array1[i]);
                    i++;
                    j++;
                } else if (array1[i] < array2[j]) {
                    System.out.println(array1[i]);
                    i++;
                } else {
                    System.out.println(array2[j]);
                    j++;
                }
            } else if (i < array1.length) {
                System.out.println(array1[i]);
                i++;
            } else {
                System.out.println(array2[j]);
                j++;
            }
        }
    }
}
