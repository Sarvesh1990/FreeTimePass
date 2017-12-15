package LRUMap;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Created by apple on 15/12/17.
 */
public class LRUMap <K, V> {
    private Map<K, V> linkedMap;
    private CustomLinkedList customLinkedList;

    public LRUMap(int capacity) {
        this.linkedMap = new HashMap<K, V>();
        this.customLinkedList = new CustomLinkedList(capacity);
    }

    public boolean addToLRUMap(K key, V value) {
        return false;
    }

    public boolean evict (K key) {
        return false;
    }

    public V get (K key) {
        return linkedMap.get(key);
    }
}
