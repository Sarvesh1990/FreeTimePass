package LRUMap;

import java.util.LinkedList;
import java.util.jar.Pack200;

/**
 * Created by apple on 15/12/17.
 */
public class CustomLinkedList <K> {
    public LinkedList list;
    public CustomLinkedList(int capacity) {
        this.list = new LinkedList();
    }

    public void get (K key) {
        list.remove(key);
        moveToFront(key);
    }

    public void moveToFront(K key) {
        synchronized (list) {
            list.add(key);
        }
    }
}
