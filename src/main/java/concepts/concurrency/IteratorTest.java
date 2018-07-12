package concepts.concurrency;

import java.util.*;

public class IteratorTest {
    public static void main(String[] args) {
        LinkedList<Integer> integers = new LinkedList<>();
        integers.add(10);

        Iterator<Integer> iter = integers.iterator();

        while(iter.hasNext()) {
            iter.remove();
        }
    }
}
