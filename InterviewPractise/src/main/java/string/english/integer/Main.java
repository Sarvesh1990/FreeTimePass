package string.english.integer;

/**
 * Created by apple on 25/02/17.
 */
public class Main {
    private static String[] ones = {"", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
    private static String[] teens = {"ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
    private static String[] tens = {"", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};
    private static String[] thousands = {"", "thousand", "million", "billion"};

    public static void main(String[] args) {
        System.out.println(numberToWords(123456789));
    }

    private static String numberToWords(int num) {
        String words = "";
        if(num/1000000 != 0) {
            words = words + numberToWords(num/1000000) + " million";
            words = words + numberToWords(num % 1000000)+" ";
            return words;
        }

        if(num/1000 != 0) {
            words = words + numberToWords(num/1000) + " thousands";
            words = words + numberToWords(num % 1000)+" ";
            return words;
        }

        if(num/100 != 0) {
            words = words + numberToWords(num/100) + " hundred";
            words = words + numberToWords(num % 100)+" ";
            return words;
        }

        if(num/10 > 1) {
            words = words + tens[num/10] + " ";
            words = words + ones[num%10];
        } else {
            if(num/10 > 0) {
                words = words + teens[(num - 10)];
            } else {
                words = words + ones[num];
            }
        }

        return words;
    }
}
