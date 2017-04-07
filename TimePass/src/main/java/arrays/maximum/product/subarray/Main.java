package arrays.maximum.product.subarray;

/**
 * Created by sarvesh on 12/3/17.
 */
public class Main {
    public static void main(String[] args) {
        int[] array = new int[] {-2, -3, 0, -2, -40};
        System.out.println(maxProdSub(array));
    }

    private static int maxProdSub(int[] array) {
        int maxProd = 0;
        int negativeProd = 0;
        int currProd = 0;

        for(int i = 0; i < array.length; i++) {
            if(currProd == 0) {
                currProd = array[i];
            } else {
                currProd = currProd * array[i];
            }
            if(currProd == 0) {
                negativeProd = 0;
            }
            if(currProd >= maxProd) {
                maxProd = currProd;
            } else {
                if(negativeProd != 0) {
                    if(currProd / negativeProd > maxProd) {
                        maxProd = currProd / negativeProd;
                    }
                } else {
                    negativeProd = currProd;
                }
            }
        }
        return maxProd;
    }
}
