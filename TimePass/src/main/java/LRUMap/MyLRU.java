package LRUMap;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by apple on 15/12/17.
 */
public class MyLRU <K, V> implements LRU<K, V>{
    private LRUMap<K, V> lruMap;
    private ReentrantLock lock = new ReentrantLock();

    public MyLRU(int capacity) {
        lruMap = new LRUMap<K, V>(capacity);
    }

    public void add(K key, V value) {
        lock.lock();
        lruMap.addToLRUMap(key, value);
        lock.unlock();
    }

    public void evict(K key) {
        lock.lock();
        lruMap.evict(key);
    }

    public V get(K key) {
        lock.lock();
        V value = lruMap.get(key);
        return value;
    }
}
