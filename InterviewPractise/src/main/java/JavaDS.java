import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Stack;

/**
 * Created by apple on 26/02/17.
 */
public class JavaDS {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);

        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.get(0);
        
        Stack stack = new Stack();
        stack.push(1);

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.add(2);
        queue.add(3);
        queue.add(1);
        queue.add(4);

        System.out.println(queue.peek());
    }
}

