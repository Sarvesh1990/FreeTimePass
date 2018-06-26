package string.english.integer;

/**
 * Created by apple on 25/02/17.
 */


public class NumberStringToWords {
    private static String[] ones = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
    private static String[] teens = {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private static String[] tens = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    private static String[] thousands = {"", "Thousand", "Million", "Billion"};

    public static void main(String[] args) {
        System.out.println(numberToWords(1001));
    }

    private static String numberToWords(int num) {
        if(num == 0) {
            return "Zero";
        }
        String numStr = numberToWordsHelper(num);
        return numStr.substring(0, numStr.length() - 1);
    }
    private static String numberToWordsHelper(int num) {
        String words = "";

        if(num/1000000000 != 0) {
            words = words + numberToWordsHelper(num/1000000000) + "Billion ";
            words = words + numberToWordsHelper(num % 1000000000);
            return words;
        }

        if(num/1000000 != 0) {
            words = words + numberToWordsHelper(num/1000000) + "Million ";
            words = words + numberToWordsHelper(num % 1000000);
            return words;
        }

        if(num/1000 != 0) {
            words = words + numberToWordsHelper(num/1000) + "Thousand ";
            words = words + numberToWordsHelper(num % 1000);
            return words;
        }

        if(num/100 != 0) {
            words = words + numberToWordsHelper(num/100) + "Hundred ";
            words = words + numberToWordsHelper(num % 100);
            return words;
        }

        if(num/10 > 1) {
            words = words + tens[num/10] + " ";
            words = words + (ones[num%10] != "" ? ones[num%10] + " " : "");
        } else {
            if(num/10 > 0) {
                words = words + teens[(num - 10)] + " ";
            } else {
                words = words + (ones[num] != "" ? ones[num] + " " : "");
            }
        }

        return words;
    }
}
