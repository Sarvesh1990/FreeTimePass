package string.anagram.sort.string;

import java.util.*;


/*
One way is to sort each string and keep sorted string as key.
Other way is to use hash. A normal hash function can be to assign prime number to each character and then multiply. Since prime they
won't repeat.
 */

public class AnagramBucketSortString {
    public static void main(String[] args) {
        AnagramBucketSortString ab = new AnagramBucketSortString();
        System.out.println(ab.groupAnagrams(new String[] {"eat", "tea", "tan", "ate", "nat", "bat"}));
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> sortedMap = new HashMap<>();
        for(int i = 0; i < strs.length; i++) {
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            String sorted = new String(chars);

            List<String> anagrams;
            if(sortedMap.containsKey(sorted)) {
                anagrams = sortedMap.get(sorted);
                anagrams.add(strs[i]);
            } else {
                anagrams = new LinkedList<>();
                anagrams.add(strs[i]);
                sortedMap.put(sorted, anagrams);
            }
        }

        List<List<String>> anagramList = new LinkedList<>();
        for(Map.Entry<String, List<String>> entry : sortedMap.entrySet()) {
            anagramList.add(entry.getValue());
        }

        return anagramList;
    }
}
