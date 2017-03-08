package arrays.squares;

import static java.lang.StrictMath.abs;
import static java.lang.StrictMath.pow;

/**
 * Created by apple on 25/02/17.
 */
public class Main {
    public static void main(String[] args) {
        findSquares(new int[] {-7, -5, -4, -3, -1, 2});
    }

    private static void findSquares(int[] arrayNum) {
        int[] squareArray = new int[arrayNum.length];

        int currPositive = -1;
        int currNegative = -1;

        for(int i = 0; i < arrayNum.length; i++) {
            if(arrayNum[i] > 0) {
                currPositive = i;
                if(i > 0) {
                    currNegative = i - 1;
                }
                break;
            }
            if(i == arrayNum.length - 1) {
                currNegative = i;
            }
        }

        int j = 0;
        while(currNegative >=0 || (currPositive >=0 && currPositive < arrayNum.length)) {
            if(currPositive >= 0 && currPositive < arrayNum.length) {
                if(currNegative >= 0) {
                    if(arrayNum[currPositive] >= abs(arrayNum[currNegative])) {
                        squareArray[j] = (int) pow(abs(arrayNum[currNegative]), 2);
                        currNegative--;
                    } else {
                        squareArray[j] = (int) pow(arrayNum[currPositive], 2);
                        currPositive++;
                    }
                } else {
                    squareArray[j] = (int) pow(arrayNum[currPositive], 2);
                    currPositive++;
                }
            } else {
                squareArray[j] = (int) pow(abs(arrayNum[currNegative]), 2);
                currNegative--;
            }
            j++;
        }

        for(int i = 0; i < squareArray.length; i++) {
            System.out.println(squareArray[i]);
        }
    }
}
