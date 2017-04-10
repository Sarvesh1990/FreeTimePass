package lru;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by sarvesh on 7/4/17.
 */
public class Main {
    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1, 2);
        lruCache.put(2, 3);
        lruCache.put(3, 4);
        System.out.println(lruCache.get(2));
        lruCache.put(4, 5);
        System.out.println(lruCache.get(2));
    }
}
