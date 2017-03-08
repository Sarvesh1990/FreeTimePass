package binaryTree;

/**
 * Created by apple on 25/02/17.
 */
public class Main {
    public static void main(String[] args) {
        BT bt = new BT(10);
        bt.head.left = new Node(11);
        bt.head.right = new Node(12);
        bt.head.left.left = new Node(13);
        bt.head.right.left = new Node(11);
        bt.head.right.right = new Node(14);

        bt.printStack(bt.head);
    }
}
