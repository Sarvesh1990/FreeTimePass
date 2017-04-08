package linkedlist.swap.node;

/**
 * Created by apple on 18/02/17.
 */
public class LinkedList {
    private Node head;
    private int size;

    public LinkedList(Integer value) {
        this.head = new Node(value);
        size = size + 1;
    }

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public void push (Node abc) {
        Node temp = head;
        while (temp.getNext() != null) {
            temp = temp.getNext();
        }
        temp.setNext(abc);
        size++;
    }

    public Node pop () {
        head = head.getNext();
        size--;
        return head;
    }

    public void printList() {
        Node temp = head;
        while(temp.getNext() != null) {
            System.out.println(temp.getValue());
            temp = temp.getNext();
        }
        System.out.println(temp.getValue());
    }

    public int getSize() {
        return size;
    }

    public void swapNode(Node first, Node second) {
        Node temp = head;
        boolean firstFound = false;
        boolean secondFound = false;

        while(temp != null) {
            if(temp == first) {
                firstFound = true;
            }
            if(temp == second) {
                secondFound = true;
            }

            if(firstFound && secondFound) {
                break;
            }

            temp = temp.getNext();
        }

        if(!firstFound || !secondFound) {
            System.out.println("Either one of node not found");
            return;
        }

        int tempInt = first.getValue();
        first.setValue(second.getValue());
        second.setValue(tempInt);
    }
}
