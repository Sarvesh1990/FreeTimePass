package LRUMap;

/**
 * Created by sarvesh on 15/12/17.
 */
public interface LRU2<K,V> {
    void add(K key, V value);
    void evict (K key);
    V get (K key);
}
