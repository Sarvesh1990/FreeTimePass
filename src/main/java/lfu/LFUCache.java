package lfu;

import java.util.HashMap;
import java.util.Map;

public class LFUCache {
    int capacity;
    Map<Integer, Node> cache = new HashMap<>();
    Node start;
    Node end;
    int count;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        start = null;
        end = null;
    }

    public int get(int key) {
        if(cache.containsKey(key)) {
            Node node = cache.get(key);
            node.accessCount++;

            while(node.right != null && node.right.accessCount <= node.accessCount) {
                if(node != start) {
                    node.left.right = node.right;
                    node.right.left = node.left;

                    Node temp = node.right.right;
                    node.right.right = node;
                    node.left = node.right;
                    node.right = temp;
                } else {
                    Node temp = node.right.right;
                    node.left = node.right;
                    node.right.right = node;
                    node.right.left = null;
                    node.right = temp;

                    start = node.left;
                }
            }

            return node.value;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if(capacity ==  0) {
            return;
        }

        if(cache.containsKey(key)) {
            cache.get(key).value = value;
        } else {
            Node node = new Node(value, key);
            if(count < capacity) {
                if (start == null) {
                    start = node;
                } else {
                    node.right = start;
                    start.left = node;
                    start = node;
                }
                count++;
            } else {
                cache.remove(start.key);
                node.right = start.right;
                start.right = null;
                start = node;
            }
            cache.put(key, node);
        }
        get(key);
    }

    public class Node {
        private Node right;
        private Node left;
        private int value;
        private int accessCount;
        private int key;

        public Node(int value, int key) {
            this.value = value;
            this.key = key;
        }
    }

    public static void main(String[] args) {
        LFUCache lf = new LFUCache(2);
        lf.put(1, 1);
        lf.put(2, 2);
        System.out.println(lf.get(1));
        lf.put(3, 3);
        System.out.println(lf.get(2));
        System.out.println(lf.get(3));
        lf.put(4, 4);
        System.out.println(lf.get(1));
        System.out.println(lf.get(3));
        System.out.println(lf.get(4));
    }
}
