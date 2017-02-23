package linkedlist.loop;

/**
 * Created by apple on 18/02/17.
 */
public class Main {
    public static void main (String[] args) {
        LinkedList list = new LinkedList(10);
        Node first = new Node(11);
        Node second = new Node(2);
        list.push(first);
        list.push(second);
        list.push(new Node(14));
        list.push(new Node(7));
        Node abc = new Node(9);
//        abc.setNext(second);
        list.push(abc);

        System.out.println(list.loopExistAndRemove());
        list.printList();

    }
}
