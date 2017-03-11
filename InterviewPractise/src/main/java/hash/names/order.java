package src.main.java.hash.names;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * Created by apple on 11/03/17.
 */
public class order {
    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<>();
        names.add("luis");
        names.add("hector");
        names.add("selena");
        names.add("emmanuel");
        names.add("amish");

        printSecondOrder(names);
    }

    private static void printSecondOrder(ArrayList<String> names) {
        Map<Character, String> characterMap = new HashMap<>();
        HashSet<Character> characterSet = new HashSet<>();
        for(int i = 0; i < names.size(); i++) {
            characterMap.put(names.get(i).charAt(names.get(i).length() - 1), names.get(i));
            characterSet.add(names.get(i).charAt(0));
        }
        System.out.println(characterMap);
        System.out.println(characterSet);
        for(int i = 0; i < names.size(); i++) {
            if(!characterSet.contains(names.get(i).charAt(names.get(i).length() - 1))) {
                String value = characterMap.get(names.get(i).charAt(0));
                System.out.println(names.get(i));
                while(value != null) {
                    System.out.println(value);
                    value = characterMap.get(value.charAt(0));
                }
                break;
            }

        }
    }
}
