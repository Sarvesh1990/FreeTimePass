package string.justification;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by apple on 15/03/17.
 */
public class Main {
    public static void main(String[] args) {
        String str = "a b c d e";

        System.out.println("-101".substring(1, 2));
//        System.out.println(justify(str.split(" "), 1));
    }

    private static List<String> justify(String[] words, int maxWidth) {
        List<String> list = new LinkedList<>();
        int sum = 0;
        int start = 0;
        int sumSpaces = -1;
        for(int i = 0; i < words.length; i++) {
            sum = sum + words[i].length();
            sumSpaces = sumSpaces + 1;
            if(sum + sumSpaces > maxWidth) {
                i--;
                int numWords = i - start + 1;
                int extraChars = maxWidth - (sum + sumSpaces -1 - words[i+1].length());
                int space = 0;
                if(numWords > 1)
                    space = extraChars/(numWords - 1);
                String line = "";
                for(int j = start; j < i; j++) {
                    line = line + words[j] + " ";
                    for(int k = 0; k < space; k++) {
                        line = line + " ";
                    }
                    if(extraChars % (numWords - 1) > 0) {
                        line = line + " ";
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
                    line = line + words[j] + " ";
                }
                line = line + words[words.length - 1];
                list.add(line);
            }
        }
        return list;
    }
}

