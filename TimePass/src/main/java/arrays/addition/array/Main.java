package arrays.addition.array;

/**
 * Created by apple on 26/02/17.
 */
public class Main {
    public static void main(String[] args) {
        add(new int[] {4, 2, 3}, new int[] {9, 9, 8, 3, 9});
    }

    private static void add(int[] num1, int[] num2) {
        int carryForward = 0;
        int num1Pos = num1.length - 1;
        int num2Pos = num2.length - 1;

        int[] finalArray = new int[num1.length + num2.length + 2];
        int finalArrayPos = finalArray.length - 1;

        while(num1Pos >= 0 || num2Pos >= 0) {
            int sum = 0;
            if(num1Pos >= 0 && num2Pos >= 0) {
                sum = carryForward + num1[num1Pos] + num2[num2Pos];
                num1Pos--;
                num2Pos--;
            } else if(num1Pos >= 0) {
                sum = carryForward + num1[num1Pos];
                num1Pos--;
            } else {
                sum = carryForward + num2[num2Pos];
                num2Pos--;
            }
            carryForward = sum / 10;
            finalArray[finalArrayPos] = (sum >= 10) ? sum % 10 : sum;
            finalArrayPos--;
        }

        if(carryForward > 0) {
            finalArray[finalArrayPos] = carryForward;
        }

        for(int i = 0 ; i < finalArray.length; i++) {
            if(finalArray[i] >= 0 ) {
                System.out.println(finalArray[i]);
            }
        }
    }
}
