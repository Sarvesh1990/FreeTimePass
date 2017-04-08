package lru;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by sarvesh on 7/4/17.
 */
public class Main {
    public static void main(String[] args) {
        Map<Integer, Integer> lruMap = new LinkedHashMap<Integer, Integer>(2, 1, true);
        lruMap.put(1, 1);
        lruMap.put(3, 3);
        lruMap.put(2, 3);
        lruMap.put(4, 3);
        lruMap.put(5, 3);
        lruMap.put(6, 3);

        lruMap.get(3);

        System.out.println(lruMap);
    }
}
