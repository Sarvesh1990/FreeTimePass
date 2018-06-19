package linkedlist.swap.node;

/**
 * Created by apple on 18/02/17.
 */
public class Main {
    public static void main (String[] args) {
        LinkedList list = new LinkedList(10);
        Node first = new Node(12);
        Node second = new Node(13);
        list.push(first);
        list.push(second);
        System.out.println(list.getSize());
        list.printList();

        list.swapNode(list.getHead(), list.getHead());

        list.printList();
    }
}
