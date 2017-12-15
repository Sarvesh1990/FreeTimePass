package LRUMap;

/**
 * Created by apple on 15/12/17.
 */
public class LRU <K, V> {
    public LRUMap myLRUMap;
    public Integer capacity;

    public LRU (int capacity) {
        this.capacity = capacity;
        this.myLRUMap = new LRUMap(capacity);
    }

    public boolean add (K key, V value) {
        return myLRUMap.addToLRUMap(key, value);
    }

    public boolean evict (K key) {
        return myLRUMap.evict(key);
    }

    public V get (K key) {
        return (V) myLRUMap.get(key);
    }
}
