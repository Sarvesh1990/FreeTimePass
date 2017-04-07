package stack.next.greater.element;

/**
 * Created by apple on 18/02/17.
 */
public class Stack {
    private Node head;
    private int size;

    public Stack(Integer value) {
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
        if(abc != null) {
            abc.setNext(head);
            head = abc;
            size++;
        }
    }

    public Node pop () {
        Node temp = head;
        if(head != null) {
            head = head.getNext();
            size--;
        }
        return temp;
    }

    public void printList() {
        Node temp = head;
        while(temp.getNext() != null) {
            System.out.println(temp.getValue() + " -> " + " -1 ");
            temp = temp.getNext();
        }
        System.out.println(temp.getValue() + " -> " + " -1 ");
    }

    public int getSize() {
        return size;
    }
}

