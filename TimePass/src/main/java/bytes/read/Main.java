package bytes.read;

/**
 * Created by sarvesh on 7/4/17.
 */
public class Main {
    public static String str = "abcdefghijkl";
    public static int currentPos = 0;
    public static int bufsize = 0;

    public static void main(String[] args) {
        System.out.println(read(5));
        System.out.println(read(4));
        System.out.println(read(4));
    }

    private static int read(int n) {
        boolean eof = false;
        int readChar = 0;
        while(!eof && readChar < n) {
            int value = bufsize > 0 ? bufsize : read4();
            if(bufsize == 0 && value < 4) {
                eof = true;
            }
            int bytes =  Math.min(n - readChar, value);
            readChar = readChar + bytes;
            bufsize = value - bytes;

        }
        return readChar;
    }

    private static int read4() {
        if (str.length() > currentPos + 4) {
            currentPos = currentPos + 4;
            return 4;
        } else {
            int value = str.length() - currentPos;
            currentPos = str.length();
            return value;
        }
    }

}
