package arrays.divisible.three;

import java.util.Arrays;

/**
 * Created by sarvesh on 12/3/17.
 */
public class Main {
    public static void main(String[] args) {
        int[] number = new int[] {9, 1, 1};
        findGreatestDivisibleThree(number);
    }

    private static void findGreatestDivisibleThree(int[] number) {
        Arrays.sort(number);
        int sum = 0;
        for(int i = 0; i < number.length; i++) {
            sum = sum + number[i];
        }
        if(sum % 3 == 0) {
            System.out.println(number);
        }  else {
            boolean found = false;
            for (int i = number.length -1 ; i >= 0; i--) {
                if((sum - number[i]) % 3 == 0) {
                    System.out.println(number[i]);
                    found = true;
                    break;
                }
            }
            if(!found) {
                for(int i = number.length - 1; i >= 1; i--) {
                    for(int j = i - 1; j >= 0; j--) {
                        if((sum - number[i] - number[j]) % 3 == 0) {
                            System.out.println(number[i] + " " + number[j]);
                        }
                    }
                }
            }
        }
    }
}
