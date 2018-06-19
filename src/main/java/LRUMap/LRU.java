package LRUMap;

/**
 * Created by apple on 15/12/17.
 */
public interface LRU <K, V> {
    void add(K key, V value);
    void evict (K key);
    V get (K key);
}
