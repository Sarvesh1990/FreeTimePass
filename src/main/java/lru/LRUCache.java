package lru;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by apple on 10/04/17.
 */
public class LRUCache {
    public int capacity;
    public Map<Integer, Integer> map;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new LinkedHashMap<Integer, Integer>(capacity, 0.75f, true);
    }

    public int get(int key) {
        if(map.containsKey(key)) {
            int value = map.get(key);
            map.remove(key);
            map.put(key, value);
            return value;
        }
        return -1   ;
    }

    public void put(int key, int value) {
        if(capacity == 0) {
            return;
        }

        if(map.containsKey(key)) {
            map.remove(key);
            map.put(key, value);
        }
        if(map.size() < capacity) {
            map.put(key, value);
        } else {
            int firstKey = map.keySet().iterator().next();
            map.remove(firstKey);
            map.put(key, value);
        }
        return;
    }
}