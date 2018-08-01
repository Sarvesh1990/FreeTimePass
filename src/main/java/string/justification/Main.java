package string.justification;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by apple on 15/03/17.
 */
public class Main {
    public static void main(String[] args) {
        String str = "a b c d e";
        System.out.println(new Main().fullJustify(str.split(" "), 1));
    }

    public List<String> fullJustify(String[] words, int maxWidth) {
        int currentLength = 0;
        int startIndex = 0;
        List<String> justifiedList = new LinkedList<>();

        for(int i = 0; i < words.length; i++) {
            if(currentLength + words[i].length() <= maxWidth) {
                currentLength += words[i].length() + 1;
            } else {
                i--;
                justify(words, startIndex, i, currentLength - 1, justifiedList, maxWidth);
                currentLength = 0;
                startIndex = i + 1;
            }
        }

        StringBuilder lastLine = new StringBuilder();
        int length = 0;
        for(int i = startIndex; i < words.length; i++) {
            lastLine.append(words[i]);
            length += words[i].length();

            if(i != words.length - 1) {
                lastLine.append(" ");
                length += 1;
            }
        }
        while(length < maxWidth) {
            lastLine.append(" ");
            length++;
        }

        justifiedList.add(lastLine.toString());

        return justifiedList;
    }

    public void justify(String words[], int startIndex, int endIndex, int currentLength, List<String> justifiedList, int maxWidth) {
        int extraSpaces = maxWidth - currentLength;
        int wordsCount = (endIndex - startIndex > 0) ? endIndex - startIndex : 1;
        int extra = extraSpaces % wordsCount;

        StringBuilder justifiedStr = new StringBuilder();

        for(int i = startIndex; i < endIndex; i++) {
            justifiedStr.append(words[i]);
            justifiedStr.append(" ");
            for(int j = 0; j < extraSpaces/wordsCount; j++) {
                justifiedStr.append(" ");
            }
            if((i - startIndex) <= extra - 1) {
                justifiedStr.append(" ");
            }
        }

        justifiedStr.append(words[endIndex]);

        if(startIndex == endIndex) {
            for(int j = 0; j < extraSpaces; j++) {
                justifiedStr.append(" ");
            }
        }

        justifiedList.add(justifiedStr.toString());

    }
}

