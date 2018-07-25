package graph.alien.dictionary;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class AlienDict {
    public static void main(String[] args) {
        AlienDict ad = new AlienDict();
        System.out.println(ad.alienOrder(new String[] {"z", "z"}));
    }

    public String alienOrder(String[] words) {
        int[][] order = new int[26][26];
        boolean[] charsIncluded = new boolean[26];

        buildDependency(words, order);
        buildCharsIncl(words, charsIncluded);

        return topoSort(order, charsIncluded);
    }

    private void buildDependency(String[] words, int[][] order) {
        if(words.length == 0 || words.length == 1) {
            return;
        }
        for(int i = 0; i < words.length - 1; i++) {
            if(words[i].charAt(0) != words[i + 1].charAt(0)) {
                order[words[i].charAt(0) - 'a'][words[i + 1].charAt(0) - 'a'] = 1;
            }
        }

        ArrayList<String> wordList  = new ArrayList<>();

        for(int i = 0; i < words.length - 1; i++) {
            if(words[i].charAt(0) == words[i + 1].charAt(0)) {
                if(words[i].length() > 1)
                    wordList.add(words[i].substring(1, words[i].length()));
            } else {
                if(words[i].length() > 1)
                    wordList.add(words[i].substring(1, words[i].length()));
                String[] wordStrArray = wordList.toArray(new String[wordList.size()]);
                buildDependency(wordStrArray, order);
                wordList = new ArrayList<>();
            }
        }
        if(words[words.length - 1].length() > 1)
            wordList.add(words[words.length - 1].substring(1, words[words.length - 1].length()));
        String[] wordStrArray = wordList.toArray(new String[wordList.size()]);
        buildDependency(wordStrArray, order);
    }

    private void buildCharsIncl(String[] words, boolean[] chars) {
        for(String word : words) {
            for(int i = 0; i < word.length(); i++) {
                chars[word.charAt(i) - 'a'] = true;
            }
        }
    }

    private String topoSort(int[][] order, boolean[] charsIncluded) {
        boolean[] visitedCurrent = new boolean[26];
        boolean[] visited = new boolean[26];
        LinkedList<Character> orderList= new LinkedList();

        for(int i = 0; i < 26; i++) {
            if(!visited[i] && charsIncluded[i]) {
                int isCyclic = topoSortHelper(order, visited, i, orderList, visitedCurrent);
                if(isCyclic == -1) {
                    return "";
                }
            }
        }

        return listToString(orderList);
    }

    private int topoSortHelper(int[][] order, boolean[] visited, int index, List<Character> orderList, boolean[] visitedCurrent) {
        visitedCurrent[index] = true;
        for(int i = 0; i < 26; i++) {
            if(order[index][i] == 1 && !visited[i]) {
                if(visitedCurrent[i]) {
                    return -1;
                } else {
                    int isCyclic = topoSortHelper(order, visited, i, orderList, visitedCurrent);
                    if(isCyclic == -1) {
                        return -1;
                    }
                }
            }
        }
        visited[index] = true;
        visitedCurrent[index] = false;
        orderList.add((char) (index + 'a'));
        return 0;
    }

    private String listToString(List<Character> characterList) {
        StringBuilder builder = new StringBuilder();
        for(Character ch : characterList) {
            builder.append(ch);
        }

        return builder.reverse().toString();
    }
}
