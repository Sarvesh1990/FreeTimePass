package linkedlist;

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

    public LinkedList() {
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

    public boolean loopExistAndRemove() {
        Node slowStart = head;
        Node fastStart = head;

        boolean loopExist = false;
        while(fastStart != null && fastStart.getNext() != null) {
            slowStart = slowStart.getNext();
            if(fastStart.getNext() == null) {
                return false;
            }
            fastStart = fastStart.getNext().getNext();

            if(fastStart == slowStart) {
                loopExist = true;
                break;
            }
        }
        if(loopExist) {
            slowStart = head;
            while(fastStart != slowStart) {
                slowStart = slowStart.getNext();
                fastStart = fastStart.getNext();
            }
            System.out.println(slowStart.getValue());
        }
        return loopExist;
    }
}

