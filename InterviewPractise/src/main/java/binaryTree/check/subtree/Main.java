package binaryTree.check.subtree;

import binaryTree.BT;
import binaryTree.Node;

/**
 * Created by sarvesh on 12/3/17.
 */
public class Main {
    public static void main(String[] args) {
        BT bt1 = new BT(10);
        BT bt2 = new BT(26);

        bt1.head.left = new Node(4);
        bt1.head.right = new Node(6);
        bt1.head.left.right = new Node(30);

        bt2.head.left = new Node(10);
        bt2.head.left.right = new Node(6);
        bt2.head.left.left = new Node(4);
        bt2.head.left.left.right = new Node(30);
        bt2.head.right = new Node(3);

        System.out.println(checkIfSubTree(bt1.head, bt2.head, bt1.head));

    }

    private static boolean checkIfSubTree(Node head1, Node head2, Node head) {
        if(head1 == null && head2 == null) {
            return true;
        } else if (head1 == null || head2 == null) {
            if(head1 != null) {
            } else {
            }
            return false;
        }

        if(head1.value == head2.value) {
            System.out.println("Value match " + head1.value);
            return checkIfSubTree(head1.left, head2.left, head) && checkIfSubTree(head1.right, head2.right, head);
        } else {
            System.out.println("Value not match " + head1.value);
            return checkIfSubTree(head, head2.left, head) || checkIfSubTree(head, head2.right, head);
        }
    }

}
