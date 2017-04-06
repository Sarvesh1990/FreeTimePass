package string.edit.distance.one;

/**
 * Created by apple on 28/03/17.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(findIfSingleEditDistance("acat", "cut"));
    }

    //Take absolute difference of the length of both string
    //If difference is 1, return true
    //If difference > 1, return false
    //If difference == 0
    //loop from 0 to length -1
    //Keep a count of mismatching character at index 1
    // If count = 1 - return true;
    //Otherwise false

    private static boolean findIfSingleEditDistance(String str1, String str2) {
        if(Math.abs(str1.length() - str2.length()) > 1) {
            return false;
        } else if(Math.abs(str1.length() - str2.length()) == 0) {
            int count = 0;
            for(int i = 0; i < str1.length(); i++) {
                if(str1.charAt(i) != str2.charAt(i)) {
                    count++;
                }
            }
            if(count == 1) {
                return true;
            } else {
                return false;
            }
        } else {
            int minLength = Math.min(str1.length(), str2.length());
            int count = 0;
            int j = 0;
            String st1Temp = str1.length() == minLength ? str1 : str2;
            String st2Temp = str1.length() == minLength ? str2 : str1;

            for(int i = 0; i < minLength; i++) {
                if(st1Temp.charAt(i) != st2Temp.charAt(j)) {
                    count++;
                    if(count > 1) {
                        return false;
                    } else {
                        j++;
                        i--;
                    }
                } else {
                    j++;
                }
            }
            return true;
        }
    }
}
