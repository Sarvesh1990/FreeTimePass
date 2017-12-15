package string.fraction.to.decimal;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by apple on 23/04/17.
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(fractionToDecimal(1, 20));
    }
    public static String fractionToDecimal(int numerator, int denominator) {
        long num = Long.valueOf(numerator);
        long den = Long.valueOf(denominator);
        String fraction = "0";
        if(num == 0) {
            return fraction;
        }
        boolean negative = false;
        if(num < 0 && den > 0) {
            negative = true;
            num = Math.abs(num);
        }

        if(num >= den) {
            fraction = "" + num / den;
            num = num - (num / den) * den;
            if(num == 0) {
                if(negative) {
                    fraction = "-" + fraction;
                }
                return fraction;
            }
        }

        fraction = fraction + ".";

        num = num * 10;

        Map<Long, Long> divisionMap = new LinkedHashMap<>();
        divisionMap.put(num, num/den);

        long temp = (num - (num / den) * den) * 10;

        while(!divisionMap.containsKey(temp) && temp != 0) {
            num = temp;
            divisionMap.put(num, num/den);
            temp = (num - (num / den) * den) * 10;
        }

        for(Long numer : divisionMap.keySet()) {
            if(numer == temp && temp != 0) {
                fraction = fraction + "(" + divisionMap.get(numer);
            } else {
                fraction = fraction + divisionMap.get(numer);
            }
        }

        if(temp != 0) {
            fraction = fraction + ")";
        }

        if(negative) {
            fraction = "-" + fraction;
        }
        return fraction;
    }
}
