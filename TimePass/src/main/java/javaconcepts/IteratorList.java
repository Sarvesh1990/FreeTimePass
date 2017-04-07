package javaconcepts;

import java.util.*;

/**
 * Created by apple on 30/03/17.
 */
public class IteratorList {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);
        arrayList.add(5);

        Iterator i1 = arrayList.iterator();

        List<String> linkedList = new LinkedList<>();
        linkedList.add("n1");
        linkedList.add("n2");

        Iterator i2 = linkedList.iterator();

        Queue<Node> queue = new ArrayDeque();
        queue.add(new Node(11, 12));
        queue.add(new Node(11, 12));
        queue.add(new Node(11, 12));
        queue.add(new Node(11, 12));

        Iterator i3 = queue.iterator();

        List<Iterator> iteratorList = new LinkedList<>();
        iteratorList.add(i1);
        iteratorList.add(i2);
        iteratorList.add(i3);

        InterLeaveIterator interLeaveIterator = new InterLeaveIterator(iteratorList);

        interLeaveIterator.iterate();

    }

}
