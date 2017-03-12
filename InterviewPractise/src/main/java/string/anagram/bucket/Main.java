package src.main.java.string.anagram.bucket;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * Created by apple on 12/03/17.
 */
public class Main {
    public static void main(String[] args) {
        ArrayList<String> stringList = new ArrayList<>();
        stringList.add("pear");
        stringList.add("pear");
        stringList.add("amleth");
        stringList.add("dormitory");
        stringList.add("tinsel");
        stringList.add("dirty room");
        stringList.add("hamlet");
        stringList.add("listen");
        stringList.add("silent");

        Map<Integer, TreeSet<String>> list = findAnagrams(stringList);

        for(Integer key : list.keySet()) {
            System.out.println(list.get(key));
        }
    }

    private static Map<Integer, TreeSet<String>> findAnagrams(ArrayList<String> stringList) {
        Map<Integer, TreeSet<String>> bucket = new HashMap<>();
        for(int i = 0; i < stringList.size(); i++) {
            String str = stringList.get(i);
            int bitNumber = 0;
            for(int j = 0; j < str.length(); j++) {
                if(str.charAt(j) >= 97 && str.charAt(j) <= 122) {
                    bitNumber = (int) (bitNumber + Math.pow(2, (str.charAt(j) - 97)));
                }
            }
            if(bucket.containsKey(bitNumber)) {
                bucket.get(bitNumber).add(str);
            } else {
                bucket.put(bitNumber, new TreeSet<String>(){
                    {
                        add(str);
                    }
                });
            }
        }
        return bucket;
    }
}


