package string.decoding;

/**
 * Created by sarvesh on 6/4/17.
 */
public class Main {
    public static void main(String[] args) {
        String str = "101";
        System.out.println(numDecodings(str));
    }

    private static int numDecodings(String str) {
        int[] numDecodingsArray = new int[str.length() + 1];
        if(str.length() == 0) {
            return 0;
        }
        numDecodingsArray[0] = 1;
        for(int i = str.length() - 1; i >= 0; i--) {
            if(str.charAt(i) - '0' > 0) {
                numDecodingsArray[str.length() - i] = numDecodingsArray[str.length() - i - 1];
            }
            if(i < str.length() - 1) {
                if(((str.charAt(i) - '0') * 10 + str.charAt(i + 1) - '0') <= 26 && ((str.charAt(i) - '0') > 0)) {
                    numDecodingsArray[str.length() - i] = numDecodingsArray[str.length() - i] + numDecodingsArray[str.length() - i - 2];
                }
            }
        }
        return numDecodingsArray[str.length()];
    }
}
