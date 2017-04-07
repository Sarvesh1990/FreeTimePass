package string.english.integer;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by apple on 25/02/17.
 */
public class Main {
    private static String[] ones = {"", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
    private static String[] teens = {"ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
    private static String[] tens = {"", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};
    private static String[] thousands = {"", "thousand", "million", "billion"};

    public static void main(String[] args) {
        System.out.println(printEnglish(123456789));
    }

    private static String printEnglish(int number) {
        String words = "";
        if(number/1000000 != 0) {
            words = words + printEnglish(number/1000000) + "million ";
            words = words + printEnglish(number % 1000000)+" ";
            return words;
        }

        if(number/1000 != 0) {
            words = words + printEnglish(number/1000) + "thousands ";
            words = words + printEnglish(number % 1000)+" ";
            return words;
        }

        if(number/100 != 0) {
            words = words + printEnglish(number/100) + "hundred ";
            words = words + printEnglish(number % 100)+" ";
            return words;
        }

        if(number/10 > 1) {
            words = words + tens[number/10] + " ";
            words = words + ones[number%10]+ " ";
        } else {
            if(number/10 > 0) {
                words = words + teens[(number - 10)] + " ";
            } else {
                words = words + ones[number]+ " ";
            }
        }

        return words;
    }
}
