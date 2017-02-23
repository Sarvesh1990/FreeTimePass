package bst;

/**
 * Created by apple on 20/02/17.
 */
public class BST {
    public Node head;

    public BST(int value) {
        this.head = new Node(value);
    }

    public void insert(int value, Node head) {
        if(value <= head.value) {
            if(head.left == null) {
                head.left = new Node(value);
            } else {
                insert(value, head.left);
            }
        } else {
            if(head.right == null) {
                head.right = new Node(value);
            } else {
                insert(value, head.right);
            }
        }
    }

    public void print(Node head) {
        if(head == null) {
            return;
        }
        print(head.left);
        System.out.println(head.value + " ");
        print(head.right);
    }
}
