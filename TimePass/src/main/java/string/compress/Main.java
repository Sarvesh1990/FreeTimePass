package string.compress;

/**
 * Created by sarvesh on 11/3/17.
 */
public class Main {
    public static void main(String[] args) {
        String originalStr = "abb";
        compress(originalStr);
    }

    private static void compress(String originalStr) {
        if(originalStr.length() == 0) {
            System.out.println("No character in current string");
            return;
        }
        int count = 1;
        Character currChar = originalStr.charAt(0);
        for(int i = 1; i < originalStr.length(); i++) {
            if(originalStr.charAt(i) == currChar ) {
                count++;
            } else {
                System.out.println(currChar + " " + count);
                count = 1;
                currChar = originalStr.charAt(i);
            }
        }
        System.out.println(currChar + " " + count);
    }
}
