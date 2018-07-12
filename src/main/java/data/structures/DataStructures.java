package data.structures;

import LRUMap.LRU;

import java.util.*;

public class DataStructures {
    public static void main(String[] args) {
//        tryStack();
//        tryQueue();
//        tryPriorityQueue();
//        tryLinkedHashMap();
//        tryTreeMap();
//        tryTreeSet();
        tryLinkedSet();
        sort();
    }

    private static void sort() {
        Collections.sort(new LinkedList<Integer>());
        LinkedList<Test> list = new LinkedList<>();
        list.add(new Test(3, "abc"));
        list.add(new Test(1, "cde"));
        list.add(new Test(2, "feg"));
        Collections.sort(list, DataStructures.ValueComp);

        System.out.println(list.removeFirst().value + " " + list.removeFirst().value);

    }

    public static Comparator<Test> ValueComp = new Comparator<Test>() {

        @Override
        public int compare(Test e1, Test e2) {
            return e1.value - e2.value;
        }
    };


    private static void tryLinkedSet() {
        Set<Integer> linkedSet = new LinkedHashSet<>();
        linkedSet.add(1);
        linkedSet.add(3);
        linkedSet.add(2);

        for(Integer integer : linkedSet) {
            System.out.println(integer);
        }

        return;
    }

    private static void tryTreeSet() {
        Set<Test> treeSet = new TreeSet<>(new Test());
        treeSet.add(new Test(1, "abc"));
        treeSet.add(new Test(3, "abc"));
        treeSet.add(new Test(2, "abc"));

        for(Test test : treeSet) {
            System.out.println(test.value);
        }

        return;
    }

    private static void tryTreeMap() {
        Map<Test, Integer> treeMap = new TreeMap<Test, Integer>(new Test());
        treeMap.put(new Test(3, "abc"), 2);
        treeMap.put(new Test(1, "cde"), 5);
        treeMap.put(new Test(2, "feg"), 3);

        for(Map.Entry entry : treeMap.entrySet()) {
            System.out.println(((Test) entry.getKey()).value + " " + entry.getValue());
        }

        return;
    }

    private static void tryLinkedHashMap() {
        Map<Integer, Integer> linkedHashMap = new LinkedHashMap<Integer, Integer>(2, 1, true);
        linkedHashMap.put(1, 2);
        linkedHashMap.put(2, 3);
        linkedHashMap.put(3, 4);
        linkedHashMap.put(2, 5);

        for(Map.Entry entry : linkedHashMap.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }

    private static void tryPriorityQueue() {
        Queue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        queue.add(1);
        queue.add(2);
        queue.add(3);
        System.out.println(queue.peek());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
    }

    private static void tryQueue() {
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);
        System.out.println(queue.peek());
        /*
        If defined as queue, you need to cast it.
         */
//        System.out.println(((LinkedList<Integer>) queue).pop());
        System.out.println(queue.remove());
        System.out.println(queue.removeLast());
        System.out.println(queue.removeFirst());

    }

    private static void tryStack() {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        System.out.println(stack.peek());
        System.out.println(stack.pop());
    }
}
