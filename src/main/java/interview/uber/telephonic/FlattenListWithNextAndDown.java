package interview.uber.telephonic;

import java.util.LinkedList;

/*
1------2------3------4
|             |
5--6          11--12--14
|  |              |
7  9--10          13
|
8

1 5 7 8 6 9 10 2 3 11 12 13 14 4
*/
public class FlattenListWithNextAndDown {
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        FlattenListWithNextAndDown ff = new FlattenListWithNextAndDown();
        ff.getFlattenList().print();

    }

    public Node getFlattenList() {
        Node root = new Node(1);
        root.down = new Node(5);
        root.down.down = new Node(7);
        root.down.down.down = new Node(8);
        root.down.down.next = new Node(6);
        root.down.down.next.down = new Node(9);
        root.down.down.next.down.next = new Node(10);
        root.next = new Node(2);

        return getFlattenList(root);
    }

    public Node getFlattenList(Node root) {
        System.out.println("Doing " + root.value);
        Node tail = root;
        if(root.down != null) {
            tail = getFlattenList(root.down);
        }
        if(root.next != null) {
            Node temp = getFlattenList(root.next);
            tail.next = root.next;
            tail = temp;
        }

        if(root.down != null)
            root.next = root.down;

        return tail;

    }

    public class Node {
        int value;
        Node next;
        Node down;

        public Node(int value) {
            this.value = value;
        }

        public void print() {
            Node head = this;
            while(head != null) {
                System.out.println(head.value);
                head = head.next;
            }
        }
    }
}
