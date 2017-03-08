package linkedlist.print.backward;

import linkedlist.LinkedList;
import linkedlist.Node;

/**
 * Created by apple on 25/02/17.
 */
public class Main {
    public static void main(String[] args) {
        LinkedList list = new LinkedList(19);
        list.push(new Node(12));
        list.push(new Node(13));
        list.push(new Node(11));
        list.push(new Node(10));
        list.push(new Node(5));
        list.push(new Node(4));
        list.push(new Node(3));
        list.push(new Node(16));

        reverseList(list.getHead());
    }

    private static void reverseList(Node node) {
        if(node == null) {
            return;
        }
        reverseList(node.getNext());
        System.out.println(node.getValue());
    }
}
