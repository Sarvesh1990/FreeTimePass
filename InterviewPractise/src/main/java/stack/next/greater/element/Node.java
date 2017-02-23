package stack.next.greater.element;

/**
 * Created by apple on 18/02/17.
 */
public class Node {
    private Integer value;
    private Node next;

    public Node(Integer value) {
        this.value = value;
    }

    public Node(Integer value, Node next) {
        this.value = value;
        this.next = next;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
