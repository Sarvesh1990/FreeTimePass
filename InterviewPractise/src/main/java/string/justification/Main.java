package string.justification;

/**
 * Created by apple on 15/03/17.
 */
public class Main {
    public static void main(String[] args) {
        String str = "This is a example of text just ific ation and";
//        justify(str, 16);
       long sum = Long.valueOf(46340) * Long.valueOf(46340);
        System.out.println(sum);
        System.out.println(mySqrt(2147483647));
    }

    public static int mySqrt(int x) {
        long xLong = Long.valueOf(x);
        for(int i = 0; i <= xLong + 1; i++) {
            long sum = Long.valueOf(i) * Long.valueOf(i);
            if(sum > xLong) {
                return i - 1;
            }
        }
        return -1;

    }

    private static void justify(String str, int length) {
        String[] words = str.split(" ");
        int sum = 0;
        int start = 0;
        int sumSpaces = -1;
        for(int i = 0; i < words.length; i++) {
            sum = sum + words[i].length();
            sumSpaces = sumSpaces + 1;
            if(sum + sumSpaces > length) {
                i--;
                int numWords = i - start + 1;
                int extraChars = length - (sum + sumSpaces -1 - words[i+1].length());
                int space = extraChars/(numWords - 1);
                String line = "";
                for(int j = start; j < i; j++) {
                    line = line + words[j] + "+";
                    for(int k = 0; k < space; k++) {
                        line = line + "+";
                    }
                    if(extraChars % (numWords - 1) > 0) {
                        line = line + "+";
                        extraChars--;
                    }
                }
                line = line + words[i];
                System.out.println(line);
                sum = 0;
                sumSpaces = -1;
                start = i + 1;
            }
            if(i == words.length - 1) {
                String line = "";
                for(int j = start; j < words.length - 1; j++) {
                    line = line + words[j] + "+";
                }
                line = line + words[words.length - 1];
                System.out.println(line);
            }
        }
    }
}

