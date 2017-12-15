package LRUMap;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Created by apple on 15/12/17.
 */
public class LRUMap <K, V> extends LinkedHashMap<K, V> {
    public int capacity;

    public LRUMap(int capacity) {
        super(capacity);
        this.capacity = capacity;

    }

    public V addToLRUMap(K key, V value) {
        return super.put(key, value);
    }

    public V evict (K key) {
        return super.remove(key);
    }

    public V getKey(K key) {
        return super.get(key);
    }
}
