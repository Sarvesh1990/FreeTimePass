package string.word.ladder;

import java.util.*;

/**
 * Created by apple on 06/04/17.
 */
public class Main {
    public static void main(String[] args) {
        List<String> dict = new ArrayList<>();
        dict.add("ab");
        dict.add("bb");
        dict.add("cc");
        dict.add("ca");

        System.out.println(ladderLength("ac", "ca", dict));
    }

    private static int ladderLength(String begin, String end, List<String> dict) {
        if(begin == end) {
            return 0;
        }

        Queue<String> queue = new LinkedList<>();
        Map<String, Integer> wordFound = new HashMap<>();

        queue.add(begin);

        while(!queue.isEmpty()) {
            String word = queue.poll();
            for(int i = 0; i < dict.size(); i++) {
                String dictWord = dict.get(i);
                if(!wordFound.containsKey(dictWord)) {
                    if (diff(word, dictWord) == 1) {
                        if (dictWord.equals(end)) {
                            return wordFound.get(word) != null ? wordFound.get(word) + 2 : 2;
                        } else {
                            queue.add(dictWord);
                            wordFound.put(dictWord, wordFound.get(word) != null ? wordFound.get(word) + 1 : 1);
                        }
                    }
                }
            }
            Iterator iter = queue.iterator();
            while (iter.hasNext()) {
                dict.remove(iter.next());
            }
            System.out.println(dict);
        }
        return 0;
    }

    private static int diff(String word, String dictWord) {
        int misMatch = 0;
        for(int i = 0; i < word.length(); i++) {
            if(word.charAt(i) != dictWord.charAt(i)) {
                misMatch++;
            }
        }
        return misMatch;
    }


}
