package maths;

import java.math.BigInteger;

/**
 * Created by sarvesh on 5/4/17.
 */
public class Power {
    public static void main(String[] args) {
        System.out.println(myPow(2, 2147483647));
    }

    public static double myPow(double x, int n) {
        Long newN = Long.valueOf(n);
        if(newN == 0) {
            return 1;
        }

        double result = 1;
        long current = 1;
        if(newN > 0) {
            result = x;
        } else {
            result = result / x;
        }

        while(Math.abs(newN) >= current*2) {
            result = result * result;
            current = current * 2;
        }

        for(long i = current + 1; i <= Math.abs(newN); i++) {
            if(newN < 0) {
                result = result / x;
            } else {
                result = result * x;
            }
        }
        return result;
    }
}
