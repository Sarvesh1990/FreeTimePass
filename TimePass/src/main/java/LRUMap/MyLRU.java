package LRUMap;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by apple on 15/12/17.
 */
public class MyLRU <K, V> {
    private LRU<K, V> lru;
    private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    public MyLRU(int capacity) {
        lru = new LRU<K, V>(capacity);
    }

    public boolean add(K key, V value) {
        Lock lock = readWriteLock.writeLock();
        boolean isAdded = lru.add(key, value);
        lock.unlock();
        return isAdded;
    }

    public boolean evict(K key) {
        readWriteLock.writeLock();
        boolean isEvicted = lru.evict(key);
        readWriteLock.writeLock();
        return isEvicted;
    }

    public V get(K key) {
        readWriteLock.readLock();
        V value = lru.get(key);
        readWriteLock.readLock();
        return value;
    }
}
