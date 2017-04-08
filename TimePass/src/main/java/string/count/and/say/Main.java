package string.count.and.say;

/**
 * Created by sarvesh on 5/4/17.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(countAndSay(6));
    }

    public static String countAndSay(int n) {
        if(n == 1) {
            return "1";
        }
        String current = "1";
        for(int i = 2; i <= n; i++) {
            String currentString = "";
            int count = 1;
            int currentChar = current.charAt(0) - '0';
            for(int j = 1; j < current.length(); j++) {
                if((current.charAt(j) - '0') == currentChar) {
                    count++;
                } else {
                    currentString = currentString + String.valueOf(count) + String.valueOf(currentChar);
                    count = 1;
                    currentChar = current.charAt(j) - '0';
                }
            }
            currentString = currentString + String.valueOf(count) + String.valueOf(currentChar);
            current = currentString;
        }
        return current;
    }
}
