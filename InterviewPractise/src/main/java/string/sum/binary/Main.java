package string.sum.binary;

/**
 * Created by apple on 05/04/17.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(addBinary("1010", "1011"));
    }

    public static String addBinary(String a, String b) {
        int carryForward = 0;
        int i = a.length() - 1;
        int j = b.length() - 1;
        StringBuilder finalString = new StringBuilder();
        while(i >= 0 && j >= 0) {
            int digit1 = a.charAt(i) - '0';
            int digit2 = b.charAt(j) - '0';
            int sum = digit1 + digit2 + carryForward;
            if(sum == 0) {
                finalString.append("0");
                carryForward = 0;
            } else if(sum == 1) {
                finalString.append("1");
                carryForward = 0;
            } else if (sum == 2){
                finalString.append("0");
                carryForward = 1;
            } else {
                finalString.append("1");
                carryForward = 1;
            }
            i--;
            j--;
        }
        while(i >= 0) {
            int digit1 = a.charAt(i) - '0';
            int sum = digit1 + carryForward;
            if(sum == 0) {
                finalString.append("0");
                carryForward = 0;
            } else if(sum == 1) {
                finalString.append("1");
                carryForward = 0;
            } else if (sum == 2){
                finalString.append("0");
                carryForward = 1;
            } else {
                finalString.append("1");
                carryForward = 1;
            }
            i--;
        }
        while(j >= 0) {
            int digit2 = b.charAt(j) - '0';
            int sum = digit2 + carryForward;
            if(sum == 0) {
                finalString.append("0");
                carryForward = 0;
            } else if(sum == 1) {
                finalString.append("1");
                carryForward = 0;
            } else if (sum == 2){
                finalString.append("0");
                carryForward = 1;
            } else {
                finalString.append("1");
                carryForward = 1;
            }
            j--;
        }
        if(carryForward > 0) {
            finalString.append("1");
        }
        return finalString.reverse().toString();

    }
}
