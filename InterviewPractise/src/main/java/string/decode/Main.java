package string.decode;

/**
 * Created by apple on 25/02/17.
 */
public class Main {
    public static void main(String[] args) {
        String stringToDecode = "3[a3[b]g4[ef]h]";
        System.out.println(decode(stringToDecode, 0, stringToDecode.length() - 1));
    }

    private static String decode(String s, int start, int end) {
        if(start == end) {
            return String.valueOf(s.charAt(start));
        }
        String decodedString = "";
        for(int i = start; i <= end; i++) {
            if(s.charAt(i) >= 'a' && s.charAt(i) <= 'z') {
                decodedString = decodedString + s.charAt(i);
            } else {
                int count = Integer.parseInt(String.valueOf(s.charAt(i)));
                String temp = "";
                int startBracketCount = 0;
                int endBracketCount = 0;

                for(int j = i + 1; j <= end; j++) {
                    if(s.charAt(j) == '[') {
                        startBracketCount++;
                    }
                    if(s.charAt(j) == ']') {
                        endBracketCount++;
                        if(endBracketCount == startBracketCount) {
                            temp = decode(s, i + 2, j - 1);
                            i = j;
                            break;
                        }
                    }
                }
                for(int j = 0; j < count; j++) {
                    decodedString = decodedString + temp;
                }
            }
        }
        return decodedString;
    }
}

